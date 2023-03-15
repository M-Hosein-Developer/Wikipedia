package com.example.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.DataClass.ItemPost
import com.example.wikipedia.databinding.ItemTrendBinding

class TrendAdapter(private val data : ArrayList<ItemPost> , val itemEvents: ItemEvents) : RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {

    lateinit var binding: ItemTrendBinding

    inner class TrendViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        fun bindView(itemPost: ItemPost) {

            glide(itemView , itemPost)
            setTextTextView(itemPost)

            itemView.setOnClickListener {

                itemEvents.onItemClicked(itemPost)

            }

        }

        fun glide(itemView: View, itemPost: ItemPost) {
            Glide.with(itemView.context)
                .load(itemPost.imgUrl)
                .into(binding.imgTrend)
        }

        fun setTextTextView(itemPost: ItemPost) {

            binding.txtTrendTitle.text = itemPost.txtTitle
            binding.txtTrendSubtitle.text = itemPost.txtSubtitle
            binding.txtTrendInsight.text = itemPost.insight
            binding.txtTrendNumber.text = (adapterPosition + 1).toString()

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        binding = ItemTrendBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return TrendViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bindView(data[position])
    }
}