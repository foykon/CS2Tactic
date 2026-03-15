"use client";

import Link from "next/link";
import Image from "next/image";
import { useState } from "react";
import { GameMap } from "../../config/maps";

export default function MapCard({
  id,
  name,
  status,
  nadeCount,
  icon,
  poster,
}: GameMap) {
  const [hovered, setHovered] = useState(false);
  return (
    <div
      className="relative rounded-xl overflow-hidden"
      style={{
        backgroundColor: "var(--color-surface)",
        border: "1px solid var(--color-border)",
        aspectRatio: "4/3",
      }}
      onMouseEnter={() => setHovered(true)}
      onMouseLeave={() => setHovered(false)}
    >
      {/* Poster - arkaplan */}
      <div
        className="absolute inset-0 transition-opacity duration-300"
        style={{ opacity: hovered ? 0.25 : 1 }}
      >
        <Image src={poster} alt={name} fill className="object-cover" priority />
      </div>

      {/* Karartma overlay */}
      <div
        className="absolute inset-0"
        style={{
          background: hovered
            ? "transparent"
            : "linear-gradient(to top, rgba(0,0,0,0.85) 0%, rgba(0,0,0,0.2) 60%, transparent 100%)",
        }}
      />

      {/* Normal hal */}
      <div
        className="absolute inset-0 flex flex-col transition-opacity duration-300"
        style={{ opacity: hovered ? 0 : 1 }}
      >
        {/* Sağ üst - rozet */}
        <div className="flex p-3">
          <span
            className="text-xs px-2 py-0.5 rounded-full font-semibold"
            style={{
              backgroundColor:
                status === "active" ? "var(--color-primary)" : "#3a3a3a",
              color:
                status === "active"
                  ? "var(--color-accent)"
                  : "var(--color-text-muted)",
            }}
          >
            {status === "active" ? "active" : "inactive"}
          </span>
        </div>

        {/* Orta - icon + isim + nade */}
        <div className="flex-1 flex flex-col items-center justify-center gap-2">
          <Image
            src={icon}
            alt={`${name} icon`}
            width={72}
            height={72}
            className="rounded-lg"
          />
          <p
            className="font-bold text-lg text-center"
            style={{ color: "var(--color-text)" }}
          >
            {name}
          </p>
          <p
            className="text-xs text-center"
            style={{ color: "var(--color-text-muted)" }}
          >
            {nadeCount} nade
          </p>
        </div>
      </div>

      {/* Hover hal - CT / T */}
      <div
        className="absolute inset-0 flex transition-opacity duration-300"
        style={{
          opacity: hovered ? 1 : 0,
          pointerEvents: hovered ? "auto" : "none",
        }}
      >
        {/* Map ismi hover'da */}
        <div className="absolute bottom-4 left-4 right-4 text-center">
          <p
            className="font-bold text-lg"
            style={{ color: "var(--color-text)", opacity: 0.6 }}
          >
            {name}
          </p>
        </div>

        {/* Sol - CT */}
        <Link
          href={`/maps/${id}/ct`}
          className="flex-1 flex flex-col items-center justify-center gap-2 transition-all hover:brightness-125"
          style={{ borderRight: "1px solid var(--color-border)" }}
        >
          <Image src="/images/teams/ct.png" alt="CT" width={48} height={48} />
          <span className="text-sm font-bold" style={{ color: "#4A9EFF" }}>
            CT
          </span>
        </Link>

        {/* Sağ - T */}
        <Link
          href={`/maps/${id}/t`}
          className="flex-1 flex flex-col items-center justify-center gap-2 transition-all hover:brightness-125"
        >
          <Image src="/images/teams/t.png" alt="T" width={48} height={48} />
          <span className="text-sm font-bold" style={{ color: "#FF8C42" }}>
            T
          </span>
        </Link>
      </div>
    </div>
  );
}
