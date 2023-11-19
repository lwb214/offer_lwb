package linkedList;

import java.util.*;
public class ReverseLinkedList {
    //节点类
    class ListNode{
        public int val;
        public ListNode next;
        public ListNode(int val){
            this.val = val;
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.split(" ");

        ReverseLinkedList owner = new ReverseLinkedList();
        ListNode head = owner.cresteListNode(arr);
        owner.printListNode(head);
        ListNode  re = owner.reverse(head);
        owner.printListNode(re);
    }
    //构造链表
    public  ListNode cresteListNode(String[] arr){
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
    public void printListNode(ListNode head){
        while (head !=null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.print("null");
        System.out.println();
    }
    //反转链表
    public  ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;
        while (cur != null){
            //临时节点保存下一个节点的值
            ListNode temp = cur.next;
            cur.next = pre;
            //pre和cur都向后移动
            pre = cur;
            cur = temp;
        }
        return pre;
    }
}