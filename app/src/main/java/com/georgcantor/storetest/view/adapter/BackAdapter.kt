package com.georgcantor.storetest.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.Product

class BackAdapter(
    products: MutableList<Product>,
    private val clickListener: (Product) -> Unit
) : RecyclerView.Adapter<BackAdapter.BackViewHolder>() {

    private val products: MutableList<Product> = ArrayList()

    init {
        this.products.addAll(products)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BackViewHolder =
        BackViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.product_item, null))

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: BackViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class BackViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    }

}