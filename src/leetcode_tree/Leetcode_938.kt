package leetcode_tree

class Leetcode_938 {

    var sum = 0
    fun rangeSumBST(root: TreeNode?, L: Int, R: Int): Int {
        helper(root, L, R)
        System.out.println(sum)
        return sum
    }

    fun helper(root: TreeNode?, L: Int, R: Int) {
        if (root == null) {
            return
        }
        if (root.value >= L && root.value <= R) {
            sum += root.value
        }
        helper(root.left, L, R)
        helper(root.right, L, R)

    }

}


fun main(args: Array<String>) {
    val root = TreeNode(10)
    root.left = TreeNode(5)
    root.left?.left = TreeNode(3)
    root.left?.right = TreeNode(7)
    root.right = TreeNode(15)
    root.right?.left = null
    root.right?.right = TreeNode(18)

    val s = Leetcode_938()
    var sum = s.rangeSumBST(root, 7, 15)


}

