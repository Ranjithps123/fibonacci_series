package com.android.fibonacci

import com.android.fibonacci.FibonacciCalculation
import org.junit.Test

import org.junit.Assert.*


class FibonacciUnitTest {
    @Test
    fun testGetFibonacciNumber() {
        val actual = FibonacciCalculation.getFibonacciNumber(4)
        // expected value is 3
        val expected = "3"
        assertEquals("Fibonacci value:: ", expected, actual)
    }

}
