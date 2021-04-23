package com.example.adoptme.fragments

import android.content.Intent
import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import androidx.fragment.app.DialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptme.*

class HomeFragment : DialogFragment() {

    private lateinit var rvCat: RecyclerView
    private var list: ArrayList<Cat> = arrayListOf()

    private lateinit var llKucing: LinearLayout
    private lateinit var llAnjing: LinearLayout
    private lateinit var llIkan: LinearLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        // Inflate the layout for this fragment

        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        llKucing = view.findViewById(R.id.ll_kucing)
        llAnjing = view.findViewById(R.id.ll_anjing)
        llIkan = view.findViewById(R.id.ll_ikan)

        llKucing.setOnClickListener {
            val kucingIntent = Intent(activity, ListHewanActivity::class.java)
            kucingIntent.putExtra(ListHewanActivity.EXTRA_STATUS, 1)
            startActivity(kucingIntent)
        }

        llAnjing.setOnClickListener {
            val anjingIntent = Intent(activity, ListHewanActivity::class.java)
            anjingIntent.putExtra(ListHewanActivity.EXTRA_STATUS, 2)
            startActivity(anjingIntent)
        }

        llIkan.setOnClickListener {
            val ikanIntent = Intent(activity, ListHewanActivity::class.java)
            ikanIntent.putExtra(ListHewanActivity.EXTRA_STATUS, 3)
            startActivity(ikanIntent)
        }

        rvCat = view.findViewById(R.id.rv_item)
        rvCat.setHasFixedSize(true)

        list.addAll(CatData.listData)
        showRecyclerList()
    }

    private fun showRecyclerList() {
        rvCat.layoutManager = LinearLayoutManager(getContext())
        val listCatAdapter = ListCatAdapter(list)
        rvCat.adapter = listCatAdapter
    }

    private fun showRecyclerGrid() {
        rvCat.layoutManager = GridLayoutManager(getContext(), 2)
        val gridHeroAdapter = GridCatAdapter(list)
        rvCat.adapter = gridHeroAdapter
    }

     override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
         inflater.inflate(R.menu.recycler_menu, menu)
         return super.onCreateOptionsMenu(menu, inflater)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.action_list -> {
                showRecyclerList()
            }
            R.id.action_grid -> {
                showRecyclerGrid()
            }
            R.id.action_cardview -> {
            }
        }
    }
}