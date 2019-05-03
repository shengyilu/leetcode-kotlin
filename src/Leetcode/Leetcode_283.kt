package Leetcode

import java.util.*

class Leetcode_283 {

    fun moveZeroes(nums: IntArray): Unit {
        var leftMost = 0
        var nonZeroIndex = 0
        var zeroNum = 0

        while (leftMost < nums.size) {
            if (nums[leftMost] == 0) {
                zeroNum++
            } else {
                nums[nonZeroIndex++] = nums[leftMost]
            }
            leftMost++
        }

        var rightMost = nums.size - 1
        while(rightMost >= nums.size - zeroNum) {
            nums[rightMost--] = 0
        }


    }
}

fun main(args: Array<String>) {
    val s = Leetcode_283()
    var nums: IntArray  = intArrayOf(0,1,0,3,12)
    s.moveZeroes(nums)
    println(Arrays.toString(nums))
}