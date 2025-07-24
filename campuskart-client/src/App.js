import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import BrowseListings from './pages/BrowseListings';
import NotFound from './pages/NotFound';
import Navbar from './components/Navbar';
import Footer from './components/Footer';

export default function App() {
  return (
    <div className="relative flex size-full min-h-screen flex-col bg-slate-50 group/design-root overflow-x-hidden" style={{ fontFamily: "Public Sans, Noto Sans, sans-serif" }}>
      <div>
        <Navbar />
        <main className="flex-1 p-4">
          <Routes>
            <Route path="/" element={<Home />} />
            <Route path="/browse" element={<BrowseListings />} />
            <Route path="*" element={<NotFound />} />
          </Routes>
        </main>
        <Footer />
      </div>
    </div>
  );
}
