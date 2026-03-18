package BST;

public class Node {

    private int data;
    private Node left;
    private Node right;

    Node(int value){
        this.data= value;
        this.left=null;
        this.right=null;
    }

    public int getData(){
        return this.data;
    }

    public Node getLefNode(){
        return this.left;
    }

    public Node getRiNode(){
        return this.right;
    }

    public void setLefNode(Node left){
        this.left= left;
    }

    public void setRiNode(Node right){
        this.right= right;
    }

    public void setData(int data){
        this.data= data;
    }
}
