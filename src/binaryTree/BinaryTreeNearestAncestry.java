package binaryTree;

import binaryTree.CreateBinaryTree.TreeNode;
import static binaryTree.CreateBinaryTree.createBinaryTree;
import static binaryTree.CreateBinaryTree.printBinaryTree;

/*
    给定一个二叉树，找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度问题大（一个节点也可以是它自己的祖先）
*/
public class BinaryTreeNearestAncestry {
    public static void main(String[] args) {
        String str = "3 5 1 6 2 8 9 10 7 4";
        String[] binaryTrees = str.split(" ");
        TreeNode root = createBinaryTree(binaryTrees);
        printBinaryTree(root);
        TreeNode p = new TreeNode(2);
        TreeNode q = new TreeNode(6);
        TreeNode result = findNearestCommonAncestry(root,p,q);
        System.out.println();
        System.out.println("节点p,q最近公共祖先为："+result);
    }
    public static TreeNode findNearestCommonAncestry(TreeNode root, TreeNode p, TreeNode q){
        if (root == null || root ==p || root ==q)
            return root;
        TreeNode left = findNearestCommonAncestry(root.left,p,q);
        TreeNode right = findNearestCommonAncestry(root.right,p,q);
        if(left != null && right != null)
            return root;
        if(left == null)
            return right;
        else
            return left;
    }

}
