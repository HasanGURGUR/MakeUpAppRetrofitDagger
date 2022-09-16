package hasan.gurgur.makeupproductsapp.util

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import hasan.gurgur.makeupproductsapp.R


object BindingAdapter {

    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImageFromUrl(imageview: ImageView, url: String?) {

        if (url == null) {
            Glide.with(imageview.context).load(R.drawable.placeholder_makeup).into(imageview)
        } else {

            Glide.with(imageview.context).load(url).into(imageview)
        }

    }

    @JvmStatic
    @BindingAdapter("loadPriceSign")
    fun loadPriceSign(textView: TextView, originalSign: String?) {
        if (originalSign == null) {
            textView.text = "$"
        } else {
            textView.text = originalSign
        }
    }



    @JvmStatic
    @BindingAdapter("loadHexCode")
    fun loadHexCode(imageview: ImageView, hex_color: String?) {
        imageview.setBackgroundColor(Color.parseColor(hex_color));
    }


    @JvmStatic
    @BindingAdapter("firstCap")
    fun firstCap(textView: TextView, text: String){
        textView.text = text.replaceFirstChar { it.uppercase() }
    }
}