package leetcode_linkedlist

class ListNode(var value: Int) {
    var next: ListNode? = null

    fun createList(values: IntArray) : ListNode? {
        var head: ListNode? = null
        for (value in values) {
            if (head == null) {
                head = ListNode(value)
                head = head.next
            }
        }
        return head
    }
}

class ListCreator(values: IntArray) {

    var head: ListNode? = null

    init {
        var newHead: ListNode? = null
        for (value in values) {
            if (head == null) {
                head = ListNode(value)
                newHead = head
            } else {
                newHead?.next = ListNode(value)
                newHead = newHead?.next
            }
        }
    }

}
