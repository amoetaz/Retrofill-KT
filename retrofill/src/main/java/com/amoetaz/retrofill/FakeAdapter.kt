package com.amoetaz.retrofill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class FakeAdapter(val models: ArrayList<Any>, val layout: Int,val action: () -> Unit)
    : RecyclerView.Adapter<FakeAdapter.MyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(layout, parent, false))
    }

    override fun getItemCount() = models.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        addListernerToClick(holder.itemView)
    }

    private fun addListernerToClick(view: View) {
        if (view is ViewGroup) {
            for (i in 0 until view.childCount) {
                val innerChild = view.getChildAt(i)
                addListernerToClick(innerChild)
            }
        } else {
            view.setOnClickListener {
                action()
            }
        }
    }

    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view)
}