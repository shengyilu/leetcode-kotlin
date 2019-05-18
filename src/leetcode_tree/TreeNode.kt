package leetcode_tree

class TreeNode(var value: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun preorder(root: TreeNode?) {
        if (root == null) {
            return
        }
        System.out.println(root.value)
        preorder(root.left)
        preorder(root.right)
    }
}