const AboutProduct = (props) => {
    return (
        <div className="layout-content-container flex flex-col max-w-[960px] flex-1">
            <div className="flex w-full grow bg-slate-50 @container p-4">
                <div className="w-full gap-1 overflow-hidden bg-slate-50 @[480px]:gap-2 aspect-[3/2] rounded-lg grid grid-cols-[2fr_1fr_1fr]">
                    <div
                        className="w-full bg-center bg-no-repeat bg-cover aspect-auto rounded-none row-span-2"
                        style={{ backgroundImage: `url('${props.imageUrl}')` }}
                    ></div>
                </div>
            </div>
            <h1 className="text-[#0e141b] text-[22px] font-bold leading-tight tracking-[-0.015em] px-4 text-left pb-3 pt-5"> {props.title} </h1>
            <p className="text-[#0e141b] text-base font-normal leading-normal pb-3 pt-1 px-4">
                {props.description}
            </p>
            <h3 className="text-[#0e141b] text-lg font-bold leading-tight tracking-[-0.015em] px-4 pb-2 pt-4">Seller Information</h3>
            <div className="flex items-center gap-4 bg-slate-50 px-4 min-h-[72px] py-2">
                <div
                    className="bg-center bg-no-repeat aspect-square bg-cover rounded-full h-14 w-fit"
                    style={{ backgroundImage: `url('${props.sellerImageUrl}')` }}
                ></div>
                <div className="flex flex-col justify-center">
                    <p className="text-[#0e141b] text-base font-medium leading-normal line-clamp-1">{props.sellerName}</p>
                    <p className="text-[#4e7097] text-sm font-normal leading-normal line-clamp-2"> {props.sellerRating} </p>
                </div>
            </div>
            <h3 className="text-[#0e141b] text-lg font-bold leading-tight tracking-[-0.015em] px-4 pb-2 pt-4">Price</h3>
            <h1 className="text-[#0e141b] text-[22px] font-bold leading-tight tracking-[-0.015em] px-4 text-left pb-3 pt-5">${props.price}</h1>
            <div className="flex justify-stretch">
                <div className="flex flex-1 gap-3 flex-wrap px-4 py-3 justify-start">
                    <button
                        className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-lg h-10 px-4 bg-[#1873dc] text-slate-50 text-sm font-bold leading-normal tracking-[0.015em]"
                    >
                        <span className="truncate">Buy</span>
                    </button>
                    <button
                        className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-lg h-10 px-4 bg-[#e7edf3] text-[#0e141b] text-sm font-bold leading-normal tracking-[0.015em]"
                    >
                        <span className="truncate">Swap</span>
                    </button>
                </div>
            </div>
            <h3 className="text-[#0e141b] text-lg font-bold leading-tight tracking-[-0.015em] px-4 pb-2 pt-4">Related Products</h3>
            <div className="flex overflow-y-auto [-ms-scrollbar-style:none] [scrollbar-width:none] [&amp;::-webkit-scrollbar]:hidden">
                <div className="flex items-stretch p-4 gap-3">
                    <div className="flex h-full flex-1 flex-col gap-4 rounded-lg min-w-40">
                        <div
                            className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg flex flex-col"
                            style={{ backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuAfXVMK2Qr3ffpbTgyHlCeBwbeyABEoQdeOiBJ9Zumj6SuVXy_FTdUY1re7D-cwlDLuedBoLYHtki7O36uhVqea6FXiid_RY1pyfRGu8OKkj1OyZEfpqA5UDvtuuAY2k2aHYQlgNOwXedJWNUSPatMCgOKpY1HIdt4qXU1cqLnNc6oIIsXaqh_Op21sWFjmNm7fGbjnIdzBfV4ecHHlDTHACdzfEhQY-aYG6pmf_avdFmL2TfdAx-Wff5FJubcjKA1LyfDaXA22t04")` }}
                        ></div>
                        <div>
                            <p className="text-[#0e141b] text-base font-medium leading-normal">Calculus Textbook</p>
                            <p className="text-[#4e7097] text-sm font-normal leading-normal">$40</p>
                        </div>
                    </div>
                    <div className="flex h-full flex-1 flex-col gap-4 rounded-lg min-w-40">
                        <div
                            className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg flex flex-col"
                            style={{ backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuB2O6W8oshDyUD9B-5zeY4GXvKgRp3TfPwMso6IQGQy8t1e22CJS3RwyDclYyYhvjnU9Kw_N6YZZpF4VQqjWqSVvevrZjtI9CDTxAm23ot3ill7IEAL5KRTJipPFGukxoSQ707hD9hcbPhjMt8AwKaklsCoLSu2HvICCZkRFU-80AqNaY6NxkSfG6RWpDEX_CdYb6V6A3J1EWBXqpriFAkRDXyW5FBG-jk_D5kMdnRHH4Qwk2WlbVQXyw4ySsthl_PSN1Vm5KHwDAc")` }}
                        ></div>
                        <div>
                            <p className="text-[#0e141b] text-base font-medium leading-normal">Scientific Calculator</p>
                            <p className="text-[#4e7097] text-sm font-normal leading-normal">$20</p>
                        </div>
                    </div>
                    <div className="flex h-full flex-1 flex-col gap-4 rounded-lg min-w-40">
                        <div
                            className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg flex flex-col"
                            style={{ backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuBIazixaxSzmroU_iAegZdAsFilZyB9VabFwnPs_N4WFSVlC6tXsRegoOOANHOf83gZiwOTcurqI9usaE565qlPZXZFjE7h_EiPYacRzg14DywaeeYZfUZl0yFNVnUlUzQedl9vhdZpGO3c2ocJIGWP4gPJvIGoaHxdfo9a-sWqDjNSKBFsfK-9MFi5fi-ToXbCwvn9ywlOmwiBrQkSWPThAk1wrX-PbqBqWqsNe9a72NpLQpMYOzEc0QJ1y28r4hpPPCRNWYCPoIk")` }}
                        ></div>
                        <div>
                            <p className="text-[#0e141b] text-base font-medium leading-normal">College Ruled Notebook</p>
                            <p className="text-[#4e7097] text-sm font-normal leading-normal">$5</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}

export default AboutProduct