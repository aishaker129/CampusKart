export default function FeaturedItem() {
    return (
        <div>
            <h2 className="text-[#0e141b] text-[22px] font-bold leading-tight tracking-[-0.015em] px-4 pb-3 pt-5">Featured Items</h2>
            <div className="flex overflow-y-auto [-ms-scrollbar-style:none] [scrollbar-width:none] [&amp;::-webkit-scrollbar]:hidden">
                <div className="flex items-stretch p-4 gap-3">
                    <div className="flex h-full flex-1 flex-col gap-4 rounded-lg min-w-60">
                        <div
                            className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg flex flex-col"
                            style={{
                                backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuCEOuDwJcOIBdc6XPtfYJIs0ploLmltMYQcve4Reg4e2pA7VHTLFeatMrAVjTEk1VetiRKE6QxVJjuFXvspgPyus-0Js_mkanNYKypyw_mKWxkRDbeT4k4H8-5zwctMl1V-oV4NBhWPXEm_Z0HJZ93vOMUygGVZL0Yvv9II2KpVINOzoO7j_C4uTj7xAnq5UOC0148CRjxUcBvk6OvOJKvknAkZ8d1uC2QvIYbV_6TgV9mM7CDMcmhzixxfSTzWA7T309nfv_zJS6I")`
                            }}
                        ></div>
                        <div>
                            <p className="text-[#0e141b] text-base font-medium leading-normal">Calculus Textbook</p>
                            <p className="text-[#4e7097] text-sm font-normal leading-normal">Math 101</p>
                        </div>
                    </div>
                    <div className="flex h-full flex-1 flex-col gap-4 rounded-lg min-w-60">
                        <div
                            className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg flex flex-col"
                            style={{
                                backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuAfA9pySBytRrs65UCb3dVI0tr4XfHKriuPV-uoPxvsQeFsrceiCSOu6R6Hfdi0MoUfdKe8UQmCQzILvexyldVrOmW8vPaKOMeEdMm12f9usWlR2xk6FlCeN_eB1gU5dDAS_HxhnrGKa9MUZw05U4Pn_epiOM1Qgpn97ktOW5DyXns20z7M1fEvYDUX_Jes-Tz3mLhw-lqC5xZNvYlAe6kMw_YMsZhvja1e-HfaGJm457Huf9IE9CFaf8_wXCrI0ONEoslZ7fE-YDM")`
                            }}
                        ></div>
                        <div>
                            <p className="text-[#0e141b] text-base font-medium leading-normal">Used Laptop</p>
                            <p className="text-[#4e7097] text-sm font-normal leading-normal">Slightly used, great condition</p>
                        </div>
                    </div>
                    <div className="flex h-full flex-1 flex-col gap-4 rounded-lg min-w-60">
                        <div
                            className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg flex flex-col"
                            style={{
                                backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuAv7IavVH74bGn9ojIak1hLqqz8c6v3fAiBCgrhiXR7uhu6DCcacjDG13y3copPTCaR9qwPxsY0xvRqbDvdyy9qWycpCbyQOMCSXbcTlFEPI49wII7w95xPAxFOXRUWai9HBYm90k6KLJnhe61fdkyMCJgx4XAHHG6tUJpFJueey6czhBO4kqnoUgXVeES0kRGQTMg8EJ1s_mnHLFKvkfrfrDl7XKFIqGYNhlaRX2JZOhNQ9UO8wW6iZq_kfZbtZAZe-PTX7I8NW_0")`
                            }}
                        ></div>
                        <div>
                            <p className="text-[#0e141b] text-base font-medium leading-normal">Campus Backpack</p>
                            <p className="text-[#4e7097] text-sm font-normal leading-normal">Spacious and durable</p>
                        </div>
                    </div>
                    <div className="flex h-full flex-1 flex-col gap-4 rounded-lg min-w-60">
                        <div
                            className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg flex flex-col"
                            style={{
                                backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuALnFnxXxoL_viHj4ll0ZKm27fJdirC2BkYBaXWGf_Db4rMICXHyqVODr0vJPNip24AXAUH0z7_c2sVysDRYgXHtDYA2wJ-ZMrWnr0_yUcvWnbfZcQZJBZvBQgRASabaT5EKvKwvJoJt-nBr1pkPm3mVZHnYAkwdw7xBqG0Z13YCxjPHpQqiDiCoQmoXIt6813L2R81NGTcwPQF9IV98eY44YGFC7PaJi0aSk9eR-9fRO-7qTevzowzbaCY3Jbzw8AcpXPqiG2dzHA")`
                            }}
                        ></div>
                        <div>
                            <p className="text-[#0e141b] text-base font-medium leading-normal">Scientific Calculator</p>
                            <p className="text-[#4e7097] text-sm font-normal leading-normal">For engineering students</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}
