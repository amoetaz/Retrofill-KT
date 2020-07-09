package com.amoetaz.retrofill

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.amoetaz.retrofill.Helper.getArrayList
import com.amoetaz.retrofill.Helper.getLayoutType

class Retrofill(val context: Context) {

    fun showRecyclerViewList(
        view: RecyclerView, listItem: Int, type: LayoutType = LayoutType.LINEAR
        , isVertical: Boolean = true, spanCount: Int = 2, listSize: Int = 6
        , action: () -> Unit = {}
    ) {
        val adapter = FakeAdapter(getArrayList(listSize), listItem, action)

        val layoutManager = getLayoutType(context , type , isVertical ,spanCount)

        view.layoutManager =
            if (type == LayoutType.STAGGERED_GRID) (layoutManager as StaggeredGridLayoutManager)
            else (layoutManager as RecyclerView.LayoutManager)
        view.adapter = adapter
    }

    fun showNestedRecyclerViewList(outerRecylerview: RecyclerView, outerListItem: Int,
        innerRecylerviewId: Int, innerListItem: Int,
        outerListType: LayoutType = LayoutType.LINEAR, innerListType: LayoutType = LayoutType.LINEAR
        , outerListIsVertical: Boolean = true, outerListSpanCount: Int = 2, outerListLstSize: Int = 4, innerListIsVertical: Boolean = true,
        innerListSpanCount: Int = 2, innerListLstSize: Int = 5, action: () -> Unit = {}
    ) {

        val adapter = FakeNestedAdapter(
            context, getArrayList(outerListLstSize), outerListItem, innerListType, innerListItem,
            innerListLstSize, innerRecylerviewId , innerListSpanCount , innerListIsVertical,action
        )

        val layoutManager =
            getLayoutType(context, outerListType, outerListIsVertical, outerListSpanCount)
        outerRecylerview.layoutManager =
            if (outerListType == LayoutType.STAGGERED_GRID) (layoutManager as StaggeredGridLayoutManager)
            else (layoutManager as RecyclerView.LayoutManager)
        outerRecylerview.adapter = adapter
    }


}