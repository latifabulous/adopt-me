package com.example.adoptme.fragments

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.PopupMenu
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adoptme.*

class HomeFragment : DialogFragment() {
    private lateinit var rvCat: RecyclerView
    private var list: ArrayList<Cat> = arrayListOf()
//    private lateinit var btnMenu: Button

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
//        btnMenu = view.findViewById(R.id.btn_menu)
//
//        registerForContextMenu(btnMenu)

        rvCat = view.findViewById(R.id.rv_cat)
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

//    override fun onCreateContextMenu(menu: ContextMenu, v: View, menuInfo: ContextMenu.ContextMenuInfo?
//    ) {
////        super.onCreateContextMenu(menu, v, menuInfo)
//        getActivity()?.getMenuInflater()?.inflate(R.menu.recycler_menu, menu)
//    }

//    override fun onContextItemSelected(item: MenuItem): Boolean {
//        setMode(item.itemId)
//        return super.onContextItemSelected(item)
//    }

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