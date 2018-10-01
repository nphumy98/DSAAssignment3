/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTreeMap;

/**
 *
 * @author jimmynguyen
 */
public class BST<E> extends AbstractBST<E> implements BSTInterface<E> {

    private NodeTree root;
    
    //constructor
    public BST()
    {
        this.setSize(0);//set the size tree is 0
        this.root=null; //set root is null;
    }
    
    public BST(NodeTree root)
    {
        new BST();
        if (root!=null)// if root !=null
        {
            this.root=root; //set the root tree to new root
            this.setSize(1); //set the size Tree is 1
        }
    }
    
    @Override
    public void add(E value) {
        //find the appropriate position
        NodeTree newNode= new NodeTree(value);
        if (this.root==null) // if the tree is empty
        {
            this.root=newNode;
        }
        else
        {
            NodeTree locatePosition= locate(this.root, value); //find location. this locatePosition cant be null because of function locate
            if (locatePosition.compareTo(newNode)<0) //if value is more than
            {
                locatePosition.setRightNode(newNode); //set new node as the right Node of locate position

            }
            else if(locatePosition.compareTo(newNode)>0) //if value is less than
            {
                locatePosition.setLeftNode(newNode);
            }
            else // if locatePosition.compareTo(new NodeTree(value))==0 -> dublicate data
            {
                predecessor(locatePosition).setRightNode(newNode); //take the dublicate data the right node of the predecessor of the locatePostion node
            }
        }
        this.setSize(this.getSize()+1);
        
    }

    @Override
    public boolean contains(E value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(E data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int treeHeight() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inOrderTraverse(NodeTree root) {
        if (root==null)
        {
            return;
        }
        else
        {
            inOrderTraverse(root.getLeftNode());
            System.out.println(root.getData());
            inOrderTraverse(root.getRightNode());
        }
    }

    @Override
    public void postOrderTraverse(NodeTree root) {
        if (root==null)
        {
            return;
        }
        else
        {
            postOrderTraverse(root.getLeftNode());
            postOrderTraverse(root.getRightNode());
            System.out.println(root.getData());
        }
    }

    @Override
    public void preOrderTraverse(NodeTree root) {
        if (root==null)
        {
            return;
        }
        else
        {
            System.out.println(root.getData());
            preOrderTraverse(root.getLeftNode());
            preOrderTraverse(root.getRightNode());
        }
    }
    
    //getter and setter
    public NodeTree getRoot() {
        return root;
    }

    public void setRoot(NodeTree root) {
        this.root = root;
    }

    @Override //this function cant return null
    public NodeTree locate(NodeTree root, E value) {
        if (root.getData()==value) // if root data equal value then it is done
        {
            return root;
        }
        
        NodeTree child;
        if (root.compareTo(new NodeTree(value))<0) //if value more than data
        {
            child= root.getRightNode(); //get to the right node
        }
        else //if value less than data
        {
            child=root.getLeftNode(); //get to the left node
        }
        
        if (child==null) //if child is null. mean the only possible location is the root
        {
            return root;
        }
        else //if child is not null
        {
            return locate(child, value); //keep searching;
        }
    }

    @Override
    public NodeTree predecessor(NodeTree root) {
        NodeTree result= root.getLeftNode(); //get left Node of the root
         //start searching on right branch of the left child node of the root
        while (result.getRightNode()!=null)
        {
            result= result.getRightNode();
        }
        return result;
    }

}
