import React from 'react';

export default function Footer() {
  return (
    <footer className="bg-gray-200 text-center p-4 mt-4">
      <p>&copy; {new Date().getFullYear()} CampusKart. All rights reserved.</p>
    </footer>
  );
}
