package com.cs2tactic.api.map.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cs2tactic.api.common.exception.ResourceNotFoundException;
import com.cs2tactic.api.map.dto.CreateMapRequest;
import com.cs2tactic.api.map.dto.MapResponse;
import com.cs2tactic.api.map.dto.UpdateMapRequest;
import com.cs2tactic.api.map.entity.Map;
import com.cs2tactic.api.map.exception.MapErrorCode;
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
    @Cacheable(value = "maps", key = "'all'")
    public List<MapResponse> getAll() {
        return mapRepository.findAll()
                .stream()
                .map(mapMapper::toResponse)
                .toList();
    }

    @Override
    @Cacheable(value = "maps", key = "'id:' + #id")
    public MapResponse getById(UUID id) {
        return mapRepository.findById(id)
                    .map(mapMapper::toResponse)
                    .orElseThrow(() -> new ResourceNotFoundException(MapErrorCode.MAP_NOT_FOUND, id));
    }

    @Override
    @Cacheable(value = "maps", key = "'key:' + #mapKey")
    public MapResponse getByMapKey(String mapKey) {
        return mapRepository.findByMapKeyAndIsDeletedFalse(mapKey)
                        .map(mapMapper::toResponse)
                        .orElseThrow(() -> new ResourceNotFoundException(MapErrorCode.MAP_NOT_FOUND, mapKey));
    }

    @Override
    @CacheEvict(value = "maps", allEntries = true)
    public MapResponse create(CreateMapRequest request) {
        Map map = mapMapper.toEntity(request);
        return mapMapper.toResponse(mapRepository.save(map));
    }

    @Override
    @CacheEvict(value = "maps", allEntries = true)
    public MapResponse update(UUID id, UpdateMapRequest request) {
        Map map = mapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MapErrorCode.MAP_NOT_FOUND, id));
        mapMapper.updateEntity(request, map);
        return mapMapper.toResponse(mapRepository.save(map));
    }

    @Override
    @CacheEvict(value = "maps", allEntries = true)
    public void delete(UUID id) {
        Map map = mapRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(MapErrorCode.MAP_NOT_FOUND, id));
        mapRepository.delete(map);
    }
}
