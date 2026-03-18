package com.cs2tactic.api.map.service.impl;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cs2tactic.api.common.dto.DataResult;
import com.cs2tactic.api.common.dto.Result;
import com.cs2tactic.api.common.dto.SuccessDataResult;
import com.cs2tactic.api.common.dto.SuccessResult;
import com.cs2tactic.api.map.dto.CreateMapRequest;
import com.cs2tactic.api.map.dto.MapResponse;
import com.cs2tactic.api.map.dto.UpdateMapRequest;
import com.cs2tactic.api.map.entity.Map;
import com.cs2tactic.api.map.mapper.MapMapper;
import com.cs2tactic.api.map.repository.MapRepository;
import com.cs2tactic.api.map.service.MapService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapServiceImpl implements MapService {

    private final MapRepository mapRepository;
    private final MapMapper mapMapper;

    @Override
    public DataResult<List<MapResponse>> getAll() {
        return new SuccessDataResult<>(
                mapRepository.findAll()
                        .stream()
                        .map(mapMapper::toResponse)
                        .toList()
        );
    }

    @Override
    public DataResult<MapResponse> getById(UUID id) {
        return new SuccessDataResult<>(
                mapRepository.findById(id)
                        .map(mapMapper::toResponse)
                        .orElseThrow(() -> new NoSuchElementException("Map not found: " + id))
        );
    }

    @Override
    public DataResult<MapResponse> getByMapKey(String mapKey) {
        return new SuccessDataResult<>(
                mapRepository.findByMapKeyAndIsDeletedFalse(mapKey)
                        .map(mapMapper::toResponse)
                        .orElseThrow(() -> new NoSuchElementException("Map not found: " + mapKey))
        );
    }

    @Override
    public DataResult<MapResponse> create(CreateMapRequest request) {
        Map map = mapMapper.toEntity(request);
        return new SuccessDataResult<>(mapMapper.toResponse(mapRepository.save(map)));
    }

    @Override
    public DataResult<MapResponse> update(UUID id, UpdateMapRequest request) {
        Map map = mapRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Map not found: " + id));
        mapMapper.updateEntity(request, map);
        return new SuccessDataResult<>(mapMapper.toResponse(mapRepository.save(map)));
    }

    @Override
    public Result delete(UUID id) {
        Map map = mapRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Map not found: " + id));
        mapRepository.delete(map);
        return new SuccessResult("Map deleted successfully");
    }
}
