"use client";

import { useEffect, useState } from "react";
import { MapResponse } from "../../types/map";
import { getAllMaps } from "../../services/mapService";
import MapCard from "./MapCard";

export default function MapGrid() {
  const [maps, setMaps] = useState<MapResponse[]>([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    getAllMaps()
      .then(setMaps)
      .finally(() => setLoading(false));
  }, []);

  if (loading) {
    return (
      <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
        {[...Array(8)].map((_, i) => (
          <div
            key={i}
            className="rounded-xl animate-pulse"
            style={{
              backgroundColor: "var(--color-surface)",
              aspectRatio: "4/3",
            }}
          />
        ))}
      </div>
    );
  }

  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
      {loading
        ? [...Array(8)].map((_, i) => (
            <div
              key={i}
              className="rounded-xl animate-pulse"
              style={{
                backgroundColor: "var(--color-surface)",
                aspectRatio: "4/3",
              }}
            />
          ))
        : maps.map((map) => (
            <MapCard
              key={map.id}
              id={map.mapKey}
              name={map.name}
              status={map.status === "ACTIVE" ? "active" : "inactive"}
              nadeCount={map.nadeCount}
              icon={map.icon}
              poster={map.poster}
            />
          ))}
    </div>
  );
}
