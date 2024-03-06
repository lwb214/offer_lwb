package linkedList;

import java.util.*;
public class ReverseLinkedList {
    //节点类
    static class ListNode{
        public Integer val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //接受键盘输入
        String str = sc.nextLine();
        //以空格分割为数组
        String[] arr = str.split(" ");
        //构造链表
        ListNode head = createLinkedNode(arr);
        //打印反转之前的链表
        printListNode(head);
        //反转链表
        ListNode  after = reverse(head);
        //打印反转之后的链表
        printListNode(after);
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
    //反转链表
    private static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            //临时节点保存下一个节点的值
            ListNode temp = cur.next;
            cur.next = pre;
            //pre和cur都向后移动
            //必须先移pre再移cur【若cur先移的话，pre和cur都会移动到temp的位置】
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}