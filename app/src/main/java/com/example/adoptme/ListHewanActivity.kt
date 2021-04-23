package com.example.adoptme

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListHewanActivity : AppCompatActivity() {

    private lateinit var rvList: RecyclerView

    private var catList: ArrayList<Cat> = arrayListOf()
    private var dogList: ArrayList<Dog> = arrayListOf()
    private var fishList: ArrayList<Fish> = arrayListOf()

    companion object{
        const val EXTRA_STATUS = "extra_status"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_hewan)

        val status = intent.getIntExtra(EXTRA_STATUS, 0)

        rvList = findViewById(R.id.rv_item)
        rvList.setHasFixedSize(true)

        catList.addAll(CatData.listData)
        dogList.addAll(DogData.listData)
        fishList.addAll(FishData.listData)

        when(status){
            1 -> {
                showCatRecyclerList()
            }
            2 -> {
                showDogRecyclerList()
            }
            3 -> {
                showFishRecyclerList()
            }
        }
    }

    private fun showCatRecyclerList() {
//        rvList.layoutManager = LinearLayoutManager(this)
//        val listCatAdapter = ListCatAdapter(catList)
//        rvList.adapter = listCatAdapter

        rvList.layoutManager = GridLayoutManager(this, 2)
        val gridHeroAdapter = GridCatAdapter(catList)
        rvList.adapter = gridHeroAdapter
    }

    private fun showDogRecyclerList() {
        rvList.layoutManager = LinearLayoutManager(this)
        val listDogAdapter = ListDogAdapter(dogList)
        rvList.adapter = listDogAdapter
    }

    private fun showFishRecyclerList() {
        rvList.layoutManager = LinearLayoutManager(this)
        val listFishAdapter = ListFishAdapter(fishList)
        rvList.adapter = listFishAdapter
    }
}