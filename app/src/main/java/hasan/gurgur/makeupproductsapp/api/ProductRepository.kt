package hasan.gurgur.makeupproductsapp.api

import hasan.gurgur.makeupproductsapp.model.ProductModel
import hasan.gurgur.makeupproductsapp.model.ProductModelItem
import io.reactivex.Single
import javax.inject.Inject

class ProductRepository @Inject constructor(val apiService: ApiService) {


    fun getProducts(brand : String) : Single<ProductModel>{
        return apiService.getProducts(brand)
    }

    fun getProductType(productType : String) : Single<List<ProductModelItem>> {
        return apiService.getProductType(productType)
    }
}