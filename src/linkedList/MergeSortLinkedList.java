package linkedList;

import java.util.Scanner;

import linkedList.LinkedList.ListNode;
/*
    合并两个有序链表
*/
public class MergeSortLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String str1 = sc.nextLine();
        // String str2 = sc.nextLine();
        String str1 = "2 3 4";
        String str2 = "1 5 8 9 10";
        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        ListNode list1 = LinkedList.createLinkedNode(arr1);
        ListNode list2 = LinkedList.createLinkedNode(arr2);
        System.out.print("合并之前的链表为： ");
        System.out.println();
        LinkedList.printListNode(list1);
        LinkedList.printListNode(list2);
        ListNode merge = mergeTwoLinkedList(list1, list2);
        System.out.print("合并之后的链表为： ");
        System.out.println();
        LinkedList.printListNode(merge);
    }
    //合并
    public static ListNode mergeTwoLinkedList(ListNode list1,ListNode list2){
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                cur.next = list1;
                list1 = list1.next;
            }else{
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return dummy.next;
    }
}
