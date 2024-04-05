package linkedList;

import java.util.*;

import linkedList.LinkedList.ListNode;

public class ReverseLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //接受键盘输入
        String str = sc.nextLine();
        //以空格分割为数组
        String[] arr = str.split(" ");
        //构造链表
        ListNode head = LinkedList.createLinkedNode(arr);
        //打印反转之前的链表
        LinkedList.printListNode(head);
        //反转链表
        ListNode  after = reverse(head);
        //打印反转之后的链表
        LinkedList.printListNode(after);
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