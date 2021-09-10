package Offer22;

class Solution { // 双指针法，O(n)
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode startNode = head, endNode = head; // 设置快慢指针，分别指向倒数k个节点的头、尾。
        for (int i = 1; i < k; i++) { // 快指针先走k-1步
            endNode = endNode.next;
        } while (endNode.next != null) { // 快慢指针同时向后增长，快指针到尾时慢指针指向末k节点的头。
            endNode = endNode.next;
            startNode = startNode.next;
        } return startNode;
    }
}
