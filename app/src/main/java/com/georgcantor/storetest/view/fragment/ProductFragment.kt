package com.georgcantor.storetest.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.Product

class ProductFragment : Fragment() {

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
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_product, container, false)

}