package selfPractice.searching;

import java.util.Stack;

public class BiTreeLF {
    public void LF_Visit(BinaryTree tree){
        Stack<BiTreeNode> stack = new Stack<>();
        BiTreeNode currentNode = tree.root;
        while(currentNode != null || !stack.empty()){
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else{
                currentNode = stack.pop();
                System.out.println(currentNode.data + ", ");
                currentNode = currentNode.right;
            }
        }
    }

    //test
    static public void main(String arg[]){
        int[] data = {1,2,3,4,5,6,7,8,9,10};
        BinaryTree tree = new BinaryTree(data);

        Stack<BiTreeNode> stack = new Stack<>();
        BiTreeNode currentNode = tree.root;
        while(currentNode != null || !stack.empty()){
            if(currentNode != null){
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            else{
                currentNode = stack.pop();
                System.out.println(currentNode.data + ", ");
                currentNode = currentNode.right;
            }
        }
    }

}
