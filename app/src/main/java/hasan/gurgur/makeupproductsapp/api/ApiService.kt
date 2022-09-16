package hasan.gurgur.makeupproductsapp.api

import hasan.gurgur.makeupproductsapp.model.ProductModel
import hasan.gurgur.makeupproductsapp.model.ProductModelItem
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("products.json")
    fun getProducts(@Query("brand") brand : String) : Single<ProductModel>

    @GET("products.json")
    fun getProductType(@Query("productType") productType : String) : Single<ProductModelItem>
}