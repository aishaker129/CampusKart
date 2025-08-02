import ProductCart from "./ProductCart"

const Products = () => {
    return (
        <div className="grid grid-cols-[repeat(auto-fit,minmax(158px,1fr))] gap-3 p-4">
            <ProductCart imageUrl="https://lh3.googleusercontent.com/aida-public/AB6AXuCUb_WsnB08QFCh0UsAMh9AD1AV5gCTwy_S2rmBTATN26dRmH0DaR5VOS2ELf6J_YL5whC8t20_ruuGdbTBJXbtvWwZ4y7_n-2si7Wh7OGGkIhYryI6Rfb1Rjw1azG79qtN9ur95xFI9MSfLXW83GSCHGtGYIi9dmdy3Dcxj753hf-tSlat-CgIRdEmdjOVDDnv81rm8hM7PT5vLFg1qSad1BslINAHFQW5NOUC4FiPU33EQPtqC67AMV7ORYkePLGIwTAJtnYgGwg" id="1" title="Textbook: Calculus 101" condition="Used" type="Donate" />

            <ProductCart imageUrl="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTe8WUsYPhlM1Dg8l9fAEwYbV9oJtXHGWAhyA&s" id="2" title="Laptop: Dell XPS 13" condition="Used - Fresh" type="Sell" />

            <ProductCart imageUrl="https://lh3.googleusercontent.com/aida-public/AB6AXuDg2IfhU1mzH72BqIpDbv45NB1HS1rLzJ6O4RWVNjOxoljPyPdH2VUmkDj_j5-tLddl7knKSLQG82wsjKpFnS8Wj6UBfmoMVDPTv1dQwMzcrECVr5xQzb4comqIKNcD7GhDz0uxjtcnA5L8aURW0aAa9gd_3LYGHAJpQ6rMM8FeNoTn039-clRXBT2f0m_tP4zAlsH7eu9chRsJzvISf52iodSxsbFXnMY9lrkw7g_3AzCaoY7xVVPSe8GeL1AYlHsyX90INVhOhAY" id="3" title="Bike: Mountain Bike" condition="Used" type="Sell" />

            <ProductCart imageUrl="https://lh3.googleusercontent.com/aida-public/AB6AXuBQGukXCCTU9TRm64C6nqof5r8ribu2W9pa7lGBuJrhfermblmyHbVR3dhF-r2oQM7PrVIWIcJt_8rXVUqpKcZxjeiK6NCYopjR4zXj2i5ZmKf_3wrS4QaDNfRlZoSGGqItFDpcRfRq0fYGcYVjoHMVr8FXtSUTJ9ths-V50qpGy8vIcvt2mLMywow-6bUa4CJu-utVPCu22gVavW7b8RxxRKKhK_A2uWZrEumJLF6k6OcWk90OITMDYjCf6NvMxhZbAZ9f80va2L0" id="4" title="Desk Lamp: Adjustable LED" condition="New" type="Sell" />

            <ProductCart imageUrl="https://lh3.googleusercontent.com/aida-public/AB6AXuCqFOIMfhnGFWvj4R2OfV1vHJxPk0kBx5tD1A_OuGrxB2F2DnBdgRS3YV__aSZL01-js_crjtSXuzR2NWAoKiUzK9yhtUk-7E72gR4UDLidknQGhA8Pj4UuflUJH3vC4B1S11cUKT7HQMsnO-ZX212BcJn0357BuSXpjagYPZ4CQYGgiPshTV61hGUTrWL_IJejdeT7z479Xtwl9RH4rQXsPYbrn3gPe4n9hycPkWeO5RhReQi5sBK79VVGgLAverKEAZT1FG2bQ3s" id="5" title="Scintific Calculator" condition="Used" type="Sell" />

            <ProductCart imageUrl="https://lh3.googleusercontent.com/aida-public/AB6AXuCEFXjHwZeBQeSoYtO_XQkhqDcjj0UtbteEC5qG8n89CS9EW89e1u-Ko4daeEEUDTTCaIcULEnOq4tma9Mz0As78ttTI4R8PWnD7BfJrIkZPuNVoSYpRqp8ziSBDEsErMytg0NWEojN763aSKNVVKbQ0jxBxWnmyMLo1koMOdXT9oiKJZWD4lxg-B1R_G5-LBcqZiE4HO6zwOCK9gAvHX9y1_HH0Srq_JVSO7a2VNEdjJrtqi9nuukFvuwFhvk8B2hE8gXf6r2-eUA" id="6" title="Headphones: Noise Cancelling" condition="Used - Good" type="Sell" />
        </div>
    )
}

export default Products