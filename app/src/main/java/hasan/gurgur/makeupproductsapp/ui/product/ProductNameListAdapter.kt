package hasan.gurgur.makeupproductsapp.ui.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hasan.gurgur.makeupproductsapp.ui.BaseListAdapter

class ProductNameListAdapter (
    private val characterClickCallback: ((String?) -> Unit)?,
) : BaseListAdapter<String>(
    itemsSame = { old, new -> old == new },
    contentsSame = { old, new -> old == new }
) {

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is ProductNameItemHolder -> {
                holder.bind(
                    brandName = getItem(position),
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
        return ProductNameItemHolder(parent, inflater)
    }

}