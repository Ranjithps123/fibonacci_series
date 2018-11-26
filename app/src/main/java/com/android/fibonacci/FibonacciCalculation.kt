package com.android.fibonacci

object FibonacciCalculation {

     fun getFibonacciNumber(index: Int): String{

         //Approach:1

//             if (index <= 1)
//                 return index
//             return getFibonacciNumber(index-1) + getFibonacciNumber(index-2)


         //Approach:2 (efficient way)

         // using Binet’s Formula.
         //Fn=[ϕ^n−(1/ϕ^n)]/√5
         var phi = 1.6180339887498948
         return String.format("%.0f", (Math.pow(phi, index.toDouble())-(1/Math.pow(-phi,index.toDouble())))/Math.sqrt(5.0))
     }
}
