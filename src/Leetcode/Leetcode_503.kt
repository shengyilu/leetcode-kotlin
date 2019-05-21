/*
Given a circular array (the next element of the last element is the first element of the array),
print the Next Greater Number for every element.
The Next Greater Number of a number x is the first greater number to its traversing-order next in the array,
which means you could search circularly to find its next greater number. If it doesn't exist, output -1 for this number.

Example 1:
Input: [1,2,1]
Output: [2,-1,2]
Explanation: The first 1's next greater number is 2;
The number 2 can't find next greater number;
The second 1's next greater number needs to search circularly, which is also 2.
* */

package Leetcode
import java.util.Stack

class Leetcode_503 {

    fun nextGreaterElements(nums: IntArray): IntArray {

        val nextGreaterIndexHashMap: HashMap<Int, Int> = HashMap()

        var sortedArray = nums.sortedArray()

        val nextGreaterHashMap: HashMap<Int, Int> = HashMap()


        for ((i, value) in sortedArray.withIndex()) {
            var nextGreater = -1
            if (i < sortedArray.size - 1) {
                nextGreater = sortedArray.get(i+1)
            }
            nextGreaterHashMap.put(value, nextGreater)
        }

        var result = IntArray(sortedArray.size)
        for ((i, value) in nums.withIndex()) {
            var nextGreater: Int? = nextGreaterHashMap.get(value)
            result[i] = nextGreater!!
        }

        for (value in result) {
            System.out.println(value)
        }

        return result

    }
}


fun main(args: Array<String>) {
    val nums: IntArray = IntArray(3)
    nums[0] = 1
    nums[1] = 2
    nums[2] = 1

    val s = Leetcode_503()
    s.nextGreaterElements(nums)

}