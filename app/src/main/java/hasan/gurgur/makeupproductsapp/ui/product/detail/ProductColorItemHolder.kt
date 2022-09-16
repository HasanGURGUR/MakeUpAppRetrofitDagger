package hasan.gurgur.makeupproductsapp.ui.product.detail

import android.view.LayoutInflater
import android.view.ViewGroup

import hasan.gurgur.makeupproductsapp.databinding.ProductColorsItemLayoutBinding
import hasan.gurgur.makeupproductsapp.model.ProductColor
import hasan.gurgur.makeupproductsapp.ui.BaseViewHolder

class ProductColorItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ProductColorsItemLayoutBinding>(
    binding = ProductColorsItemLayoutBinding.inflate(inflater, parent, false)
) {

    fun bind(
        product_color : ProductColor,
        characterClickCallback : ((ProductColor) -> Unit)? = null,

    ) {
        with(binding) {
            binding.productColor = product_color
            binding.productColorIv1 .setOnClickListener{
                characterClickCallback?.invoke(product_color)
            }

            executePendingBindings()
        }
    }


}
