package binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class LevelTraversal {
    //层序遍历二叉树

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
        String str = "2 3 4 8 9 8 9 6 4 2 null null 8 5 null 1 2 3 4 null null";
        String[] arr = str.split(" ");

       TreeNode root = createTree(arr);
        printTree(root);
        System.out.println();
        List<List<Integer>> lists = levelTraversal(root);
        System.out.println(lists);
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
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
    //层序遍历二叉树--迭代法【利用队列】
    public static List<List<Integer>> levelTraversal(TreeNode root){
        //二维数组
        List<List<Integer>> lists = new ArrayList<>();
        if(root == null) return lists;
        //借助队列
        Queue<TreeNode> queue = new LinkedBlockingDeque<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            //一维数组
            List<Integer> list = new ArrayList<>();
            //记录队列的长度【很重要】
            int size = queue.size();
            while (size > 0){
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null)
                    queue.offer(node.left);
                if (node.right != null)
                    queue.offer(node.right);
                size--;
            }
            lists.add(list);
        }
        return lists;
    }
}

