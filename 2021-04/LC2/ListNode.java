package LC2;


// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int cf = 0; // 进位记录Carry Flag
        int sum_tmp; // store one-digit adding
        ListNode head = new ListNode(-1);
        ListNode pre = head;
        while(l1 != null || l2 != null || cf == 1){
            // calculate the real sum of 2  
            if(l1 == null && l2 == null){sum_tmp = cf;}
            else if(l1 == null){sum_tmp = l2.val + cf;}
            else if(l2 == null){sum_tmp = l1.val + cf;}
            else{
                sum_tmp = l1.val + l2.val + cf;
            }

            // do carry bit if needed
            // try not to use extra memory for sum
            ListNode sum;
            if(l1 != null) {sum = l1;}
            else if(l2 != null) {sum = l2;}
            else {sum = new ListNode();}

            if(sum_tmp <= 9){
                cf = 0;
            }
            else{
                sum_tmp -= 10;
                cf = 1;
            }
            sum.val = sum_tmp;
            // if this is the first one-digit adding
            if(head.val == -1){
                head = sum;
                pre = head;
            }
            else{
                pre.next = sum;
                pre = sum;
            }
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
    pre.next = null;
    return head;
    }

    public static void main(String arg[]){
        ListNode n1 = new ListNode(9, null);
        ListNode n2 = new ListNode(9, n1);
        ListNode n3 = new ListNode(9, n2);
        ListNode n4 = new ListNode(9, n3);
        ListNode n5 = new ListNode(9, n4);
        ListNode n6 = new ListNode(9, n5);
        ListNode n7 = new ListNode(9, n6);
        ListNode l1 = n7;
        ListNode m1 = new ListNode(9, null);
        ListNode m2 = new ListNode(9, m1);
        ListNode m3 = new ListNode(9, m2);
        ListNode l2 = m3;
        Solution s = new Solution();
        ListNode l3 = s.addTwoNumbers(l1, l2);
        while(l3.next != null){
            System.out.println(l3.val);
            l3 = l3.next;
        }
    }
}
