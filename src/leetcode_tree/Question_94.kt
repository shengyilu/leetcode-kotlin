
/*
Given a binary tree, return the inorder traversal of its nodes' values.
Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
Follow up: Recursive solution is trivial, could you do it iteratively?
 */

package leetcode_tree


class Leetcode_94 {

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    class Stack{
        val elements: MutableList<Any> = mutableListOf()

        fun isEmpty() = elements.isEmpty()

        fun size() = elements.size

        fun push(item: Any) = elements.add(item)

        fun pop() : Any? {
            val item = elements.lastOrNull()
            if (!isEmpty()){
                elements.removeAt(elements.size -1)
            }
            return item
        }
        fun peek() : Any? = elements.lastOrNull()

        override fun toString(): String = elements.toString()
    }

    fun inorderTraversal(root: TreeNode?): List<Int> {
        var result = mutableListOf<Int>()
        var stack = Stack()

        var cur: TreeNode? = root
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur)
                cur = cur.left
            }
            cur = stack.pop() as TreeNode
            result.add(cur.value)
            cur = cur.right
        }
        return result
    }

}

fun main(args: Array<String>) {
    var root = Leetcode_94.TreeNode(1)
    root.right = Leetcode_94.TreeNode(2)
    root.right?.left = Leetcode_94.TreeNode(3)

    var question = Leetcode_94()
    var result = question.inorderTraversal(root)

    for (value in result) {
        System.out.print(value)
    }

}