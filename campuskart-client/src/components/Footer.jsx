export default function Footer() {
  return (
    <footer className="flex justify-center">
      <div className="flex max-w-[960px] flex-1 flex-col">
        <footer className="flex flex-col gap-6 px-5 py-10 text-center @container">
          <div className="flex flex-wrap items-center justify-center gap-6 @[480px]:flex-row @[480px]:justify-around">
            <a className="text-[#4e7097] text-base font-normal leading-normal min-w-40" href="#">About Us</a>
            <a className="text-[#4e7097] text-base font-normal leading-normal min-w-40" href="#">Contact</a>
            <a className="text-[#4e7097] text-base font-normal leading-normal min-w-40" href="#">Terms of Service</a>
            <a className="text-[#4e7097] text-base font-normal leading-normal min-w-40" href="#">Privacy Policy</a>
          </div>
          <p className="text-[#4e7097] text-base font-normal leading-normal">© 2025 CampusKart. All rights reserved.</p>
        </footer>
      </div>
    </footer>
  );
}
