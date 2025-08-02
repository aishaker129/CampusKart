import React from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './pages/Home';
import ProductListings from './pages/ProductListings';
import NotFound from './pages/NotFound';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import UserSignin from './components/Auth/UserSignin';
import UserSignup from './components/Auth/UserSignup';
import ForgetPassword from './components/Auth/ForgetPassword';
import ProductDetails from './pages/ProductDetails';

export default function App() {
  return (
    <div className="relative flex size-full min-h-screen flex-col bg-slate-50 group/design-root overflow-x-hidden" style={{ fontFamily: "Public Sans, Noto Sans, sans-serif" }}>

      <Navbar />
      <main className="flex-1 p-4">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/products" element={<ProductListings />} />
          <Route path="*" element={<NotFound />} />
          <Route path="/signin" element={<UserSignin />} />
          <Route path="/signup" element={<UserSignup />} />
          <Route path="/forget-password" element={<ForgetPassword />} />
          <Route path="/product-details/:id" element={<ProductDetails />} />
        </Routes>
      </main>
      <Footer />
    </div>
  );
}
