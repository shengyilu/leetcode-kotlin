package Leetcode

/*
Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.

For example,

Given the tree:
        4
       / \
      2   7
     / \
    1   3

And the value to search: 2
You should return this subtree:

      2
     / \
    1   3
In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.

Note that an empty tree is represented by NULL, therefore you would see the expected output (serialized tree format) as [], not null.
 */

class Leetcode_700 {

    class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    var root: TreeNode? = null

    fun buildTree(): TreeNode? {
        root = TreeNode(4)
        root?.left = TreeNode(2)
        root?.left?.left = TreeNode(1)
        root?.left?.right = TreeNode(3)

        root?.right = TreeNode(7)
        return root
    }


    fun searchBST(root: TreeNode?, value: Int): TreeNode? {
        if (root == null) {
            return null
        }


        if (root.value < value) {
            return searchBST(root?.right, value)
        }

        if (root.value > value) {
            return searchBST(root?.left, value)
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
    val s = Leetcode_700()
    val root = s.buildTree()
    var searchTarget = s.searchBST(root, 7)
    s.preorder(searchTarget)
}