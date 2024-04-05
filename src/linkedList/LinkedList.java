package linkedList;

public class LinkedList {
    //节点类
    static class ListNode{
        public Integer val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }

    }
    //构造链表
    public  static ListNode createLinkedNode(String[] arr){
        //虚拟哨兵节点
        ListNode dummy = new ListNode(-1);
        //当前指针
        ListNode cur = dummy;
        for (int i=0;i< arr.length;i++){
            ListNode temp = new ListNode(Integer.parseInt(arr[i]));
            cur.next = temp;
            cur = cur.next;
            //数组结束，指向null
            if(i == arr.length-1){
                cur.next = null;
            }
        }
        return dummy.next;
    }
    //输出链表
    public static void printListNode(ListNode head){
        while (head !=null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
}

