package com.amoetaz.retrofillExample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amoetaz.retrofill.LayoutType
import com.amoetaz.retrofill.Retrofill
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Retrofill(this).showRecyclerViewList( rv_list , R.layout.list_item ,type = LayoutType.LINEAR
            ,isVertical = true, spanCount = 2, listSize = 6) {//Click listener
            startActivity(Intent(this@MainActivity , NestedListActivity::class.java))
        }
    }
}
