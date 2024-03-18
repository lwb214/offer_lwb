package linkedList;

import java.util.Scanner;
/*
    合并两个有序链表
*/
public class MergeSortLinkedList {
    static class LinkedListNode{
        private LinkedListNode next;
        private Integer val;
        LinkedListNode(Integer val){
            this.val = val;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String str1 = sc.nextLine();
        // String str2 = sc.nextLine();
        String str1 = "2 3 4";
        String str2 = "1 5 8 9 10";
        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        LinkedListNode list1 = creatLinkedListNode(arr1);
        LinkedListNode list2 = creatLinkedListNode(arr2);
        System.out.print("合并之前的链表为： ");
        System.out.println();
        printLinkedList(list1);
        printLinkedList(list2);
        LinkedListNode merge = mergeTwoLinkedList(list1, list2);
        System.out.print("合并之后的链表为： ");
        printLinkedList(merge);
    }
    public static LinkedListNode creatLinkedListNode(String[] arr){
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode cur = dummy;
        for(int i=0;i<arr.length;i++){
            LinkedListNode node = new LinkedListNode(Integer.parseInt(arr[i]));
            cur.next = node;
            cur = cur.next;
            if(i == arr.length-1){
                cur.next = null;
            }
        }
        return dummy.next;
    }
    //合并
    public static LinkedListNode mergeTwoLinkedList(LinkedListNode list1,LinkedListNode list2){
        LinkedListNode dummy = new LinkedListNode(-1);
        LinkedListNode cur = dummy;
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
    public static void printLinkedList(LinkedListNode list){
        while(list != null){
            System.out.print(list.val + "->");
            list = list.next;
        }
        System.out.print("null");
        System.out.println();
    }
}
