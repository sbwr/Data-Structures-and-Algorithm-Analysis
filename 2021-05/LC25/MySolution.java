package LC25;
// unsolved
public class MySolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 设置哨兵
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = head, crt = head, start = head;
        for(int i = 1; i < k; i ++){ // 确保还有k个值，end从head向后推移k-1个节点
            if(end == null) return head;
            end = end.next;
        }
        pre = null;
        for(int i = 1; i < k; i ++) { // 从pre,start开始更新节点间链接
            ListNode next = crt.next;
            crt.next = pre;
            pre = crt; crt = next;
        }
        // 反转后的头和尾
        end = start;
        start = pre;
        // end.next = crt;
        head = start; // 新的头节点为第一段的头
        pre = end;    // 记录这一段的尾，以便连接下一段的头

        for(int j = 0;; j++){
            end = crt;
            pre.next = crt; // 上一段的尾接新一段（反转前的）头
            for(int i = 1; i < k; i ++){ // 确保还有k个值，end从head向后推移k-1个节点
                if(end == null) return head;
                end = end.next;
            }
            pre.next = end; // 上一段的尾接新一段（反转后的）头
            start = crt;
            pre = dummy;
            for(int i = 1; i < k; i ++) { // 从pre,start开始更新节点间链接
                ListNode next = crt.next;
                crt.next = pre;
                pre = crt; crt = next;  // 后推一位
            }
            // 反转后的头和尾
            end = start;
            // start = pre;
            pre = end;    // 记录这一段的尾，以便连接下一段的头
        }
        // return head;
    }
}
