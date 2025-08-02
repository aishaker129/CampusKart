import { Link } from "react-router-dom"

const ProductCart = (props) => {
    return (
        <div class="flex flex-col gap-3 pb-3">
            <div
                class="w-full bg-center bg-no-repeat aspect-square bg-cover rounded-lg"
                style={{ backgroundImage: `url(${props.imageUrl})` }}
            ></div>
            <div>
                <p class="text-[#0e141b] text-base font-medium leading-normal">
                    <Link to={`/product-details/${props.id}`}>
                        {props.title}
                    </Link>
                </p>
                <p class="text-[#4e7097] text-sm font-normal leading-normal">Condition - {props.condition}</p>
                <p class="text-[#4e7097] text-sm font-normal leading-normal">Type - {props.type}</p>
            </div>
        </div>
    )
}

export default ProductCart