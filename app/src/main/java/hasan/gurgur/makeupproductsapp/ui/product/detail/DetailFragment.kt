package hasan.gurgur.makeupproductsapp.ui.product.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import hasan.gurgur.makeupproductsapp.databinding.FragmentDetailBinding

@AndroidEntryPoint
class DetailFragment : Fragment() {

    val args : hasan.gurgur.makeupproductsapp.ui.product.detail.DetailFragmentArgs by navArgs()

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    lateinit var produc_color_adaper : ProductColorListAdapter





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        binding.product = args.productDetail
        initAdapter()
        val navController = findNavController()
        val appBarConfig = AppBarConfiguration(navController.graph)


        binding.toolbar.setupWithNavController(navController,appBarConfig)




        return binding.root
    }


    private fun initAdapter() {
        produc_color_adaper = ProductColorListAdapter {
            Toast.makeText(requireContext(), it?.colour_name, Toast.LENGTH_SHORT).show()
        }
        binding.productColorRec.layoutManager = GridLayoutManager(requireContext(),5)
        binding.productColorRec.adapter = produc_color_adaper
        binding.productColorRec.isNestedScrollingEnabled = false
        produc_color_adaper.submitList(args.productDetail?.product_colors)
    }

}