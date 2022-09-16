package hasan.gurgur.makeupproductsapp.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.makeupproductsapp.model.CircleModel
import hasan.gurgur.makeupproductsapp.ui.BaseListAdapter
import hasan.gurgur.makeupproductsapp.ui.product.ProductNameItemHolder

class ProductTypeListAdapter (
    private val characterClickCallback: ((CircleModel?) -> Unit)?,
) : BaseListAdapter<CircleModel>(
    itemsSame = { old, new -> old == new },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductTypeItemHolder -> {
                holder.bind(
                    productType = getItem(position),
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
        return ProductTypeItemHolder(parent, inflater)
    }

}