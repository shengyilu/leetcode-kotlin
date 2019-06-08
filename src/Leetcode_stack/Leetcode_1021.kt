package Leetcode_stack

import java.util.*

class Leetcode_1021 {

    fun removeOuterParentheses(S: String): String {
        var result = StringBuilder()
        var parentheseStack = Stack<Char>()
        var charArray = S.toCharArray()

        var startPos = 0
        for ((i,c) in charArray.withIndex()) {
            if (c.equals('(')) {
                parentheseStack.push(c)
            } else if (c.equals(')')) {
                parentheseStack.pop()
                if (parentheseStack.empty()) {
                    val slice = charArray.sliceArray(startPos+1..i-1)
                    result.append(slice)
                    startPos = i + 1
                }
            }
        }

        return result.toString()
    }

}

fun main(args: Array<String>) {
    val input = "((abc)(def))((ggg))"
    val s = Leetcode_1021()
    System.out.println(s.removeOuterParentheses(input))

}
