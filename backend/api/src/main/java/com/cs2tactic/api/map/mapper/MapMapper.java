package com.cs2tactic.api.map.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.cs2tactic.api.map.dto.CreateMapRequest;
import com.cs2tactic.api.map.dto.MapResponse;
import com.cs2tactic.api.map.dto.UpdateMapRequest;
import com.cs2tactic.api.map.entity.Map;

@Mapper(componentModel = "spring")
public interface MapMapper {

    MapResponse toResponse(Map map);

    Map toEntity(CreateMapRequest request);

    void updateEntity(UpdateMapRequest request, @MappingTarget Map map);
}
