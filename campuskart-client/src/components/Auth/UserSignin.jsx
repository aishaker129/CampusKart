import { Link } from "react-router-dom"

const UserSignin = () => {
    return (
        <div className="px-40 flex flex-1 justify-center py-5">
            <div className="layout-content-container flex flex-col w-[512px] max-w-[960px] py-5 flex-1">
                <h2 className="text-[#181110] tracking-light text-[28px] font-bold leading-tight px-4 text-center pb-3 pt-5">Sign in to CampusKart</h2>
                <div className="flex max-w-[480px] flex-wrap items-end gap-4 px-4 py-3">
                    <label className="flex flex-col min-w-40 flex-1">
                        <p className="text-[#181110] text-base font-medium leading-normal pb-2">Username or email</p>
                        <input
                            placeholder="Enter your username or email"
                            className="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-[#181110] focus:outline-0 focus:ring-0 border border-[#e2d6d4] bg-[#fbf9f9] focus:border-[#e2d6d4] h-14 placeholder:text-[#8a625c] p-[15px] text-base font-normal leading-normal"
                            value=""
                        />
                    </label>
                </div>
                <div className="flex max-w-[480px] flex-wrap items-end gap-4 px-4 py-3">
                    <label className="flex flex-col min-w-40 flex-1">
                        <p className="text-[#181110] text-base font-medium leading-normal pb-2">Password</p>
                        <input
                            placeholder="Enter your password"
                            className="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-[#181110] focus:outline-0 focus:ring-0 border border-[#e2d6d4] bg-[#fbf9f9] focus:border-[#e2d6d4] h-14 placeholder:text-[#8a625c] p-[15px] text-base font-normal leading-normal"
                            value=""
                        />
                    </label>
                </div>
                <div className="px-4">
                    <label className="flex gap-x-3 py-3 flex-row">
                        <input
                            type="checkbox"
                            className="h-5 w-5 rounded border-[#e2d6d4] border-2 bg-transparent text-[#e5b9b2] checked:bg-[#e5b9b2] checked:border-[#e5b9b2] checked:bg-[image:--checkbox-tick-svg] focus:ring-0 focus:ring-offset-0 focus:border-[#e2d6d4] focus:outline-none"
                        />
                        <p className="text-[#181110] text-base font-normal leading-normal">Remember me</p>
                    </label>
                </div>
                <div className="flex px-4 py-3">
                    <button
                        className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-full h-10 px-4 flex-1 bg-[#e5b9b2] text-[#181110] text-sm font-bold leading-normal tracking-[0.015em]"
                    >
                        <span className="truncate">Sign in</span>
                    </button>
                </div>
                <div className="flex flex-col items-center gap-3 px-4 py-3">
                    <p className="text-[#8a625c] text-sm font-normal leading-normal pb-3 pt-1 px-4 text-center">Don't have an account? <a href="/signup" className="underline">Sign up</a></p>
                    <p className="text-[#8a625c] text-sm font-normal leading-normal pb-3 pt-1 px-4 text-center underline">
                        <Link to="/forget-password">Forgot your password?</Link>
                    </p>
                </div>
            </div>
        </div>
    )
}

export default UserSignin