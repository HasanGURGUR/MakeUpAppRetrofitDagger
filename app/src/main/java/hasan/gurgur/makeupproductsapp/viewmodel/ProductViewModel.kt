package hasan.gurgur.makeupproductsapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import hasan.gurgur.makeupproductsapp.api.ProductRepository
import hasan.gurgur.makeupproductsapp.model.ProductModel
import hasan.gurgur.makeupproductsapp.model.ProductModelItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(private val repository: ProductRepository) :
    ViewModel() {


    val productModel = MutableLiveData<ProductModel>()
    val productTypeModel = MutableLiveData<List<ProductModelItem>>()
    private val disposable: CompositeDisposable = CompositeDisposable()


    fun fetchDataFromRemoteApi(brand: String) {

        disposable.add(

            repository.getProducts(brand)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<ProductModel>() {
                    override fun onSuccess(response: ProductModel) {
                        productModel.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                }
                )
        )
    }


    fun fetchProductTypeDataFromRemoteApi(productType: String) {

        disposable.add(
            repository.getProductType(productType)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<List<ProductModelItem>>() {
                    override fun onSuccess(response: List<ProductModelItem>) {
                        productTypeModel.value = response
                    }

                    override fun onError(e: Throwable) {
                        e.printStackTrace()
                    }
                }
                )
        )
    }
}