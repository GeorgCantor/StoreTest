package com.georgcantor.storetest.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment

class ProductFragment : Fragment() {

    companion object {
        private const val QUERY = "query"

        fun newInstance(query: String): ProductFragment {
            val bundle = Bundle()
            bundle.putString(QUERY, query)
            val fragment = ProductFragment()
            fragment.arguments = bundle

            return fragment
        }
    }

}