package LC25;

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class trash {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1)return head;
        ListNode node = head;
        // 检查是否剩余超过k个节点
        for(int j=1; j<k; j++){ 
            if(node.next!=null)node=node.next;
            else return head;
        }

        // first section
        ListNode tmp = null, nxt = head.next;
        node = head;
        for(int i=1; i<k; i++){ // 进行k-1次操作
            if(node.next!=null)tmp = node.next.next; // 存储下一个遍历对象
            nxt.next = node; // 新的链接
            node = nxt; nxt = tmp; // 下一个遍历对象
        }
        // 保存当前段段尾，预备与后段连接
        ListNode pre = head;
        head = node; // 新的表头

        while(true){
            ListNode subhead = nxt; // 该组的表头（反转前）
            node = subhead;
            for(int j=1; j<k; j++){ // 检查是否剩余超过k个节点
                if(node==null) return head;
                node = node.next;
            }
            node = subhead;
            nxt = node.next;
            for(int i=1; i<k; i++){ // 进行k-1次操作
                if(nxt != null){
                    tmp = nxt.next; // 存储下一个遍历对象
                    nxt.next = node; // 新的链接
                }
                else return head;
                node = nxt; nxt = tmp; // 下一个遍历对象
            }
            pre.next = node; // 前段段尾与当前段连接
            pre = subhead; // pre记录新的段尾（反转后）
        }
    }
}
