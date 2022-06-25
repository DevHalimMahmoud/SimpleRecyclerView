package com.example.simplerecyclerview

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemArrayAdapter     // Constructor of the class
    (//All methods in this adapter are required for a bare minimum recyclerview adapter
    private val listItemLayout: Int, private val itemList: ArrayList<Item>?
) : RecyclerView.Adapter<ItemArrayAdapter.ViewHolder>() {
    // get the size of the list
    override fun getItemCount(): Int {
        return itemList?.size ?: 0
    }

    // specify the row layout file and click for each row
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(listItemLayout, parent, false)
        return ViewHolder(view)
    }

    // load data in each row element
    override fun onBindViewHolder(holder: ViewHolder, listPosition: Int) {
        val name = holder.name
        val title = holder.title
        val id = holder.id
        name.text = itemList!![listPosition].name
        title.text = itemList[listPosition].title
        id.text = itemList[listPosition].id
    }

    // Static inner class to initialize the views of rows
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        var name: TextView
        var title: TextView
        var id: TextView
        override fun onClick(view: View) {
            Log.d("onclick", "onClick " + layoutPosition + " " + name.text)
        }

        init {
            itemView.setOnClickListener(this)
            name = itemView.findViewById<View>(R.id.name) as TextView
            title = itemView.findViewById<View>(R.id.title) as TextView
            id = itemView.findViewById<View>(R.id.id) as TextView
        }
    }
}