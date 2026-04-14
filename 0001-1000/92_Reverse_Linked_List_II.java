/*
 * 92. Reverse Linked List II
 */

/*
 * Definition for singly-linked list.
 */

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null || left == right) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode curr = head;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            curr = curr.next;
        }

        ListNode sublistHead = curr;

        ListNode prevNode = null;
        for (int i = 0; i < right - left + 1; i++) {
            ListNode nextNode = curr.next;
            curr.next = prevNode;
            prevNode = curr;
            curr = nextNode;
        }
        pre.next = prevNode;
        sublistHead.next = curr;

        return dummy.next;
    }
}