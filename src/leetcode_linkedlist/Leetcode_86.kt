package leetcode_linkedlist

/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5

Unit Test: 2 3 1 1 5 3 9, x=5
Output: 2 3 1 1 3 5 9

 */

class Leetcode_86 {

    fun partition(head: ListNode?, x: Int): ListNode? {

        var leftCurrent: ListNode? = ListNode(0)
        var leftFakeHead = leftCurrent

        var rightCurrent: ListNode? = ListNode(0)
        var rightFakeHead = rightCurrent

        var current = head
        while (current != null) {
            if (current.value < x) {
                leftCurrent?.next = current
                leftCurrent = leftCurrent?.next

            } else {
                rightCurrent?.next = current
                rightCurrent = rightCurrent?.next
            }
            current = current.next
        }
        leftCurrent?.next = rightFakeHead?.next
        rightCurrent?.next = null

        return leftFakeHead?.next
    }

    fun solve() {
        var input = intArrayOf(1, 4, 3, 2, 5, 2)
        var listCreator = ListCreator(input)
        var head = listCreator.head

        var ans = partition(head, 3)

        while(ans != null) {
            System.out.print(ans.value)
            ans = ans.next
        }

    }

}

fun main(args: Array<String>) {
    var s = Leetcode_86()
    s.solve()
}
