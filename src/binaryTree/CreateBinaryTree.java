package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateBinaryTree {
    //节点类
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        Integer val;
        TreeNode(Integer val){
            this.val = val;
        }
    }
    //主函数
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        //将字符串转化为字符数组
        String[] num = str.split(" ");

       TreeNode root = createBinaryTree(num);
       printBinaryTree(root);
    }
    //构造二叉树
    public static TreeNode createBinaryTree(String[] arr){
        ArrayList<TreeNode> list = new ArrayList<>();
        TreeNode root = null;
        for(int i=0;i<arr.length;i++){
            TreeNode node = null;
            if(!arr[i].equals("null")){
                node = new TreeNode(Integer.parseInt(arr[i]));
            }
            list.add(node);
            if(i == 0){
                root = node;
            }
        }
        for(int i=0;2*i+1<arr.length;i++){
            TreeNode node = list.get(i);
            if(i < list.size()){
                node.left = list.get(2*i+1);
                if(2*i+2 < arr.length){
                    node.right = list.get(2*i+2);
                }
            }
        }
        return root;
    }
    //先序打印二叉树
    public static void printBinaryTree(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val + " ");
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }
}
