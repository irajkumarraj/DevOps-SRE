package BST;

import java.util.HashMap;
import java.util.Map;

public class BinarySearchTree {
    public Node createBSTNode(int data){
        Node root= new Node(data);
        return root;
    }

    public void addNodeToBST(Node root, int data){
        if(root==null){
            System.out.println("Node values is null exiting the program");
            return;
        }

        if(data>root.getData()){
            if(root.getRiNode()==null)
                root.setRiNode(new Node(data));
            else
                addNodeToBST(root.getRiNode(), data);
        }else{
            if(root.getLefNode()==null)
                root.setLefNode(new Node(data));
            else
                addNodeToBST(root.getLefNode(), data);
        }       
    }

    public Node findElement(Node root, int data)
    {   
            if(root==null){
                return null;
            }

            if(data==root.getData()){
                return root;
            }else if(data>root.getData()){
                return findElement(root.getRiNode(), data);
            }else{
                return findElement(root.getLefNode(), data);
            }
    }
    public Node findMinInBST(Node root){
        while(root.getLefNode()!=null){
            root=root.getLefNode();
        }
        return root;
    }
    public Node findMaxInBST(Node root){
        while(root.getRiNode()!=null){
            root=root.getRiNode();
        }
        return root;
    }
    public Node findParent(Node root,int data){
        if(root==null || root.getData()==data){
            return null; //no parent
        }
        //check if current root is parent
        if((root.getLefNode()!=null && root.getLefNode().getData()==data)
            || (root.getRiNode()!=null && root.getRiNode().getData()==data)){
                return root;
        }

        //check in right subtree
        if(data>root.getData()){
            return findParent(root.getRiNode(), data);
        }else{
            return findParent(root.getLefNode(), data);
        }
    }
    public Node deleteNodeToBST(Node root, int data){ 
        Node reqNode = findElement(root, data);
        Node parentReq = findParent(root, reqNode.getData());

        if(reqNode.getLefNode()==null && reqNode.getRiNode()==null){
            if(parentReq.getLefNode()== reqNode)
                parentReq.setLefNode(null);
            else
                parentReq.setRiNode(null);
            
            return parentReq;
        }else if(reqNode.getLefNode()!=null && reqNode.getRiNode()!=null){
            Node minNode = findMinInBST(reqNode.getRiNode());
            // Node parentMin = findParent(reqNode, minNode.getData());
            
            reqNode.setData(minNode.getData());
            // if(parentMin.getLefNode()== reqNode){
            //     // parentMin.setLefNode(null);
            deleteNodeToBST(minNode, minNode.getData());

            // }else
            //     parentMin.setRiNode(null);
            
            return minNode;
        }else{
            if(reqNode.getLefNode()!=null){
                reqNode.setData(reqNode.getLefNode().getData());
                reqNode.setLefNode(null);
            }else if(reqNode.getRiNode()!=null){
                reqNode.setData(reqNode.getRiNode().getData());
                reqNode.setRiNode(null);
            }
            return reqNode;
        }       
    }
    public void printBST(Node root){
        if(root==null) return;
        System.out.println(root.getData()+" (root)");

        if(root.getLefNode()==null && root.getRiNode()==null){
            return;
        }else{
            if(root.getLefNode()!=null){
                System.out.print(root.getLefNode().getData()+"(l) ");
            }

            if(root.getRiNode()!=null){
                System.out.print(root.getRiNode().getData()+"(r)");
            }
            System.out.println();
        }

        printBST(root.getLefNode());
        printBST(root.getRiNode());
    }
}
