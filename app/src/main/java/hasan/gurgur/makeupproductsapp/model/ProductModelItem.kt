package hasan.gurgur.makeupproductsapp.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModelItem(
    val api_featured_image: String?,
    val brand: String?,
    val category: String?,
    val created_at: String?,
    val currency: String?,
    val description: String?,
    val id: Int?,
    val image_link: String?,
    val name: String?,
    val price: String?,
    @SerializedName("price_sign")
    val price_sign: String?,
    val product_api_url: String?,
    val product_colors: List<ProductColor>?,
    val product_link: String?,
    val product_type: String?,
    val rating: Double?,
    val tag_list: List<String>?,
    val updated_at: String?,
    val website_link: String?,
    var clickedFavItem : Boolean = false
): Parcelable


data class CircleModel(
    val url : String,
    val name : String
)