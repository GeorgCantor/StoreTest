package com.georgcantor.storetest.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.Product
import com.georgcantor.storetest.util.shortToast
import com.georgcantor.storetest.view.adapter.BackAdapter
import com.georgcantor.storetest.viewmodel.BackViewModel
import kotlinx.android.synthetic.main.fragment_back.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class BackFragment : Fragment() {

    private lateinit var viewModel: BackViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel { parametersOf() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_back, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        productsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        productsRecyclerView.setHasFixedSize(true)
        viewModel.getProducts()

        viewModel.products.observe(viewLifecycleOwner, Observer {
            productsRecyclerView.adapter = BackAdapter(
                requireContext(),
                it as MutableList<Product>
            ) { product ->
                requireContext().shortToast(product.model.toString())
            }
        })
    }

}