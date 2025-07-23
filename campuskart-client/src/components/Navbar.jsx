import React from 'react';
import { Link } from 'react-router-dom';

export default function Navbar() {
  return (
    <nav className="bg-blue-600 text-white p-4 flex justify-between items-center">
      <Link to="/" className="text-lg font-bold">CampusKart</Link>
      <div className="space-x-4">
        <Link to="/">Home</Link>
        <Link to="/browse">Browse</Link>
      </div>
    </nav>
  );
}
