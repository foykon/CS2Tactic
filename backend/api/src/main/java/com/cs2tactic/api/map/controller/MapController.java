package com.cs2tactic.api.map.controller;

import com.cs2tactic.api.common.dto.DataResult;
import com.cs2tactic.api.common.dto.Result;
import com.cs2tactic.api.common.dto.SuccessDataResult;
import com.cs2tactic.api.common.dto.SuccessResult;
import com.cs2tactic.api.map.dto.CreateMapRequest;
import com.cs2tactic.api.map.dto.MapResponse;
import com.cs2tactic.api.map.dto.UpdateMapRequest;
import com.cs2tactic.api.map.service.MapService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/maps")
@RequiredArgsConstructor
public class MapController {

    private final MapService mapService;

    @GetMapping
    public ResponseEntity<DataResult<List<MapResponse>>> getAll() {
        return ResponseEntity.ok(new SuccessDataResult<>(mapService.getAll(), "Maps listed"));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<MapResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(new SuccessDataResult<>(mapService.getById(id), "Map retrieved"));
    }

    @GetMapping("/key/{mapKey}")
    public ResponseEntity<DataResult<MapResponse>> getByMapKey(@PathVariable String mapKey) {
        return ResponseEntity.ok(new SuccessDataResult<>(mapService.getByMapKey(mapKey), "Map retrieved"));
    }

    @PostMapping
    public ResponseEntity<DataResult<MapResponse>> create(@RequestBody @Valid CreateMapRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessDataResult<>(mapService.create(request), "Map created"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<MapResponse>> update(@PathVariable UUID id, @RequestBody @Valid UpdateMapRequest request) {
        return ResponseEntity.ok(new SuccessDataResult<>(mapService.update(id, request), "Map updated"));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable UUID id) {
        mapService.delete(id);

        return ResponseEntity.ok(new SuccessResult("Map deleted successfully"));
    }
}
