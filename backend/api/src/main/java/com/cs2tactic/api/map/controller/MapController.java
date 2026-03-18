package com.cs2tactic.api.map.controller;

import com.cs2tactic.api.common.dto.DataResult;
import com.cs2tactic.api.common.dto.Result;
import com.cs2tactic.api.map.dto.CreateMapRequest;
import com.cs2tactic.api.map.dto.MapResponse;
import com.cs2tactic.api.map.dto.UpdateMapRequest;
import com.cs2tactic.api.map.service.MapService;

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
        return ResponseEntity.ok(mapService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResult<MapResponse>> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(mapService.getById(id));
    }

    @GetMapping("/key/{mapKey}")
    public ResponseEntity<DataResult<MapResponse>> getByMapKey(@PathVariable String mapKey) {
        return ResponseEntity.ok(mapService.getByMapKey(mapKey));
    }

    @PostMapping
    public ResponseEntity<DataResult<MapResponse>> create(@RequestBody CreateMapRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(mapService.create(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DataResult<MapResponse>> update(@PathVariable UUID id, @RequestBody UpdateMapRequest request) {
        return ResponseEntity.ok(mapService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Result> delete(@PathVariable UUID id) {
        return ResponseEntity.ok(mapService.delete(id));
    }
}
