package com.georgcantor.storetest.view.fragment.companies

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.georgcantor.storetest.R
import com.georgcantor.storetest.util.observe
import com.georgcantor.storetest.util.shortToast
import kotlinx.android.synthetic.main.fragment_companies.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class CompaniesFragment : Fragment() {

    companion object {
        const val ARG_ID = "company_id"
    }

    private lateinit var viewModel: CompaniesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel { parametersOf() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_companies, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            isProgressVisible.observe(viewLifecycleOwner) { visible ->
                progress_bar.visibility = if (visible) VISIBLE else GONE
            }

            error.observe(viewLifecycleOwner) { context?.shortToast(it) }

            companies.observe(viewLifecycleOwner) {
                companies_recycler.adapter = CompaniesAdapter(it) {
                    findNavController(this@CompaniesFragment).navigate(
                        R.id.action_companiesFragment_to_companyFragment,
                        Bundle().apply { putString(ARG_ID, it.id) }
                    )
                }
            }
        }
    }
}