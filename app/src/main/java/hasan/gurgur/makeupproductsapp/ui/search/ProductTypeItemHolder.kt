package hasan.gurgur.makeupproductsapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import hasan.gurgur.makeupproductsapp.databinding.ItemProdutTypeLayoutBinding
import hasan.gurgur.makeupproductsapp.model.CircleModel

import hasan.gurgur.makeupproductsapp.ui.BaseViewHolder

class ProductTypeItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ItemProdutTypeLayoutBinding>(
    binding = ItemProdutTypeLayoutBinding.inflate(inflater, parent, false)
) {

    fun bind(
        productType : CircleModel,
        characterClickCallback : ((CircleModel) -> Unit)? = null,

        ) {
        with(binding) {
            binding.productType = productType
            binding.cardView .setOnClickListener{
                characterClickCallback?.invoke(productType)
            }
            executePendingBindings()
        }
    }


}
