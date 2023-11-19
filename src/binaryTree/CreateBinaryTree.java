package binaryTree;

import java.util.*;
class CreateBinaryTree{
    //节点类
    static class TreeNode{
        Integer val;
        TreeNode left;
        TreeNode right;
        public TreeNode(Integer val){
            this.val = val;
        }
    }
    //主函数
    public static void main(String[] args) {
        Integer[] array = {6, 40, 5, null, 21, 11, 12, null, null, 10, null, null, 10, 16, null};
        //构造二叉树
        TreeNode root = createBinaryTree(array);
        //先序遍历并打印
        ergodicBinaryTree(root);
    }
    //构建二叉树
    public static TreeNode createBinaryTree(Integer[] array){
        LinkedList<TreeNode> queue = new LinkedList<>();
        //创建根节点传入数组第一个元素
        TreeNode root = new TreeNode(array[0]);
        //根节点入队
        queue.offer(root);
        //指针
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (index < array.length) {
                TreeNode left = null;
                if (array[index] != null) {
                    left = new TreeNode(array[index]);
                }
                queue.offer(left);
                if(node != null){
                    node.left = left;
                }
                index++;
            }

            if (index < array.length) {
                TreeNode right = null;
                if (array[index] != null) {
                    right = new TreeNode(array[index]);
                }
                queue.offer(right);
                if(node != null){
                    node.right = right;
                }
                index++;
            }
        }
        return root;
    }
    //遍历二叉树(先序)
    public static void ergodicBinaryTree(TreeNode root){
        if (root == null){
            return;
        }
        System.out.print(root.val+" ");
        ergodicBinaryTree(root.left);
        ergodicBinaryTree(root.right);
    }
}