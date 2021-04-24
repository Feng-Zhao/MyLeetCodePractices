package jianzhioffer;

import java.util.Arrays;
import CommonDataStructure.TreeNode;

public class P07_ReBuildTree {
    // rebuild the tree from preorder and in order.
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0){
            return null;
        }

        int mid = search(inorder,preorder[0]);

        

        if(mid != -1){
            TreeNode root = new TreeNode(preorder[0]);
            int[] leftChild = Arrays.copyOfRange(inorder, 0, mid);
            
            int[] rightChild = mid + 1 < inorder.length ? Arrays.copyOfRange(inorder, mid + 1, inorder.length) : new int[0] ;

            int[] reservePreorder = Arrays.copyOfRange(preorder, 1 , preorder.length);
            root.left = buildTree(reservePreorder, leftChild);
            root.right = buildTree(reservePreorder, rightChild);
            return root;
        }
        else{
            int[] reservePreorder = Arrays.copyOfRange(preorder, 1 , preorder.length);
            return buildTree(reservePreorder, inorder);
        }
    }

    public int search(int[] data, int target) {
        if (data.length == 0) {
            return -1;
        }
        for (int i = 0; i < data.length; i++) {
            if(data[i] == target){
                return i;
            }
        }
        return -1;
    }

    public void printTreePre(TreeNode root){
        if(root == null){
            return;
        }
        else {
            System.out.print(root.val + ",");
            printTreePre(root.left);
            printTreePre(root.right);
        }
    }

    public void printTreeIn(TreeNode root){
        if(root == null){
            return;
        }
        else {
            printTreeIn(root.left);
            System.out.print(root.val + ",");
            printTreeIn(root.right);
        }
    }
    public static void main(String[] args) {
        P07_ReBuildTree myTree = new P07_ReBuildTree();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = myTree.buildTree(preorder, inorder);
        myTree.printTreePre(root);
        System.out.println();
        myTree.printTreeIn(root);
    }
}
