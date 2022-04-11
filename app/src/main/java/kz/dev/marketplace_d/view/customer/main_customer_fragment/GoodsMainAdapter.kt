package kz.dev.marketplace_d.view.customer.main_customer_fragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kz.dev.marketplace_d.R
import kz.dev.marketplace_d.model.response.Good

class GoodsMainAdapter(var goods: ArrayList<Good>):
    RecyclerView.Adapter<GoodsMainAdapter.GoodsViewHolder>() {

    fun updateGoods(newGoods: List<Good>) {
        goods.clear()
        goods.addAll(newGoods)
        notifyDataSetChanged()
    }

    inner class GoodsViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageViewGood = view.findViewById<ImageView>(R.id.ivGood)
        private val tvTitleOfGood = view.findViewById<TextView>(R.id.tvTitleOfGood)
        private val tvPriceValue = view.findViewById<TextView>(R.id.tvPriceValue)
        private val tvPriceWithoutDisc = view.findViewById<TextView>(R.id.tvPriceWithoutDisc)

        fun bind(good: Good) {

            tvTitleOfGood.text = good.title
            tvPriceValue.text = good.price
            tvPriceWithoutDisc.text = good.original_price

            Glide.with(itemView)
                .load(good.images?.get(0)?.medium)
                .centerCrop()
                .into(imageViewGood)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = GoodsViewHolder (
       LayoutInflater.from(parent.context).inflate(R.layout.item_goods, parent, false)
    )

    override fun onBindViewHolder(holder: GoodsViewHolder, position: Int) {
            holder.bind(goods[position])
    }

    override fun getItemCount() = goods.size
}