package BST;

public class main {
    public static void main(String[] args) {
        BinarySearchTree bst= new BinarySearchTree();

        Node root = bst.createBSTNode(36);
        int[] vars= {14,67,35,78,35,12,3};
        
        for(int var: vars){
            bst.addNodeToBST(root, var);
        }

        bst.printBST(root);
        System.out.println("Minimum element in BST: "+bst.findMaxInBST(root).getData());
        System.out.println("Minimum element in BST: "+bst.findMinInBST(root).getData());

        bst.deleteNodeToBST(root, 35);

        bst.printBST(root);
        System.out.println("Minimum element in BST: "+bst.findMaxInBST(root).getData());
        System.out.println("Minimum element in BST: "+bst.findMinInBST(root).getData());
    }
}
