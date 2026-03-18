package com.cs2tactic.api.map.dto;

import com.cs2tactic.api.map.entity.MapStatus;
import lombok.Getter;

@Getter
public class CreateMapRequest {
    private String mapKey;
    private String name;
    private MapStatus status;
    private int nadeCount;
    private String icon;
    private String poster;
}

