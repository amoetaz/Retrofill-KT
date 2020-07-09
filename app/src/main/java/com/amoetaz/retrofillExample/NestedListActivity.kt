package com.amoetaz.retrofillExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amoetaz.retrofill.LayoutType
import com.amoetaz.retrofill.Retrofill
import kotlinx.android.synthetic.main.activity_nested_list.*

class NestedListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested_list)

        Retrofill(this).showNestedRecyclerViewList(
            rv_outer_list,
            R.layout.outer_list_item,
            R.id.rv_inner_list,
            R.layout.inner_list_item,
            outerListType = LayoutType.LINEAR,
            innerListType = LayoutType.LINEAR,
            outerListIsVertical = true,
            outerListSpanCount = 2,
            outerListLstSize = 4,
            innerListIsVertical = true,
            innerListSpanCount = 2,
            innerListLstSize = 5
        ) {
            Toast.makeText(this@NestedListActivity, "Fantastic", Toast.LENGTH_LONG).show()
        }
    }
}
