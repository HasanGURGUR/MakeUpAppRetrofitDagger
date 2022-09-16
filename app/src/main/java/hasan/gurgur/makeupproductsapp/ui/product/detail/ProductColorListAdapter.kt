package hasan.gurgur.makeupproductsapp.ui.product.detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.makeupproductsapp.model.ProductColor
import hasan.gurgur.makeupproductsapp.ui.BaseListAdapter

class ProductColorListAdapter (
    private val characterClickCallback: ((ProductColor?) -> Unit)?,
) : BaseListAdapter<ProductColor>(
    itemsSame = { old, new -> old.colour_name == new.colour_name },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductColorItemHolder -> {
                holder.bind(
                    product_color = getItem(position),
                    characterClickCallback = characterClickCallback,

                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return ProductColorItemHolder(parent, inflater)
    }

}