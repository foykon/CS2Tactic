export type MapStatus = "active" | "inactive";

export interface GameMap {
  id: string;
  name: string;
  status: MapStatus;
  nadeCount: number;
  icon: string;
  poster: string;
}

export const maps: GameMap[] = [
  {
    id: "mirage",
    name: "Mirage",
    status: "active",
    nadeCount: 0,
    icon: "/images/maps/mirage_icon.webp",
    poster: "/images/maps/mirage_poster.webp",
  },
  {
    id: "inferno",
    name: "Inferno",
    status: "active",
    nadeCount: 0,
    icon: "/images/maps/inferno_icon.webp",
    poster: "/images/maps/inferno_poster.webp",
  },
  {
    id: "dust2",
    name: "Dust 2",
    status: "active",
    nadeCount: 0,
    icon: "/images/maps/dust2_icon.webp",
    poster: "/images/maps/dust2_poster.webp",
  },
  {
    id: "nuke",
    name: "Nuke",
    status: "active",
    nadeCount: 0,
    icon: "/images/maps/nuke_icon.webp",
    poster: "/images/maps/nuke_poster.webp",
  },
  {
    id: "ancient",
    name: "Ancient",
    status: "active",
    nadeCount: 0,
    icon: "/images/maps/ancient_icon.webp",
    poster: "/images/maps/ancient_poster.webp",
  },
  {
    id: "anubis",
    name: "Anubis",
    status: "active",
    nadeCount: 0,
    icon: "/images/maps/anubis_icon.webp",
    poster: "/images/maps/anubis_poster.webp",
  },
  {
    id: "overpass",
    name: "Overpass",
    status: "active",
    nadeCount: 0,
    icon: "/images/maps/overpass_icon.webp",
    poster: "/images/maps/overpass_poster.webp",
  },
  {
    id: "train",
    name: "Train",
    status: "inactive",
    nadeCount: 0,
    icon: "/images/maps/train_icon.webp",
    poster: "/images/maps/train_poster.webp",
  },
];
