import Link from "next/link";
import { NavLink as NavLinkType } from "../../config/navLinks";

const statusBadge: Record<string, { label: string }> = {
  soon: { label: "soon" },
  beta: { label: "beta" },
};

export default function NavLink({ label, href, status }: NavLinkType) {
  if (status === "soon") {
    return (
      <span
        className="flex items-center gap-1 text-sm font-medium cursor-not-allowed select-none"
        style={{ color: "var(--color-text-muted)" }}
      >
        {label}
        <span
          className="text-xs px-1.5 py-0.5 rounded font-semibold"
          style={{
            backgroundColor: "var(--color-primary)",
            color: "var(--color-accent)",
          }}
        >
          soon
        </span>
      </span>
    );
  }

  return (
    <Link
      href={href}
      className="flex items-center gap-1 text-sm font-medium transition-colors hover:text-[var(--color-accent)]"
      style={{ color: "var(--color-text)" }}
    >
      {label}
      {status === "beta" && (
        <span
          className="text-xs px-1.5 py-0.5 rounded font-semibold"
          style={{
            backgroundColor: "#7C3AED",
            color: "#E9D5FF",
          }}
        >
          beta
        </span>
      )}
    </Link>
  );
}