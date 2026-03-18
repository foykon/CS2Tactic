package com.cs2tactic.api.map.entity;

import java.util.UUID;

import com.cs2tactic.api.common.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "maps")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Map extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false, updatable = false)
    private UUID id;

    @Column(name = "map_key", nullable = false, unique = true)
    private String mapKey;

    @Column(name = "name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private MapStatus status;

    @Column(name = "nade_count", nullable = false)
    private int nadeCount;

    @Column(name = "icon", nullable = false)
    private String icon;

    @Column(name = "poster", nullable = false)
    private String poster;
}