import { MapResponse } from "../types/map";

const API_URL = process.env.NEXT_PUBLIC_API_URL ?? "http://localhost:8080";

export async function getAllMaps(): Promise<MapResponse[]> {
  const res = await fetch(`${API_URL}/api/maps`);
  const result = await res.json();
  return result.data;
}
