package com.amoetaz.retrofill

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FakeNestedAdapter(val context: Context, val models: ArrayList<Any>,
    val listItem: Int, val innerListType: LayoutType,
    val innerListItem: Int,val innerListSize: Int,
    val nestedRecylerViewId: Int,val innerListSpanCount : Int ,val innerListIsVertical : Boolean,val action : () ->Unit
) : RecyclerView.Adapter<FakeNestedAdapter.MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(listItem, parent, false))
    }

    override fun getItemCount() = models.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.d("fvfdvfv" , "$position")
        Retrofill(context).showRecyclerViewList( holder.nestedReclerView, innerListItem ,isVertical = innerListIsVertical,
            type = innerListType , spanCount = innerListSpanCount , listSize = innerListSize){
            action()
        }
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nestedReclerView = view.findViewById<RecyclerView>(nestedRecylerViewId)
    }
}