package com.android.fibonacci

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log

class MainActivity : AppCompatActivity() {
    private var mRecyclerView: RecyclerView? = null
    private val recycler_view_items = 20
    private val TAG = MainActivity::class.qualifiedName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val mLayoutManager = LinearLayoutManager(this)
        supportActionBar!!.setTitle("Fibonacci Fun")
        setContentView(R.layout.activity_main)
        mRecyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        mRecyclerView!!.layoutManager = mLayoutManager
        mRecyclerView!!.itemAnimator = DefaultItemAnimator()
        val recyclerViewAdapter = RecyclerViewAdapter(recycler_view_items);
        mRecyclerView!!.adapter = recyclerViewAdapter
        mRecyclerView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                Log.d(TAG, "last visible position: ${mLayoutManager.findLastCompletelyVisibleItemPosition()}, total count: ${mLayoutManager.itemCount}")
                if (mLayoutManager.findLastCompletelyVisibleItemPosition() >= mLayoutManager.itemCount - 1) {
                    recyclerViewAdapter.addItems(recycler_view_items)
                }
            }
        })
    }


}
