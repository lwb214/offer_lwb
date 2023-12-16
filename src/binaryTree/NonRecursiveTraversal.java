package binaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
public class NonRecursiveTraversal {
    //使用迭代法实现先序遍历二叉树【非递归】

    //节点类
    static class TreeNode {
        Integer val;
        TreeNode left;
        TreeNode right;
        public TreeNode(Integer val) {
            this.val = val;
        }
    }
    //主函数
    public static void main(String[] args) {
        String str = "2 3 4 5 6 7 8 4 2 1 3 2 3 4 9 8 null 6 7";
        String[] arr = str.split(" ");

        TreeNode root = createTree(arr);
        printTree(root);
        System.out.println();
        nonRecursivePre(root);
        nonRecursiveAfter(root);
    }

    //构建二叉树
    public static TreeNode createTree(String[] arr) {
        List<TreeNode> list = new ArrayList<>(arr.length);
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
           TreeNode node = null;
            if (!arr[i].equals("null")) {
                node = new TreeNode(Integer.parseInt(arr[i]));
            }
            list.add(node);
            if (i == 0) {
                root = node;
            }
        }
        try{
            for (int i = 0; 2 * i + 1 < arr.length; i++) {
                TreeNode node = list.get(i);
                if (i < arr.length) {
                    node.left = list.get(2 * i + 1);
                    if (2 * i + 2 < arr.length) {
                        node.right = list.get(2 * i + 2);
                    }
                }
            }
        }catch (Exception e){
            System.out.print("请您检查输入的二叉树是否正确");
            e.printStackTrace();
            return null;
        }
        return root;
    }
    //先序打印二叉树【递归】
    public static void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val +"  ");
        printTree(root.left);
        printTree(root.right);
    }
    //先序打印二叉树【非递归】
    public static void nonRecursivePre(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        System.out.println(list);
    }
    //后序打印二叉树【非递归】
    public static void nonRecursiveAfter(TreeNode root){
        ArrayList<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        Collections.reverse(list);
        System.out.println(list);
     }
}

