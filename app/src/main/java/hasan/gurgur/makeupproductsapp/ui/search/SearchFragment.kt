package hasan.gurgur.makeupproductsapp.ui.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hasan.gurgur.makeupproductsapp.R
import hasan.gurgur.makeupproductsapp.databinding.FragmentProductBinding
import hasan.gurgur.makeupproductsapp.databinding.FragmentSearchBinding
import hasan.gurgur.makeupproductsapp.model.CircleModel
import hasan.gurgur.makeupproductsapp.ui.product.ProductListAdapter
import hasan.gurgur.makeupproductsapp.viewmodel.ProductViewModel

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ProductViewModel by viewModels()
    lateinit var productTypeAdapter : ProductTypeListAdapter
    val listProductType: ArrayList<CircleModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        initAdapter()

       viewModel.productModel.observe(requireActivity()) {

        }
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initAdapter() {
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/915/original/open-uri20171224-4-uv4oww?1514082622", "Blush"))
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/926/original/open-uri20171224-4-6mx0la?1514082656", "Bronzer"))
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/985/original/data?1514082775", "Eyebrow"))
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/196/original/open-uri20171223-4-p5h931?1514062283", "Eyeliner"))
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/804/original/open-uri20171223-4-1ljakeo?1514072320", "Eyeshadow"))
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/903/original/open-uri20171224-4-1rbb28u?1514082678", "Foundation"))
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/409/original/data?1514063319", "Lip liner"))
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/001/023/original/open-uri20180630-4-149dwc3?1530390375", "Lipstick"))
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/997/original/data?1514082787", "Mascara"))
     listProductType.add(CircleModel("http://s3.amazonaws.com/donovanbailey/products/api_featured_images/000/000/142/original/data?1514062268", "Nail polish"))

        productTypeAdapter = ProductTypeListAdapter {
            viewModel.fetchProductTypeDataFromRemoteApi(it?.name.toString())
            Toast.makeText(requireContext(), it?.name, Toast.LENGTH_SHORT).show()
        }
        binding.productTypeRec.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.productTypeRec.adapter = productTypeAdapter
        productTypeAdapter.submitList(listProductType)
    }

}