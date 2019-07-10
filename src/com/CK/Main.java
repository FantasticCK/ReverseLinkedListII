package com.CK;

public class Main {

    public static void main(String[] args) {
        int m = 1, n = 4;
        ListNode l1 = new ListNode(1);
        ListNode l1_1 = new ListNode(2);
        ListNode l1_2 = new ListNode(3);
        ListNode l1_3 = new ListNode(4);
        ListNode l1_4 = new ListNode(5);
        l1_3.next = l1_4;
        l1_2.next = l1_3;
        l1_1.next = l1_2;
        l1.next = l1_1;

        Solution solution = new Solution();
        ListNode.printListNode(solution.reverseBetween(l1, 1, 5));
    }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) return null;
        if (m == n) return head;
        ListNode dummyHead = new ListNode(0), dummayTail = new ListNode(0);
        dummyHead.next = head;
        ListNode mPtr = dummyHead, nPtr = dummyHead, currPtr = dummyHead;
        int i = 0;
        while (currPtr != null) {
            if (i == m - 1) mPtr = currPtr;
            if (i == n) nPtr = currPtr;
            currPtr = currPtr.next;
            i++;
        }
        ListNode res = reverseBetweenBeginAndEnd(mPtr, nPtr.next);
        return dummyHead.next;
    }

    private ListNode reverseBetweenBeginAndEnd(ListNode begin, ListNode end) {
        ListNode curr = begin.next;
        ListNode next, first;
        ListNode prev = begin;
        first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        first.next = curr;
        return first;
    }
}