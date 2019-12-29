package com.georgcantor.storetest.view.fragment

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.Product
import com.georgcantor.storetest.util.shortToast
import com.georgcantor.storetest.viewmodel.UpdateViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import org.koin.androidx.viewmodel.ext.android.getSharedViewModel
import org.koin.core.parameter.parametersOf
import java.lang.Float

class UpdateFragment : Fragment() {

    private lateinit var viewModel: UpdateViewModel
    private lateinit var manager: InputMethodManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        viewModel = getSharedViewModel { parametersOf() }
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

        manager = requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager

        viewModel.updatedProduct.observe(viewLifecycleOwner, Observer {
            it?.let {
                nameEditText.setText(it.model)
                priceEditText.setText(it.price.toString())
                quantityEditText.setText(it.quantity.toString())
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_update, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> requireActivity().onBackPressed()
            R.id.save_product -> {
                viewModel.updatedProduct.observe(viewLifecycleOwner, Observer { product ->
                    if (nameEditText.text.isEmpty() || priceEditText.text.isEmpty() || quantityEditText.text.isEmpty()) {
                        requireContext().shortToast("Заполните все поля")
                    } else {
                        hideKeyboard()
                        if (product != null) {
                            viewModel.updateProduct(
                                Product(
                                    id = product.id,
                                    model = nameEditText.text.toString(),
                                    price = Float.valueOf(priceEditText.text.toString()),
                                    quantity = quantityEditText.text.toString().toInt()
                                )
                            )
                        } else {
                            viewModel.addProduct(
                                Product(
                                    id = (0..100000).random(),
                                    model = nameEditText.text.toString(),
                                    price = Float.valueOf(priceEditText.text.toString()),
                                    quantity = quantityEditText.text.toString().toInt()
                                )
                            )
                        }

                        Handler().postDelayed({
                            requireActivity().onBackPressed()
                        }, 500)
                    }
                })
            }
        }
        return false
    }

    override fun onDestroyView() {
        (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(false)
        hideKeyboard()
        super.onDestroyView()
    }

    private fun hideKeyboard() {
        manager.hideSoftInputFromWindow(requireActivity().window.decorView.rootView.windowToken, 0)
    }

}