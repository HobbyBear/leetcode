package com.xch.leetcode.suanfa.p2;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        helper(head, l1, l2, 0);
        return head.next;
    }


    private void helper(ListNode preNode, ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null && carry == 0){
            return;
        }
        int res = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
        int unitNum = res;
        if (res >= 10) {
            carry = 1;
            unitNum = Integer.valueOf(String.valueOf(res).substring(1));
        }else {
            carry = 0;
        }
        ListNode node = new ListNode(unitNum);
        if (preNode != null) {
            preNode.next = node;
        }
        helper(node, (l1 == null ? null : l1.next), (l2 == null ? null : l2.next), carry);
    }
}