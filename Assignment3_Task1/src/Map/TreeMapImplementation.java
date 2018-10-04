/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import BinarySearchTree.AbstractBST;
import BinarySearchTree.BST;
import BinarySearchTree.NodeTree;
import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author jimmynguyen
 */
public class TreeMapImplementation<K,V> extends AbstractBSTMap<K,V> implements BSTMapInterface<K,V>{
    
    private NodeTreeMap<K,V> root;
    
    public TreeMapImplementation(NodeTreeMap<K,V> root)
    {
        this.root=root;
    }

    @Override
    public void add(K key, V value) {
        //find the appropriate position
        NodeTreeMap<K,V> newNode= new NodeTreeMap<K,V>(key);
        if (this.root==null) // if the tree is empty
        {
            this.root=newNode;
        }
        else
        {
            NodeTreeMap<K,V> locatePosition= locate(this.root, key); //find location. this locatePosition cant be null because of function locate
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
                // do nothing
            }
        }
        this.setSize(this.getSize()+1);//increase size of data by 1
    }

    @Override
    public NodeTreeMap<K, V> locate(NodeTreeMap<K, V> root, K key) {
        if (root.getKey()==key) // if root data equal value then it is done
        {
            return root;
        }
        
        NodeTreeMap<K,V> child;
        if (root.compareTo(new NodeTreeMap(key))<0) //if value more than data
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
            return locate(child, key); //keep searching;
        }
    }

    @Override
    public NodeTreeMap<K,V> predecessor(NodeTreeMap<K,V> root) {
       NodeTreeMap<K,V> result= root.getLeftNode(); //get left Node of the root
         //start searching on right branch of the left child node of the root
        while (result.getRightNode()!=null)
        {
            result= result.getRightNode();
        }
        return result;
    }

    @Override
    public boolean contains(K key) {
        NodeTreeMap<K,V> checkNode= new NodeTreeMap(key);
        NodeTreeMap locatePosition= locate(this.root,key);
        if (locatePosition.compareTo(checkNode)==0) //if that locate postion data equals to the value mean value already in the tree
        {
            return true; //return true
        }
        return false; //else return false
    }

    @Override
    public int treeHeight(NodeTreeMap<K, V> root) {
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
    
    private void inOrderTraverse(NodeTreeMap<K,V> root) {
        if (root==null)
        {
            return;
        }
        else
        {
            inOrderTraverse(root.getLeftNode());
            root.printNodeData();
            inOrderTraverse(root.getRightNode());
        }
    }

}
