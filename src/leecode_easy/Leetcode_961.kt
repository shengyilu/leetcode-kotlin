package leecode_easy

/*
*
In a array A of size 2N, there are N+1 unique elements, and exactly one of these elements is repeated N times.
Return the element repeated N times.

Example 1:

Input: [1,2,3,3]
Output: 3
Example 2:

Input: [2,1,2,5,3,2]
Output: 2
Example 3:

Input: [5,1,5,2,5,3,5,4]
Output: 5
*
* */

class Leetcode_961 {
    fun repeatedNTimes(A: IntArray): Int {
        var target = A.size / 2
        val valueMap = HashMap<Int, Int>()
        var result = 0
        for (value in A) {
            if (valueMap.containsKey(value)) {
                return value
            } else {
                valueMap.put(value, 1)
            }
        }
        return result
    }

    fun repeatedNTimes2(A: IntArray): Int {
        var ASorted = A.sorted()
        var result = 0
        for ((index, value) in ASorted.withIndex()) {
            if (value.equals(ASorted[index + 1])) {
                result = value
                break
            }
        }
        return result
    }



}

fun main(args: Array<String>) {
    val input = intArrayOf(2, 1, 2, 5 , 3, 2)
    val s = Leetcode_961()
    var result = s.repeatedNTimes(input)
    System.out.println(result)
}