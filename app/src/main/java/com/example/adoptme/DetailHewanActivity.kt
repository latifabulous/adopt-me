package com.example.adoptme

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DetailHewanActivity : AppCompatActivity(), View.OnClickListener {
    private var catList: ArrayList<Cat> = arrayListOf()
    private var dogList: ArrayList<Dog> = arrayListOf()
    private var fishList: ArrayList<Fish> = arrayListOf()

    companion object {
        var EXTRA_LIST = "extra_list"
        var EXTRA_POSITION = "extra_position"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hewan)

        val listHewan = intent.getStringExtra(EXTRA_LIST)
        val position = intent.getIntExtra(EXTRA_POSITION, 0)

        val tvItemName : TextView = findViewById(R.id.tv_item_name)
        val tvItemPhoto : ImageView = findViewById(R.id.img_item_photo)
        val tvItemDetail : TextView = findViewById(R.id.tv_item_detail)

        val btnTel : Button = findViewById(R.id.btn_tlp)

        btnTel.setOnClickListener(this)

        when(listHewan){
            "Cat" -> {
                catList.addAll(CatData.listData)

                tvItemName.setText(catList[position].name)
                tvItemPhoto.setImageResource(catList[position].photo)
                tvItemDetail.setText(catList[position].detail)
            }
            "Dog" -> {
                dogList.addAll(DogData.listData)

                tvItemName.setText(dogList[position].name)
                tvItemPhoto.setImageResource(dogList[position].photo)
                tvItemDetail.setText(dogList[position].detail)
            }
            "Fish" -> {
                fishList.addAll(FishData.listData)

                tvItemName.setText(fishList[position].name)
                tvItemPhoto.setImageResource(fishList[position].photo)
                tvItemDetail.setText(fishList[position].detail)
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_tlp -> {
                val phoneNumber = "087704620821"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }
        }
    }
}