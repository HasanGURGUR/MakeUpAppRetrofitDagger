package hasan.gurgur.makeupproductsapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductColor(
    val colour_name: String?,
    val hex_value: String?
):Parcelable