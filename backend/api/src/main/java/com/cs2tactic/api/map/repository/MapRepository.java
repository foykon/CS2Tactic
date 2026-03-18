package com.cs2tactic.api.map.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cs2tactic.api.map.entity.Map;
import com.cs2tactic.api.map.entity.MapStatus;

public interface MapRepository extends JpaRepository<Map, UUID> {

    List<Map> findAllByIsDeletedFalse();

    List<Map> findAllByStatusAndIsDeletedFalse(MapStatus status);

    Optional<Map> findByMapKeyAndIsDeletedFalse(String mapKey);
}
