package com.georgcantor.storetest.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.Product
import com.georgcantor.storetest.util.shortToast
import com.georgcantor.storetest.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.fragment_product.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class ProductFragment : Fragment() {

    private lateinit var viewModel: ProductViewModel

    companion object {
        private const val PRODUCT = "product"

        fun newInstance(product: Product): ProductFragment {
            val bundle = Bundle()
            bundle.putParcelable(PRODUCT, product)
            val fragment = ProductFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel { parametersOf() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_product, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product: Product = arguments?.get(PRODUCT) as Product

        modelTextView.text = product.model
        priceTextView.text = getString(R.string.price_format, product.price.toString())
        quantityTextView.text = getString(R.string.quantity_format, product.quantity.toString())

        buyButton.setOnClickListener {
            viewModel.buyProduct(product.id)
            product.quantity--
            quantityTextView.text = getString(R.string.quantity_format, product.quantity.toString())
            if (product.quantity == 0) {
                requireContext().shortToast("${product.model} закончился")
                requireActivity().recreate()
            }
        }
    }

}