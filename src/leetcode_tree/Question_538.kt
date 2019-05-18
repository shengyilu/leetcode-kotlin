
/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus sum of all keys greater than the original key in BST.

Example:

Input: The root of a Binary Search Tree like this:
              5
            /   \
           2     13

Output: The root of a Greater Tree like this:
             18
            /   \
          20     13
 */

package leetcode_tree

class Solution {
    var sum = 0

    fun convertBST(root: TreeNode?): TreeNode? {
        helper(root)
        return root
    }

    fun helper(root: TreeNode?) {
        if (root == null) {
            return
        }
        helper(root.right)
        sum += root.value
        root.value = sum
        helper(root.left)
    }


}


fun main(args: Array<String>) {
    var root = TreeNode(5)
    root.left = TreeNode(2)
    root.right = TreeNode(13)

    root.preorder(root)

    val solution = Solution()
    var rootNew = solution.convertBST(root)
    rootNew?.preorder(rootNew)

}
