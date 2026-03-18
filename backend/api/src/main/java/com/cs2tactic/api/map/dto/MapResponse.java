package com.cs2tactic.api.map.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.cs2tactic.api.map.entity.MapStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MapResponse {
    private UUID id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String mapKey;
    private String name;
    private MapStatus status;
    private int nadeCount;
    private String icon;
    private String poster;
}