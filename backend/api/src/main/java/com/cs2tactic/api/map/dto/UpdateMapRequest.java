package com.cs2tactic.api.map.dto;

import com.cs2tactic.api.map.entity.MapStatus;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class UpdateMapRequest {

    @NotBlank(message = "{map.validation.name.required}")
    private String name;

    @NotNull(message = "{map.validation.status.required}")
    private MapStatus status;

    @Min(value = 0, message = "{map.validation.nade-count.min}")
    private int nadeCount;

    @NotBlank(message = "{map.validation.icon.required}")
    private String icon;

    @NotBlank(message = "{map.validation.poster.required}")
    private String poster;
}