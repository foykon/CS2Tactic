export type MapStatus = "ACTIVE" | "INACTIVE";

export interface MapResponse {
  id: string;
  mapKey: string;
  name: string;
  status: MapStatus;
  nadeCount: number;
  icon: string;
  poster: string;
}
