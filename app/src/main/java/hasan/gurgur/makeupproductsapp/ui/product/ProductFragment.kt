package hasan.gurgur.makeupproductsapp.ui.product

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
import hasan.gurgur.makeupproductsapp.viewmodel.ProductViewModel

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!


    private val viewModel: ProductViewModel by viewModels()
    lateinit var productListAdapter: ProductListAdapter
    lateinit var brandtListAdapter: ProductNameListAdapter
    val listBrand: ArrayList<String> = arrayListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProductBinding.inflate(inflater, container, false)

        initAdapter()
        viewModel.fetchDataFromRemoteApi("almay")

        viewModel.productModel.observe(requireActivity()) {

            productListAdapter.submitList(it)
        }
        initBrandAdapter()
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


    private fun initAdapter() {
        productListAdapter = ProductListAdapter(characterClickCallback = {
            findNavController().navigate(
                R.id.action_productFragment_to_detailFragment,
                bundleOf("product_detail" to it)
            )
        }, favClick = {
            it?.clickedFavItem = !it?.clickedFavItem!!
            productListAdapter.notifyDataSetChanged()
        })

        binding.productRec.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

        binding.productRec.adapter = productListAdapter

    }

    private fun initBrandAdapter() {
        listBrand.addAll(
            arrayListOf(
                "almay",
                "alva",
                "anna sui",
                "annabelle",
                "benefit",
                "boosh",
                "burt's bees",
                "butter london",
                "c'est moi",
                "cargo cosmetics",
                "china glaze",
                "clinique",
                "coastal classic creation",
                "colourpop",
                "covergirl",
                "dalish",
                "deciem",
                "dior",
                "dr. hauschka",
                "e.l.f.",
                "essie",
                "fenty",
                "glossier",
                "green people",
                "iman",
                "l'oreal",
                "lotus cosmetics usa",
                "maia's mineral galaxy",
                "marcelle",
                "marienatie",
                "maybelline",
                "milani",
                "mineral fusion",
                "misa",
                "mistura",
                "moov",
                "nudus",
                "nyx",
                "orly",
                "pacifica",
                "penny lane organics",
                "physicians formula",
                "piggy paint",
                "pure anada",
                "rejuva minerals",
                "revlon",
                "sally b's skin yummies",
                "salon perfect",
                "sante",
                "sinful colours",
                "smashbox",
                "stila",
                "suncoat",
                "w3llpeople",
                "wet n wild",
                "zorah",
                "zorah biocosmetiques"
            )
        )
        brandtListAdapter = ProductNameListAdapter {
            viewModel.fetchDataFromRemoteApi(it.toString())
        }
        binding.productNameRec.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        binding.productNameRec.adapter = brandtListAdapter
        brandtListAdapter.submitList(listBrand)

    }


}