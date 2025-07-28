import Header from '../components/ProductsListing/Header';
import Products from '../components/ProductsListing/Products';
import SearchBar from '../components/ProductsListing/SearchBar';

export default function ProductListings() {
  return (
    <div className='px-40 flex flex-1 justify-center py-5'>
      <div className='layout-content-container flex flex-col max-w-[960px] flex-1'>
        <Header />
        <SearchBar />
        <Products />
      </div>
    </div>
  );
}
