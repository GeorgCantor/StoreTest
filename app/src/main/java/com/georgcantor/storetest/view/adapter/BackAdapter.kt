package com.georgcantor.storetest.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.georgcantor.storetest.R
import com.georgcantor.storetest.model.Product
import kotlinx.android.synthetic.main.product_item.view.*

class BackAdapter(
    private val context: Context,
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
        holder.modelTextView.text = products[position].model
        holder.quantityTextView.text = context.getString(
            R.string.quantity_format,
            products[position].quantity.toString()
        )
        holder.itemView.setOnClickListener {
            clickListener(products[position])
        }
    }

    class BackViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val modelTextView: TextView = view.modelTextView
        val quantityTextView: TextView = view.quantityTextView
    }

}