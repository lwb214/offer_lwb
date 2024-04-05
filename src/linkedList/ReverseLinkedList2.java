package linkedList;

import java.util.Scanner;

import linkedList.LinkedList.ListNode;
/*
     反转链表2 ----反转从m到n之间的链表(m<n)
     输入：LinkedList head,int m,int n
     输出：反转后的链表LinkedList ans
  */
public class ReverseLinkedList2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = 0;
        int n = 3;
//        int m = sc.nextInt();
//        int n = sc.nextInt();
        String str = sc.nextLine();
//            String str = "2 3 4 5 6 7 8 9";
        String[] strs = str.split(" ");
        ListNode head = LinkedList.createLinkedNode(strs);
        LinkedList.printListNode(head);
        ListNode ans = reverseBetween(head,m,n);
        LinkedList.printListNode(ans);
    }
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        //维护p，q指针【p为m-1,q为n】
        ListNode p = dummy;
        ListNode q = dummy;
        for(int i = 0;i < m - 1;i ++) p = p.next;
        for(int i = 0;i < n ;i ++) q = q.next;

        //保存p，q节点的下一节点（为了连接三段链表）
        ListNode a = p.next;
        ListNode b = q.next;
        //将mn之间的链表进行反转，利用了三个指针c,d,e
        for(ListNode c = p.next,d = c.next;d != b;) {
            ListNode e = d.next;
            d.next = c;
            c = d;
            d = e;
        }
        //最后将三段链表进行连接
        a.next = b;
        p.next = q;
        return dummy.next;
    }
}
