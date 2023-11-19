package binaryTree;

import java.util.*;

/***
 * 将一个一维数组转化为二叉树(层序)
 */
class CreateBinaryTree{
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
        //接受输出
        String str = sc.nextLine();
        //空格分割为数组
        String[] arr  = str.split(" ");
        //构造二叉树
        TreeNode root = createBinaryTree(arr);
        //先序遍历并打印
        ergodicBinaryTree(root);
    }
    //构建二叉树【核心】
    public static TreeNode createBinaryTree(String[] array){
        LinkedList<TreeNode> queue = new LinkedList<>();
        //创建根节点传入数组第一个元素
        TreeNode root = new TreeNode(array[0]);
        //根节点入队
        queue.offer(root);
        //指针
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.pop();
            if (index < array.length){
                //创建左节点，默认为null
                TreeNode left = null;
                //如果数组中的值，不为空，就将它更新为左节点的新值
                if (array[index] != null) {
                    left = new TreeNode(array[index]);
                }
                //新的左节点入队
                queue.offer(left);
                //将左节点放入树中
                if(node != null){
                    node.left = left;
                }
                //索引后移，遍历数组下一个元素
                index++;
                //右节点与左节点步骤一致
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