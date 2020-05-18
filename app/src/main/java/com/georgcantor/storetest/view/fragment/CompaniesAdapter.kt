package com.georgcantor.storetest.view.fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.storetest.BuildConfig
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.data.ApiResponse
import com.georgcantor.storetest.util.loadImage
import kotlinx.android.synthetic.main.item_company.view.*

class CompaniesAdapter(
    companies: MutableList<ApiResponse>,
    private val clickListener: (ApiResponse) -> Unit
) : RecyclerView.Adapter<CompaniesAdapter.CompaniesViewHolder>() {

    private val companies = mutableListOf<ApiResponse>()

    init {
        this.companies.addAll(companies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompaniesViewHolder {
        return CompaniesViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_company, parent, false)
        )
    }

    override fun getItemCount() = companies.size

    override fun onBindViewHolder(holder: CompaniesViewHolder, position: Int) {
        val company = companies[position]

        with(holder) {
            itemView.context.loadImage(
                "${BuildConfig.BASE_URL}${company.img}",
                image
            )

            name.text = company.name

            itemView.setOnClickListener { clickListener(company) }
        }
    }

    class CompaniesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView = view.company_image
        val name: TextView = view.company_name
    }
}