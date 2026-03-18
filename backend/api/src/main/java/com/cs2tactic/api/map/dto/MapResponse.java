package com.cs2tactic.api.map.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.cs2tactic.api.map.entity.MapStatus;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
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

    @JsonCreator
    public MapResponse(
            @JsonProperty("id") UUID id,
            @JsonProperty("createdAt") LocalDateTime createdAt,
            @JsonProperty("updatedAt") LocalDateTime updatedAt,
            @JsonProperty("mapKey") String mapKey,
            @JsonProperty("name") String name,
            @JsonProperty("status") MapStatus status,
            @JsonProperty("nadeCount") int nadeCount,
            @JsonProperty("icon") String icon,
            @JsonProperty("poster") String poster
    ) {
        this.id = id;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.mapKey = mapKey;
        this.name = name;
        this.status = status;
        this.nadeCount = nadeCount;
        this.icon = icon;
        this.poster = poster;
    }
}