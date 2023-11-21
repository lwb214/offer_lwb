package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CreateBinaryTree2 {
    //节点类
    static class TreeNode{
        String val;
        TreeNode left;
        TreeNode right;
        public TreeNode(String val){
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
    public static TreeNode createBinaryTree(String[] num){
        //创建一个和数组相同大小的集合
        List<TreeNode> list = num.length == 0 ? null : new ArrayList<>(num.length);
        TreeNode root = null;
        //讲数组元素转化为树节点，加入集合
        for (int i = 0; i < num.length; i++) {
            TreeNode node = null;
            if(num[i] != "null"){
                node = new TreeNode(num[i]);
            }
            list.add(node);
            if(i == 0){
                root = node;
            }
        }
        //将集合中的元素变换为二叉树
        for (int i = 0; 2*i+1<num.length ; i++) {
            TreeNode node = list.get(i);
            if (node != null) {
                //线性存储转换链式存储关键
                node.left = list.get(2 * i + 1);
                if (2 * i + 2 < num.length) {
                    node.right = list.get(2 * i + 2);
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
