const Categories = () => {
    return (
        <div>
            <h2 className="text-[#0e141b] text-[22px] font-bold leading-tight tracking-[-0.015em] px-4 pb-3 pt-5">Categories</h2>
            <div className="grid grid-cols-[repeat(auto-fit,minmax(158px,1fr))] gap-3 p-4">
                <div className="flex flex-col gap-3 pb-3">
                    <div
                        className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg"
                        style={{
                            backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuD8NvSOS2flSABRGSBvPB160g90C5fnrf0WnAivz3GdBhVvYlBjIj5FHSMJ2On_GBmkLFwClUi8lUWLrfDSGNHgGb3NLrwYPeyHSjkByJdbPsq2ZGZyxwATBbF1Eb00iKEGlgZpEc1BIJpmoQjt86M3jXTW8ABxTEK_t2rB9dp90EoohYOpIPA2OEZq9LvnlzyLC1WlqjwbuuUCPZzl6y2_CG_glyNAzHXa5yDpQfC28dYXLXUqrgAHA11F2KoJl603G45VRCWvuUI")`
                        }}
                    ></div>
                    <p className="text-[#0e141b] text-base font-medium leading-normal">Textbooks</p>
                </div>
                <div className="flex flex-col gap-3 pb-3">
                    <div
                        className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg"
                        style={{
                            backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuA64Sh9LJp6pNrgTYnAjXwQbkJrguXPtcF0cX1PF9LPqzSNYfWaPiVEc2JAEDU486FRIFTHHewWk8L7jSTsSzAuBQfh4ccgKMCrdSNZhoomcsbBZJIaGR8aMt8DCv81YzLFJpbdIxQGc3Zvsl7ztfMhKDUASwCQWjYYCSGnMgoaA9gLR57eB7SoMQLRPIpkht0kWGDCFu7vn58m212QXMMcU0Va_qEUw-pOJtKIU61tfQYZKG7lgL_6Su2HCnNpewcB3h3rUaWgdiw")`
                        }}
                    ></div>
                    <p className="text-[#0e141b] text-base font-medium leading-normal">Project Materials</p>
                </div>
                <div className="flex flex-col gap-3 pb-3">
                    <div
                        className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg"
                        style={{
                            backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuC5lg7qolMXIqRVv8oD2jP1-V9VTldEFxXq0MR9CXqR_jI3ZBwlNp4aQ2lQfVGURnnJQDCtHh89F5ws6DqyHHsPzhm9njvjhGEMpshQKA0hBTmPesxw4r7gBahFw_wd1JvG1eht6KG7iGaMXM6MIQ43mfz3kmUfDOtmAsmwtVUNA2TttJ7_L9Snxw5vOJlHnL-pyFe8gqPiPpkD5w7wrkHa7-Um1Q8rIgmqscelRB6Uk3XwVzi5xfwjMW3OHPKooiFoqurEQ9sQbNM")`
                        }}
                    ></div>
                    <p className="text-[#0e141b] text-base font-medium leading-normal">Electronics</p>
                </div>
                <div className="flex flex-col gap-3 pb-3">
                    <div
                        className="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg"
                        style={{
                            backgroundImage: `url("https://lh3.googleusercontent.com/aida-public/AB6AXuCe3Qfd3FgdJIk2XK3NlfnNhC3TTZIGzfNn9jXod8zfKmAV6YIf2zeCG94NC9YuOj_1FmlTG93AjV-6yBeVN5m23OHYq7Nb-vOROlOLfuzkgJHMWgHIlRu40SceAG05g_vYVlYSmEZ-Sp1oxikf4HaQ0zxkD-Lbam59cIwdFzJQQGQdBTZgrXkYNXYfNRHs1iXBvkslrweUQwKGEh8wCBrTrhyfIlfYRYtDfBVHBBaIxSlQdTi2d0ucwcU0cD8tQAUONO0If2lPDdE")`
                        }}
                    ></div>
                    <p className="text-[#0e141b] text-base font-medium leading-normal">Dorm Supplies</p>
                </div>
            </div>
        </div>
    )
}

export default Categories