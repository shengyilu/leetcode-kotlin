package Leetcode_array

import java.util.*

/*
Given an array of integers A sorted in non-decreasing order,
return an array of the squares of each number, also in sorted non-decreasing order.

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/


class Leetcode_977 {

    fun sortedSquares(A: IntArray): IntArray {
        var output = IntArray(A.size)
        var rightMost = A.size - 1
        var leftMost = 0
        var startPos = rightMost

        while (startPos >= 0) {
            var leftValue = A[leftMost] * A[leftMost]
            var rightValue = A[rightMost] * A[rightMost]
            if (leftValue > rightValue) {
                output[startPos--] = leftValue
                leftMost++
            } else {
                output[startPos--] = rightValue
                rightMost--
            }

        }
        return output
    }

}

fun main(args: Array<String>) {
    val input = intArrayOf(-7, -3, 2, 3, 11)
    val leetcode = Leetcode_977()
    System.out.println(println(Arrays.toString(leetcode.sortedSquares(input))))


}