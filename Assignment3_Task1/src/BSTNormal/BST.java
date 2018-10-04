/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTNormal;

/**
 *This BST may accept dublicate value to be added
 * @author jimmynguyen
 */
public class BST<E> extends AbstractBST<E> implements BSTInterface<E>{

    private NodeTree<E> root;
    
    //constructor
    public BST()
    {
        this.setSize(0);//set the size tree is 0
        this.root=null; //set root is null;
    }
    
    public BST(NodeTree<E> root)
    {
        new BST();
        if (root!=null)// if root !=null
        {
            this.root=root; //set the root tree to new root
            this.setSize(1); //set the size Tree is 1
        }
    }
    
    @Override
    public void add(E value, boolean allowDuplicate) {
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
                if (allowDuplicate==true) //duplicate value is allowed
                {
                    predecessor(locatePosition).setRightNode(newNode); //take the dublicate data the right node of the predecessor of the locatePostion node
                }
                else
                {
                    //do nothing
                }
            }
        }
        this.setSize(this.getSize()+1);//increase size of data by 1
    }

    @Override
    public boolean contains(E value) {
        NodeTree checkNode= new NodeTree(value);
        NodeTree locatePosition= locate(this.root,value);
        if (locatePosition.compareTo(checkNode)==0) //if that locate postion data equals to the value mean value already in the tree
        {
            return true; //return true
        }
        return false; //else return false
    }

    @Override //remove the top node or the root, return new root which has no parent
    public NodeTree<E> removeTop() {
        NodeTree<E> newRoot= null;
        NodeTree<E> leftNode= root.getLeftNode();
        NodeTree<E> rightNode= root.getRightNode();
        if ((leftNode==null)&&(rightNode==null))
        {
            root=null;
        }
        else if (leftNode==null)
        {
            rightNode.setParent(null);// set parent of rightNode is null
            root= rightNode; //new root is rightNode
        }
        else if (rightNode==null)
        {
            leftNode.setParent(null);// set parent of rightNode is null
            root= leftNode;// new root is leftNode
        }
        else
        {
            NodeTree <E> predessor = predecessor(root);//this will be new root
            //System.out.println(root.getData());
            if (predessor!= root.getLeftNode()) //if predessor is different to the left node of the root
            {
                predessor.setLeftNode(root.getLeftNode()); //set the leftNode of of predessor as the leftnode of the root
                predessor.getParent().setRightNode(null); //parent of predessor get disconnected with it
            }
            
            predessor.setRightNode(root.getRightNode()); //set the leftNode of of predessor as the rightNode of the root
            root= predessor;// set it as new root
            root.setParent(null);//disconnect from parent
        }
       return root;
    }

    @Override
    public int treeHeight(NodeTree<E> root) {
        if (root==null)
        {
            return -1;
        }
        else
        {
            int treeHeightLeft= treeHeight(root.getLeftNode());
            int treeHeighRight= treeHeight(root.getRightNode());
            if (treeHeightLeft>treeHeighRight)
            {
                return treeHeightLeft+1;
            }
            else
            {
                return treeHeighRight+1;
            }
        }
    }
    
    @Override
    public void traverse() {
        inOrderTraverse(this.root);
    }
    
    private void inOrderTraverse(NodeTree root) {
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

    
    //getter and setter
    public NodeTree getRoot() {
        return root;
    }

    public void setRoot(NodeTree root) {
        this.root = root;
    }

    @Override //this function cant return null
    public NodeTree<E> locate(NodeTree<E> root, E value) {
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
        if (result!=null)
        {
            while (result.getRightNode()!=null)
            {
                result= result.getRightNode();
            }
            return result;
        }
        else // if tree does not have leftNode
        {
            return root;
        }
    }
}
