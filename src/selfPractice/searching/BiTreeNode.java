package selfPractice.searching;

public class BiTreeNode {
    public int data;
    public BiTreeNode left;
    public BiTreeNode right;
    public BiTreeNode(int content){
        this.data = content;
        this.left = null;
        this.right = null;
    }
    public BiTreeNode(){
        this.left = null;
        this.right = null;
    }
    public void setLeft(BiTreeNode l){
        this.left = l;
    }
    public void setRight(BiTreeNode r){
        this.right = r;
    }
    public void addNode(int n){
        if(n <= this.data){
            if(this.left == null){
                this.left = new BiTreeNode(n);
            }
            else {
                this.left.addNode(n);
            }
        }
        else{
            if(this.right == null){
                this.right = new BiTreeNode(n);
            }
            else{
                this.right.addNode(n);
            }
        }
    }
}
