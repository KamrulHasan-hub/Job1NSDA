package com.example.job1nsda.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.job1nsda.Product
import com.example.job1nsda.R

class ProductAdapter(private val products:List<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
  inner class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

      val productImg= itemView.findViewById<ImageView>(R.id.Image)
      val productID = itemView.findViewById<TextView>(R.id.idtxt)
      val productTitle = itemView.findViewById<TextView>(R.id.titletxt)
      val productsPrice= itemView.findViewById<TextView>(R.id.Pricetxt)
      val productDesc = itemView.findViewById<TextView>(R.id.Desctxt)


      fun bind(product: Product){
          productID.text=  product.id.toString()
          productTitle.text= product.title
          productsPrice.text= product.price.toString()
          productDesc.text=product.Description
          Glide.with(itemView).load(product.images[0])
              .into(productImg)
      }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent, false)
        return ProductViewHolder(view)
    }

    override fun getItemCount(): Int {
       return products.size
    }


    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
       val product =products[position]
        holder.bind(product)
    }
}