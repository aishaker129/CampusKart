import React from 'react';
import { Link } from 'react-router-dom';

export default function NotFound() {
  return (
    <div className="text-center">
      <h1 className="text-3xl font-bold">404 - Page Not Found</h1>
      <p>The page you are looking for does not exist.</p>
      <Link to="/" className="text-blue-500 underline">Go to Home</Link>
    </div>
  );
}
