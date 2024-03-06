package linkedList;

import java.util.Scanner;

public class ReverseLinkedList2 {
    /*
        反转链表2 ----反转从m到n之间的链表
        输入：LinkedList head,int m,int n
        输出：反转后的链表LinkedList ans
     */
    static class LinkedNode {
        //节点类
        private Integer val;
        private LinkedNode next;
        LinkedNode(Integer val) {
            this.val = val;
        }
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            String[] strs = str.split(" ");
            LinkedNode head = createLinkedNode(strs);
            printLinkedNode(head);
        }
        public  static LinkedNode createLinkedNode(String[] arr){
            //虚拟哨兵节点
            LinkedNode dummy = new LinkedNode(-1);
            //当前指针
            LinkedNode cur = dummy;
            for (int i=0;i< arr.length;i++){
                LinkedNode temp = new LinkedNode(Integer.parseInt(arr[i]));
                cur.next = temp;
                cur = cur.next;
                //数组结束，指向null
                if(i == arr.length-1){
                    cur.next = null;
                }
            }
            return dummy.next;
        }
        public static void printLinkedNode(LinkedNode head){
            while (head != null){
                System.out.print(head.val + "->");
                head = head.next;
            }
            System.out.print("null");
            System.out.println();
        }
        public LinkedNode reverseBetween(LinkedNode head, int m, int n) {
            LinkedNode dummy = new LinkedNode(0);
            dummy.next = head;
            LinkedNode p = dummy;
            LinkedNode q = dummy;
            for(int i = 0;i < m - 1;i ++) p = p.next;
            for(int i = 0;i < n ;i ++) q = q.next;

            LinkedNode a = p.next;
            LinkedNode b = q.next;
            for(LinkedNode c = p.next,d = c.next;d != b;) {
                LinkedNode e = d.next;
                d.next = c;
                c = d;
                d = e;
            }

            a.next = b;
            p.next = q;
            return dummy.next;
        }
    }
}
