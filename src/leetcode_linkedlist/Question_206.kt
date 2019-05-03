package leetcode_linkedlist

import Leetcode.Leetcode_824

/*
   206. Reverse Linked List
   Reverse a singly linked list.

   Example:

   Input: 1->2->3->4->5->NULL
   Output: 5->4->3->2->1->NULL
*/

class Question_206 {

    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var newHead = head
        var root: ListNode? = null
        while (newHead != null) {
            var temp = newHead.next
            newHead.next = root
            root = newHead
            if (temp != null) {
                newHead = temp
            } else {
                break
            }
        }

        return newHead
    }

    var temp:ListNode? = null
    var root:ListNode? = null

    fun reverseList2(head: ListNode?): ListNode? {
        if (temp == null) {
            temp = head
        }

        if (head?.next == null) {
            root = head
            return head
        }
        var newHead = reverseList2(head.next)
        newHead?.next = head
        if (head == temp) {
            head.next = null
            return root
        }
        return head
    }

}

fun main(args: Array<String>) {
    var list = Question_206.ListNode(1)
    list.next = Question_206.ListNode(2)
    list.next?.next = Question_206.ListNode(3)
    list.next?.next?.next = Question_206.ListNode(4)
    list.next?.next?.next?.next = Question_206.ListNode(5)

    var question = Question_206()
    var reversedNode = question.reverseList2(list)
    while(reversedNode != null) {
        System.out.print(reversedNode.value)
        reversedNode = reversedNode.next
    }


}