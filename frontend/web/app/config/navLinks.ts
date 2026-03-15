export type NavLinkStatus = "active" | "soon" | "beta";

export interface NavLink {
  label: string;
  href: string;
  status: NavLinkStatus;
}

export const navLinks: NavLink[] = [
  { label: "Maps", href: "/", status: "active" },
  { label: "Crosshair", href: "/crosshair", status: "soon" },
  { label: "Servers", href: "/servers", status: "soon" },
  { label: "Community", href: "/community", status: "beta" },
];
