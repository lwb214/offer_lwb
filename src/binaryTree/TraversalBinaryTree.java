package binaryTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
    反转二叉树
 */
public class TraversalBinaryTree {
   static class TreeNode{
        Integer val;
        TreeNode left;
        TreeNode right;
        public TreeNode(Integer val){
            this.val = val;
        }
    }

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
        String str = "2 3 4 5 6 7 8 4 2 1 3 2 3 4 9 8 null 6 7";
        String[] arr = str.split(" ");

        System.out.println("输入的二叉树为:");
        TreeNode root = createBinaryTree(arr);
        printBinaryTree(root);

        TreeNode reverse = reverseTree(root);
        System.out.println();
        System.out.println("反转后的二叉树为:");
        printBinaryTree(reverse);

        TreeNode reverse2 = reverseTree2(root);
        System.out.println();
        System.out.println("反转后的二叉树2为:");
        printBinaryTree(reverse2);
    }
    //构建二叉树
    public static TreeNode createBinaryTree(String[] arr){
        List<TreeNode> list = new ArrayList<>();
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            TreeNode node = null;
            if(!arr[i].equals("null")){
                node = new TreeNode(Integer.parseInt(arr[i]));
            }
            list.add(node);
            if (i == 0){
                root = node;
            }
        }
        for (int i = 0; 2*i + 1< arr.length; i++) {
            TreeNode node = list.get(i);
            if(i < list.size()){
                node.left = list.get(2*i+1);
                if(2*i + 2 < arr.length){
                    node.right = list.get(2*i+2);
                }
            }
        }
        return root;
    }
    //先序打印二叉树
    public static void printBinaryTree(TreeNode root){
       if(root == null){
           return;
       }
       System.out.print(root.val+" ");
       printBinaryTree(root.left);
       printBinaryTree(root.right);
    }
    //反转二叉树【递归】
    public static TreeNode reverseTree(TreeNode root){
       if(root == null){
           return null;
       }
       reverseTree(root.left);
       reverseTree(root.right);
       swapTreeNode(root);
       return root;
    }
    //反转二叉树【非递归】
    public static TreeNode reverseTree2(TreeNode root){
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offer(root);
        while (!deque.isEmpty()){
            int size = deque.size();
            while (size-- > 0){
                TreeNode node = deque.poll();
                swapTreeNode(node);
                if(node.left != null) deque.offer(node.left);
                if (node.right != null) deque.offer(node.right);
            }
        }
        return root;
    }
    public static void swapTreeNode(TreeNode node){
       TreeNode temp = node.left;
       node.left = node.right;
       node.right = temp;
    }
}