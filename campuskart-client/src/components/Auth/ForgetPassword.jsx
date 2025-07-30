import { Link } from "react-router-dom"

const ForgetPassword = () => {
    return (
        <div className="px-40 flex flex-1 justify-center py-5">
            <div className="layout-content-container flex flex-col w-[512px] max-w-[512px] py-5 flex-1">
                <h2 className="text-[#181110] tracking-light text-[28px] font-bold leading-tight px-4 text-center pb-3 pt-5">Forgot your password?</h2>
                <p className="text-[#181110] text-base font-normal leading-normal pb-3 pt-1 px-4 text-center">
                    Enter the email address associated with your account, and we'll send you a link to reset your password.
                </p>
                <div className="flex max-w-[480px] flex-wrap items-end gap-4 px-4 py-3">
                    <label className="flex flex-col min-w-40 flex-1">
                        <input
                            placeholder="Email"
                            className="form-input flex w-full min-w-0 flex-1 resize-none overflow-hidden rounded-xl text-[#181110] focus:outline-0 focus:ring-0 border-none bg-[#f1ebea] focus:border-none h-14 placeholder:text-[#8a625c] p-4 text-base font-normal leading-normal"
                            value=""
                        />
                    </label>
                </div>
                <div className="flex px-4 py-3">
                    <button
                        className="flex min-w-[84px] max-w-[480px] cursor-pointer items-center justify-center overflow-hidden rounded-full h-10 px-4 flex-1 bg-[#e5b9b2] text-[#181110] text-sm font-bold leading-normal tracking-[0.015em]"
                    >
                        <span className="truncate">Send Reset Link</span>
                    </button>
                </div>
                <p className="text-[#8a625c] text-sm font-normal leading-normal pb-3 pt-1 px-4 text-center underline">Remember your password? 
                    <Link to="/signin" className="underline"> Sign In</Link>
                </p>
            </div>
        </div>
    )
}

export default ForgetPassword