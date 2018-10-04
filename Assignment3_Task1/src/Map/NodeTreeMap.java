/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import BinarySearchTree.BST;

/**
 *
 * @author jimmynguyen
 */
public class NodeTreeMap<K,V> {
    private K key;
    private BST<V> treeValue;
    private NodeTreeMap parent;
    private NodeTreeMap leftNode;
    private NodeTreeMap rightNode;
    
    //constructor
    public NodeTreeMap(K key)
    {
        this.key=key;
        this.treeValue=new BST<V>();
        parent=leftNode=rightNode=null;
    }
    //print out
    public void printNodeData()
    {
        System.out.println("For Key: ["+this.key+"] :"); // print key
        treeValue.traverse(); // print all value
    }
    
    //compare to function
    public int compareTo(NodeTreeMap anotherNodeTreeMap)
    {
        int keyThis = (int) key;
        int keyThat= (int) anotherNodeTreeMap.getKey();
        return (keyThis-keyThat);
    }
    
    public void addValue(V value)
    {
        if(treeValue.contains(value)==false)
        {
             treeValue.add(value);
        }
        else
        {
            System.out.println("This value ["+ value +"] already associated with the key ["+this.key+"] . It cannot be added");
        }
    }
    //getter and setter
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public BST<V> getTreeValue() {
        return treeValue;
    }

    public void setTreeValue(BST<V> treeValue) {
        this.treeValue = treeValue;
    }

    public NodeTreeMap getParent() {
        return parent;
    }

    public void setParent(NodeTreeMap parent) {
        this.parent = parent;
    }

    public NodeTreeMap getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(NodeTreeMap leftNode) {
        this.leftNode = leftNode;
        if (leftNode!=null)
        {
            leftNode.setParent(this);
        }
    }

    public NodeTreeMap getRightNode() {
        return rightNode;
    }

    public void setRightNode(NodeTreeMap rightNode) {
        this.rightNode = rightNode;
        if (rightNode!=null)
        {
            rightNode.setParent(this);
        }
    }
    
    
}
