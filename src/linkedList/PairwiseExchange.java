package linkedList;

import linkedList.LinkedList.ListNode;

/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换
*/
public class PairwiseExchange {
    public static void main(String[] args) {
        String str = "2 3 4 6 7 8 9";
        String[] arr = str.split(" ");
        ListNode head =LinkedList.createLinkedNode(arr);
        LinkedList.printListNode(head);
        ListNode change = exchange(head);
        LinkedList.printListNode(change);
    }
    public static ListNode exchange(ListNode head){
        //虚拟哨兵节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        //指针
        ListNode cur = dummy;
        ListNode temp;
        ListNode first;
        ListNode second;
        while(cur.next != null && cur.next.next != null){
            //保存当前节点后第三个节点
            temp = cur.next.next.next;
            //保存当前节点的下一个节点
            first = cur.next;
            //保存当前节点后第二个节点
            second = cur.next.next;
            //当前节点指向second
            cur.next = second;
            second.next = first;
            first.next = temp;
            //指针移动，递归下一次
            cur = first;
        }
        return dummy.next;
    }
}
