package hasan.gurgur.makeupproductsapp.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import hasan.gurgur.makeupproductsapp.databinding.ItemProductListLayoutBinding
import hasan.gurgur.makeupproductsapp.model.ProductModelItem
import hasan.gurgur.makeupproductsapp.ui.BaseViewHolder

class ProductItemHolder (
    parent: ViewGroup,
    inflater: LayoutInflater
) : BaseViewHolder<ItemProductListLayoutBinding>(
    binding = ItemProductListLayoutBinding.inflate(inflater, parent, false)
) {

    fun bind(
        product : ProductModelItem,
        characterClickCallback : ((ProductModelItem) -> Unit)? = null,
        favClickCallback : ((ProductModelItem) -> Unit)? = null
    ) {
        with(binding) {
            binding.product = product
            binding.mainLayout.setOnClickListener{
                characterClickCallback?.invoke(product)
            }

            binding.itemFavIc.setOnClickListener{
                favClickCallback?.invoke(product)
            }
            executePendingBindings()
        }
    }


}
