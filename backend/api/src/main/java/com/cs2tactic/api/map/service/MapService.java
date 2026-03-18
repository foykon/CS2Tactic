package com.cs2tactic.api.map.service;

import java.util.List;
import java.util.UUID;

import com.cs2tactic.api.common.dto.DataResult;
import com.cs2tactic.api.common.dto.Result;
import com.cs2tactic.api.map.dto.CreateMapRequest;
import com.cs2tactic.api.map.dto.MapResponse;
import com.cs2tactic.api.map.dto.UpdateMapRequest;

public interface MapService {
    DataResult<List<MapResponse>> getAll();
    DataResult<MapResponse> getById(UUID id);
    DataResult<MapResponse> getByMapKey(String mapKey);
    DataResult<MapResponse> create(CreateMapRequest request);
    DataResult<MapResponse> update(UUID id, UpdateMapRequest request);
    Result delete(UUID id);
}
