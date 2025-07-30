import { Link } from "react-router-dom"

const UserSignup = () => {
    return (
        <div className="px-40 flex flex-1 justify-center py-5">
            <div className="layout-content-container flex flex-col w-[512px] max-w-[512px] py-5 flex-1">
                <h2 className="text-[#181110] tracking-light text-[28px] font-bold leading-tight px-4 text-center pb-3 pt-5">Create your account</h2>
                <div className="flex max-w-[480px] flex-wrap items-end gap-4 px-4 py-3">
                    <label className="flex flex-col min-w-40 flex-1">
                        <p className="text-[#181110] text-base font-medium leading-normal pb-2">Full Name</p>
                        <input
                            placeholder="Enter your full name"
                            className="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-[#181110] focus:outline-0 focus:ring-0 border-none bg-[#f1ebea] focus:border-none h-14 placeholder:text-[#8a625c] p-4 text-base font-normal leading-normal"
                            value=""
                        />
                    </label>
                </div>
                <div className="flex max-w-[480px] flex-wrap items-end gap-4 px-4 py-3">
                    <label className="flex flex-col min-w-40 flex-1">
                        <p className="text-[#181110] text-base font-medium leading-normal pb-2">Email</p>
                        <input
                            placeholder="Enter your email"
                            className="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-[#181110] focus:outline-0 focus:ring-0 border-none bg-[#f1ebea] focus:border-none h-14 placeholder:text-[#8a625c] p-4 text-base font-normal leading-normal"
                            value=""
                        />
                    </label>
                </div>
                <div className="flex max-w-[480px] flex-wrap items-end gap-4 px-4 py-3">
                    <label className="flex flex-col min-w-40 flex-1">
                        <p className="text-[#181110] text-base font-medium leading-normal pb-2">Username</p>
                        <input
                            placeholder="Choose a username"
                            className="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-[#181110] focus:outline-0 focus:ring-0 border-none bg-[#f1ebea] focus:border-none h-14 placeholder:text-[#8a625c] p-4 text-base font-normal leading-normal"
                            value=""
                        />
                    </label>
                </div>
                <div className="flex max-w-[480px] flex-wrap items-end gap-4 px-4 py-3">
                    <label className="flex flex-col min-w-40 flex-1">
                        <p className="text-[#181110] text-base font-medium leading-normal pb-2">Password</p>
                        <input
                            placeholder="Create a password"
                            className="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-[#181110] focus:outline-0 focus:ring-0 border-none bg-[#f1ebea] focus:border-none h-14 placeholder:text-[#8a625c] p-4 text-base font-normal leading-normal"
                            value=""
                        />
                    </label>
                </div>
                <div className="flex max-w-[480px] flex-wrap items-end gap-4 px-4 py-3">
                    <label className="flex flex-col min-w-40 flex-1">
                        <p className="text-[#181110] text-base font-medium leading-normal pb-2">Confirm Password</p>
                        <input
                            placeholder="Confirm your password"
                            className="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-[#181110] focus:outline-0 focus:ring-0 border-none bg-[#f1ebea] focus:border-none h-14 placeholder:text-[#8a625c] p-4 text-base font-normal leading-normal"
                            value=""
                        />
                    </label>
                </div>
                <div className="flex px-4 py-3">
                    <button
                        className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-full h-12 px-5 flex-1 bg-[#e5b9b2] text-[#181110] text-base font-bold leading-normal tracking-[0.015em]"
                    >
                        <span className="truncate">Sign Up</span>
                    </button>
                </div>
                <p className="text-[#8a625c] text-sm font-normal leading-normal pb-3 pt-1 px-4 text-center underline">Already have an account? 
                    <Link to="/signin" className="underline"> Login</Link>
                </p>
            </div>
        </div>
    )
}

export default UserSignup