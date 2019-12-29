package com.georgcantor.storetest.view.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.Product
import com.georgcantor.storetest.viewmodel.UpdateViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf


class UpdateFragment : Fragment() {

    private lateinit var viewModel: UpdateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = getViewModel { parametersOf() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_update, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val drawable = ContextCompat.getDrawable(requireContext(), R.drawable.ic_cancel)
        val actionBar = (activity as AppCompatActivity).supportActionBar
        actionBar?.setHomeAsUpIndicator(drawable)
        actionBar?.setDisplayHomeAsUpEnabled(true)
        actionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_update, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> requireActivity().onBackPressed()
            R.id.save_product -> {
                viewModel.addProduct(
                    Product(
                        id = (0..100000).random(),
                        model = nameEditText.text.toString(),
                        price = java.lang.Float.valueOf(priceEditText.text.toString()),
                        quantity = 1
                    )
                )
            }
        }
        return false
    }

    override fun onDestroyView() {
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        super.onDestroyView()
    }

}