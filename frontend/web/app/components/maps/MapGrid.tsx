import { maps } from "../../config/maps";
import MapCard from "./MapCard";

export default function MapGrid() {
  return (
    <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-3 xl:grid-cols-4 gap-6">
      {maps.map((map) => (
        <MapCard key={map.id} {...map} />
      ))}
    </div>
  );
}
