package com.cs2tactic.api.map.entity;

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
    @Column(name = "id", nullable = false, unique = true)
    private String id;

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