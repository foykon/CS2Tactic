"use client";

import Link from "next/link";
import { useState } from "react";
import NavLink from "./NavLink";
import { navLinks } from "../../config/navLinks";



export default function Navbar() {
  const [dark, setDark] = useState(true);
  const [search, setSearch] = useState("");
  
return (
    <nav
      className="w-full px-6 py-3 flex items-center justify-between gap-6"
      style={{
        backgroundColor: "var(--color-bg)",
        borderBottom: "1px solid var(--color-border)",
      }}
    >
      {/* Sol - Logo + Linkler */}
      <div className="flex items-center gap-8">
        <Link
          href="/"
          className="text-xl font-bold tracking-wider shrink-0"
          style={{ color: "var(--color-accent)" }}
        >
          CS2TACTIC
        </Link>

        <div className="flex items-center gap-6">
          {navLinks.map((link) => (
            <NavLink key={link.label} {...link} />
          ))}
        </div>
      </div>

      {/* Orta - Search */}
      <div className="flex-1 max-w-sm">
        <input
          type="text"
          placeholder="Map, nade, pozisyon ara..."
          value={search}
          onChange={(e) => setSearch(e.target.value)}
          className="w-full px-4 py-1.5 text-sm rounded-full outline-none transition-all"
          style={{
            backgroundColor: "var(--color-surface)",
            color: "var(--color-text)",
            border: "1px solid var(--color-border)",
          }}
          onFocus={(e) => (e.target.style.borderColor = "var(--color-accent)")}
          onBlur={(e) => (e.target.style.borderColor = "var(--color-border)")}
        />
      </div>

      {/* Sağ - Dil, Dark mode, Login */}
      <div className="flex items-center gap-4 shrink-0">
        <button
          className="text-sm transition-colors hover:text-[var(--color-accent)]"
          style={{ color: "var(--color-text-muted)" }}
        >
          🌐 EN
        </button>

        <button
          onClick={() => setDark(!dark)}
          className="text-sm transition-colors hover:text-[var(--color-accent)]"
          style={{ color: "var(--color-text-muted)" }}
        >
          {dark ? "🌙" : "☀️"}
        </button>

        <button
          className="text-sm font-medium px-4 py-1.5 rounded-full transition-all hover:brightness-110"
          style={{
            backgroundColor: "var(--color-primary)",
            color: "var(--color-accent)",
            border: "1px solid var(--color-accent)22",
          }}
        >
          Login
        </button>
      </div>
    </nav>
  );
}