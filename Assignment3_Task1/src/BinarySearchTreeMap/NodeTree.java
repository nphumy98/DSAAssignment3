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
public class NodeTree<E> {
    private E data;
    private NodeTree parent;
    private NodeTree leftNode;
    private NodeTree rightNode;
    
    //constructor
    public NodeTree(E data)
    {
        this.data=data;
        parent=leftNode=rightNode=null;
    }
    
    //method compareTo
    public int compareTo(NodeTree anotherNodeTree)
    {
        if ((int)this.data==(int)anotherNodeTree.getData())
        {
            return 0;
        }
        else if((int)this.data>(int)anotherNodeTree.getData())
        {
            return 1;
        }
        else
        {
            return -1;
        }
    }
    //getter and setter
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public NodeTree getParent() {
        return parent;
    }

    public void setParent(NodeTree parent) {
        this.parent = parent;
    }

    public NodeTree getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(NodeTree leftNode) {
        this.leftNode = leftNode;
        leftNode.setParent(this); //set parent of leftnode is this parent
    }

    public NodeTree getRightNode() {
        return rightNode;
    }

    public void setRightNode(NodeTree rightNode) {
        this.rightNode = rightNode;
        rightNode.setParent(this); //set parent of rightNode is this parent
    }
    
}
