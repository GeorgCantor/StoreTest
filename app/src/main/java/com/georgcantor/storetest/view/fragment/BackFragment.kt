package com.georgcantor.storetest.view.fragment

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.Product
import com.georgcantor.storetest.view.adapter.BackAdapter
import com.georgcantor.storetest.viewmodel.BackViewModel
import com.georgcantor.storetest.viewmodel.UpdateViewModel
import kotlinx.android.synthetic.main.fragment_back.*
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class BackFragment : Fragment() {

    private lateinit var viewModel: BackViewModel
    private lateinit var updateViewModel: UpdateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = getViewModel { parametersOf() }
        updateViewModel = getSharedViewModel { parametersOf() }
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

        viewModel.getProducts().observe(viewLifecycleOwner, Observer {
            productsRecyclerView.adapter = BackAdapter(
                requireContext(),
                it as MutableList<Product>
            ) { product ->
                updateViewModel.setUpdatedProduct(product)
                view?.let { Navigation.findNavController(it).navigate(R.id.updateFragment) }
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_back, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.add_product -> {
                updateViewModel.setUpdatedProduct(null)
                view?.let { Navigation.findNavController(it).navigate(R.id.updateFragment) }
            }
        }
        return false
    }

}