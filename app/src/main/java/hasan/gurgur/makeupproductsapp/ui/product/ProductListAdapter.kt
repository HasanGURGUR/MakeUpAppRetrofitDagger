package hasan.gurgur.makeupproductsapp.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.makeupproductsapp.model.ProductModelItem
import hasan.gurgur.makeupproductsapp.ui.BaseListAdapter

class ProductListAdapter (
    private val characterClickCallback: ((ProductModelItem?) -> Unit)?,
    private val favClick: ((ProductModelItem?) -> Unit)?
) : BaseListAdapter<ProductModelItem>(
    itemsSame = { old, new -> old.id == new.id },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductItemHolder -> {
                holder.bind(
                    product = getItem(position),
                    characterClickCallback = characterClickCallback,
                    favClick
                )
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        inflater: LayoutInflater,
        viewType: Int
    ): RecyclerView.ViewHolder {
        return ProductItemHolder(parent, inflater)
    }

}