package com.georgcantor.storetest.view.fragment.company

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.georgcantor.storetest.BuildConfig
import com.georgcantor.storetest.R
import com.georgcantor.storetest.util.loadImage
import com.georgcantor.storetest.util.observe
import com.georgcantor.storetest.util.shortToast
import com.georgcantor.storetest.view.fragment.companies.CompaniesFragment.Companion.ARG_ID
import kotlinx.android.synthetic.main.fragment_company.*
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

class CompanyFragment : Fragment() {

    private lateinit var viewModel: CompanyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = getViewModel { parametersOf() }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_company, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(viewModel) {
            isProgressVisible.observe(viewLifecycleOwner) { visible ->
                progress_bar.visibility = if (visible) View.VISIBLE else View.GONE
            }

            error.observe(viewLifecycleOwner) { context?.shortToast(it) }

            getCompany(arguments?.getString(ARG_ID) ?: "")

            company.observe(viewLifecycleOwner) {
                context?.loadImage(
                    "${BuildConfig.BASE_URL}${it.img}",
                    company_image
                )

                title.text = it.name
                description.text = it.description
                it.phone.apply {
                    phone.text = if (this.isBlank()) getString(R.string.no_phone) else this
                }
            }
        }
    }
}