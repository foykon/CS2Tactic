package com.cs2tactic.api.map.service;

import java.util.List;
import java.util.UUID;

import com.cs2tactic.api.map.dto.CreateMapRequest;
import com.cs2tactic.api.map.dto.MapResponse;
import com.cs2tactic.api.map.dto.UpdateMapRequest;

public interface MapService {
    List<MapResponse> getAll();
    MapResponse getById(UUID id);
    MapResponse getByMapKey(String mapKey);
    MapResponse create(CreateMapRequest request);
    MapResponse update(UUID id, UpdateMapRequest request);
    void delete(UUID id);
}
