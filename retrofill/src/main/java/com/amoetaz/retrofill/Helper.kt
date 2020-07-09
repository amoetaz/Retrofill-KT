package com.amoetaz.retrofill

import android.content.Context

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

import java.util.ArrayList

object Helper {
    fun getArrayList(listSize: Int): ArrayList<Any> {
        val `object` = Any()
        val list = ArrayList<Any>()
        for (i in 0 until listSize) {
            list.add(`object`)
        }
        return list
    }

    fun getLayoutType(context: Context, type: LayoutType, isVertical: Boolean, spanCount: Int)
            : RecyclerView.LayoutManager {
        val layoutManager: RecyclerView.LayoutManager
        if (type === LayoutType.LINEAR)
            if (isVertical)
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            else
                layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        else if (type === LayoutType.GRID)
            if (isVertical)
                layoutManager =
                    GridLayoutManager(context, spanCount, GridLayoutManager.VERTICAL, false)
            else
                layoutManager =
                    GridLayoutManager(context, spanCount, GridLayoutManager.HORIZONTAL, false)
        else if (isVertical)
            layoutManager =
                StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL)
        else
            layoutManager =
                StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.HORIZONTAL)

        return layoutManager
    }
}
