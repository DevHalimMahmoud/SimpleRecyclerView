package com.example.simplerecyclerview

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initializing list view with the custom adapter
        val itemList = ArrayList<Item>()
        val itemArrayAdapter = ItemArrayAdapter(R.layout.list_item, itemList)
        recyclerView = findViewById<View>(R.id.item_list) as RecyclerView
        recyclerView!!.layoutManager = LinearLayoutManager(this)
        recyclerView!!.itemAnimator = DefaultItemAnimator()
        recyclerView!!.adapter = itemArrayAdapter

        // Populating list items
        for (i in 0..99) {
            itemList.add(Item("Item ", "5", "asdf"))
        }
    }
}