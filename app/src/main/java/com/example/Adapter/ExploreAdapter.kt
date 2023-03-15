package com.example.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.DataClass.ItemPost
import com.example.wikipedia.databinding.ItemExploreBinding

class ExploreAdapter(val data : ArrayList<ItemPost> , val itemEvents: ItemEvents) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {

    lateinit var binding: ItemExploreBinding

    inner class ExploreViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

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
                .into(binding.imgExploreMain)
        }

        fun setTextTextView(itemPost: ItemPost) {
            binding.txtExploreTitle.text = itemPost.txtTitle
            binding.txtExploreSubtitle.text = itemPost.txtSubtitle
            binding.txtExploreDetaile.text = itemPost.txtDetail
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        binding = ItemExploreBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ExploreViewHolder(binding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindView(data[position])
    }
}