package hasan.gurgur.makeupproductsapp.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import hasan.gurgur.makeupproductsapp.databinding.ProductBrandsItemLayoutBinding
import hasan.gurgur.makeupproductsapp.ui.BaseViewHolder

class ProductNameItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ProductBrandsItemLayoutBinding>(
    binding = ProductBrandsItemLayoutBinding.inflate(inflater, parent, false)
) {

    fun bind(
        brandName : String,
        characterClickCallback : ((String) -> Unit)? = null,

    ) {
        with(binding) {
            binding.brandName = brandName
            binding.brandNameBtn .setOnClickListener{
                characterClickCallback?.invoke(brandName)
            }
            executePendingBindings()
        }
    }


}
