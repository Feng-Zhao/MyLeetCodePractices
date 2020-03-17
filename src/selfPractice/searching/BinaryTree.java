package selfPractice.searching;

public class BinaryTree {
    public BiTreeNode root;

    public BinaryTree(int data[]){
        for(int i : data){
            this.addValue(i);
        }
    }
    private void addValue(int n){
        if(this.root == null){
            this.root = new BiTreeNode(n);
        }
        else{
            this.root.addNode(n);
        }
    }
}
