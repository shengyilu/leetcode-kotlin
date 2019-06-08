package leetcode_tree

class Leetcode_654 {

    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        return construct(nums, 0, nums.size - 1)
    }

    fun construct(nums: IntArray, left: Int, right: Int): TreeNode? {
        if (left > right) {
            return null
        }
        var max = Int.MIN_VALUE
        var maxIndex = 0
        for ((index, value) in nums.withIndex()) {
            if (index >= left && index <= right) {
                if (max < value) {
                    max = value
                    maxIndex = index
                }
            }
        }

        var root: TreeNode? = TreeNode(max)
        root?.right = construct(nums, maxIndex + 1, right)
        root?.left = construct(nums, left, maxIndex - 1)

        return root
    }

}

fun main(args: Array<String>) {
    val input = intArrayOf(3, 2, 1, 6, 0, 5)

    val s = Leetcode_654()
    val root = s.constructMaximumBinaryTree(input)
    root?.preorder(root)


}