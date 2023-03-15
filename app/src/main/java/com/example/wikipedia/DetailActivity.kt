package com.example.wikipedia

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.example.DataClass.ItemPost
import com.example.Fragment.SEND_DATA_TO_SECOND_ACTIVITY
import com.example.wikipedia.databinding.ActivityDetailBinding
import com.example.wikipedia.databinding.ItemTrendBinding

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupToolBar()
        setData()

    }

    private fun setData() {

        val dataPost = intent.getParcelableExtra<ItemPost>(SEND_DATA_TO_SECOND_ACTIVITY)

        if (dataPost != null){

            showData(dataPost)

        }

    }

    private fun showData(itemPost : ItemPost) {

        Glide.with(this)
            .load(itemPost.imgUrl)
            .into(binding.imgDetail)

        binding.txtTitle.text = itemPost.txtTitle
        binding.txtSubtitle.text = itemPost.txtSubtitle
        binding.txtText.text = itemPost.txtDetail

        binding.fabOpenMain.setOnClickListener {

            val url = "https://en.wikipedia.org/wiki/Main_Page"
            val intent = Intent(Intent.ACTION_VIEW , Uri.parse(url))
            startActivity(intent)

        }

    }

    private fun setupToolBar() {
        setSupportActionBar(binding.toolbar)

        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        binding.collaps.setExpandedTitleColor(
            ContextCompat.getColor(this , android.R.color.transparent)
        )
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == android.R.id.home){

            onBackPressed()

        }

        return true
    }
}