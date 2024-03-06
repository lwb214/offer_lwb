package linkedList;

import java.util.Scanner;

public class ReverseLinkedList2 {
    /*
        反转链表2 ----反转从m到n之间的链表(m<n)
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
            int m = sc.nextInt();
            int n = sc.nextInt();
            sc.nextLine();
            String str = sc.nextLine();
//            String str = "2 3 4 5 6 7 8 9";
            String[] strs = str.split(" ");
            LinkedNode head = createLinkedNode(strs);
            printLinkedNode(head);
            LinkedNode ans = reverseBetween(head,m,n);
            printLinkedNode(ans);
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
        public static LinkedNode reverseBetween(LinkedNode head, int m, int n) {
            LinkedNode dummy = new LinkedNode(0);
            dummy.next = head;
            //维护p，q指针【p为m-1,q为n】
            LinkedNode p = dummy;
            LinkedNode q = dummy;
            for(int i = 0;i < m - 1;i ++) p = p.next;
            for(int i = 0;i < n ;i ++) q = q.next;

            //保存p，q节点的下一节点（为了连接三段链表）
            LinkedNode a = p.next;
            LinkedNode b = q.next;
            //将mn之间的链表进行反转，利用了三个指针c,d,e
            for(LinkedNode c = p.next,d = c.next;d != b;) {
                LinkedNode e = d.next;
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
}
