package binaryTree;

import java.util.ArrayList;

//判断二叉树是否对称
public class SymmetricBinaryTree {
    //节点类
    static class TreeNode{
        private TreeNode left;
        private TreeNode right;
        private Integer val;
        TreeNode(Integer val){
            this.val = val;
        }
    }
    //主函数
    public static void main(String[] args){
        // Scanner sc = new Scanner(System.in);
        // String str = sc.next();
        String str = "1 2 2 3 3 null null";
        String[] arr = str.split(" ");
        TreeNode root = createBinaryTree(arr);
        printBinaryTree(root);
        System.out.println();
        boolean result = isCommonAncestor(root);
        System.out.println("二叉树是否对称：" + result);

    }
    //判断二叉树是否对称
    public static boolean isCommonAncestor(TreeNode root){
        if(root == null){
            return false;
        }
        return check(root.left,root.right);
    }
    private static boolean check(TreeNode L, TreeNode R) {
        if(L == null && R == null) return true;
        if(L == null || R == null || L.val != R.val) return false;
        //递归左子树和右子树
        return check(L.left, L.right) && check(R.left, R.right);
    }
    /*构建二叉树
    构建二叉树分为两步：
    1.先把数组元素都转换为树节点，存在一个集合里
    2.将集合的树节点取出，2i+1为左节点，2i+2为右节点
    */
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
    //遍历二叉树(打印)
    public static void printBinaryTree(TreeNode root){
        if(root == null){
            return;
        }
        System.out.print(root.val+" ");
        printBinaryTree(root.left);
        printBinaryTree(root.right);
    }
}
