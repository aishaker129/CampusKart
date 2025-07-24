import Hero from '../components/Home/Hero';
import FeaturedItem from '../components/Home/FeaturedItem';
import Categories from '../components/Home/Categories';
import Testimonial from '../components/Home/Testimonial';

export default function Home() {
  return (
    <div className='px-40 flex flex-1 justify-center py-5 layout-container  h-full grow flex-col'>
      <Hero />
      <FeaturedItem />
      <Categories />
      <Testimonial />
    </div>
  );
}
