package binaryTree;

import java.util.Scanner;
/*
    反转二叉树
 */
public class TraversalBinaryTree {
    class TreeNode{
        Integer val;
        TreeNode left;
        TreeNode right;
        public TreeNode(Integer val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] arr = str.replace("[","").replace("]","").split(",");

    }
}