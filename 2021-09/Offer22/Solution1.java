package Offer22;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution1 { // 遍历两轮，O(2n)
    public ListNode getKthFromEnd(ListNode head, int k) {
        // 统计链表总长l，找到倒数k个从正数pos位置开始。
        ListNode node = head;
        int len = 1, pos;
        while (node.next != null) {
            len++;
            node = node.next;
        } pos = len - k;
        node = head;
        // 找到第pos个数(Node[pos-1])，返回
        for (int i = 0; i < pos; i++) {
            node = node.next;
        } return node;
    }
}
