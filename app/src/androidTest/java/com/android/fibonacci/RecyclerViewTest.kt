package com.android.fibonacci

import android.content.Context
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before
import org.mockito.MockitoAnnotations
import org.mockito.Mock


@RunWith(AndroidJUnit4::class)
class RecyclerViewTest {

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getTargetContext()
        assertEquals("com.android.fibonacci", appContext.packageName)
    }

    @Mock
    var context: Context? = null

    private var recyclerViewAdapter: RecyclerViewAdapter? = null

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun addItemsAndAddsItemToTileList() {
        recyclerViewAdapter = RecyclerViewAdapter(20)
        recyclerViewAdapter!!.addItems(20)
    }
}


