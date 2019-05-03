package leetcode_tree

/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
 */

class Leetcode_105 {

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        if (preorder.size == 0) {
            return null
        }
        if (preorder.size == 1) {
            return TreeNode(preorder[0])
        }
        var root = TreeNode(preorder[0])

        var leftLen = 0
        for (value in inorder) {
            if (root.value == value) {
                break
            }
            leftLen++
        }
        var rightLen = inorder.size - leftLen - 1

        if (leftLen > 0) {
            var leftPreorder = preorder.copyOfRange(1, 1 + leftLen)
            if (leftPreorder.size == 1) {
                root.left = TreeNode(leftPreorder[0])
            } else {
                var leftInorder = inorder.copyOfRange(0, leftLen)
                root.left = buildTree(leftPreorder, leftInorder)
            }
        } else {
            root.left = null
        }

        if (rightLen > 0) {
            var rightPreorder = preorder.copyOfRange(1 + leftLen, preorder.size)
            if (rightPreorder.size == 1) {
                root.right = TreeNode(rightPreorder[0])
            } else {
                var rightInorder = inorder.copyOfRange(1 + leftLen, preorder.size)
                root.right = buildTree(rightPreorder, rightInorder)
            }
        } else {
            root.right = null
        }

        return root
    }

    fun preorder(root: TreeNode?) {
        if (root == null) {
            return
        }
        print(root.value)
        print(",")
        preorder(root.left)
        preorder(root.right)
    }

}



fun main(args: Array<String>) {
    val preorder = intArrayOf(1, 2, 3, 4, 5)
    val inorder = intArrayOf(1,2, 3, 4, 5)

    val s = Leetcode_105()
    val root = s.buildTree(preorder, inorder)
    s.preorder(root)
}