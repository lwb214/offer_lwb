package otherPractice;

import java.util.*;
public class ReverseLinkedList {
    class LinkNode{
        int  val;
        LinkNode  next;
        public LinkNode(){}
        public LinkNode(int val) {
            this.val = val;
        }
    }
    public LinkNode reverseLinkedList(LinkNode head){
        Stack<LinkNode> stack = new Stack<>();
        while (head !=null){
            stack.push(head.next);
            head = head.next;
        }
        if (stack.isEmpty()){
            return null;
        }
        LinkNode node = stack.pop();
        LinkNode dummy = node;
        while (!stack.isEmpty()){
            node.next = stack.pop();
            node = node.next;
        }

        node.next = null;

        return dummy;
    }
}
