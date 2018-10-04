/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeMap;

import BSTNormal.BST;
import BSTNormal.NodeTree;


/**
 *
 * This TreeMapSet does not accept dublicate Key to be added. 
 * if the key already existed, the value can be added However no dublicated value will be added in the same key
 * @author jimmynguyen
 */
public class TreeMapSet<K,V> extends AbstractBSTMap<K,V> implements BSTMapInterface<K,V>, MapInterface<K,V>{
    
    private NodeTreeMap<K,V> root;
    private BST<K> keySet; // not allow duplicate
    private BST<V> valueTreeCollection; //allow duplicate to see range of value
    
    public TreeMapSet(NodeTreeMap<K,V> root)
    {
        this.root=root;
        this.keySet= new BST<K>(new NodeTree(this.root.getKey())); // intialise the keySet
        this.valueTreeCollection= new BST<V>(new NodeTree(this.root.getTreeValue().getRoot().getData())); //initilise valueTree
        this.setSize(0);
        System.out.println("The new Key ["+root.getKey()+"] has been mapped to the Value ["+root.getTreeValue().getRoot().getData()+"]");
    }

    @Override //return lastAddedValue if the key already existed in data. else return null
    public V add(NodeTreeMap<K,V> aNode) {
        //find the appropriate position
        K key= aNode.getKey();
        V value= (V)aNode.getTreeValue().getRoot().getData();
        boolean isNewKeyAdded=true;
        NodeTreeMap<K,V> newNode= new NodeTreeMap<K,V>(key); //get new node with only to compare
        if (this.root==null) // if the tree is empty
        {
            this.root=aNode;
            this.setSize(this.getSize()+1);//increase size of data by 1
        }
        else
        {
            NodeTreeMap<K,V> locatePosition= locate(this.root, key); //find location. this locatePosition cant be null because of function locate
            if (locatePosition.compareTo(newNode)<0) //if value is more than
            {
                locatePosition.setRightNode(aNode); //set new node as the right Node of locate position

            }
            else if(locatePosition.compareTo(newNode)>0) //if value is less than
            {
                locatePosition.setLeftNode(aNode);
                this.setSize(this.getSize()+1);//increase size of data by 1
            }
            else // if locatePosition.compareTo(new NodeTree(value))==0 -> dublicate key
            {
               isNewKeyAdded=false; // no new key will be added
               boolean isValueAdded=locatePosition.addValue(value); //add value to the tree (possibly)  but dont create any new node
               if (isValueAdded==true) // if new value is added to the old key
               {
                   this.valueTreeCollection.add(value,true);
               }
               return locatePosition.getLastAddedValue(); //return lastAddedValue
            }
        }
        if (isNewKeyAdded==true) // mean new key has been added
        {
            this.keySet.add(key, false);//add to keySet , not allow duplicate key
            this.valueTreeCollection.add(value,true); //add to value Tree Collection.
            this.setSize(this.getSize()+1);//increase size of data by 1
            System.out.println("The new Key ["+key+"] has been mapped to the Value ["+value+"]");
        }
        return null; //return null if newKey is created
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

    @Override //note that iftree only has root, height will be 0
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

    @Override
    public BST<V> get(K key) {
        BST<V> treeValue=null;
        if ((this==null)||(this.root==null))
        {
            System.out.println("TreeMap is null, cant find this key ["+key+"]");
            return null;
        }
        else
        {
            NodeTreeMap<K,V> locatePosition= locate(this.root, key); //find location. this locatePosition cant be null because of function locate
            if (locatePosition.getKey().equals(key))//if that key exist in data
            {
                treeValue=locatePosition.getTreeValue();
            }
        }
        return treeValue;
    }

    @Override
    public V put(K key, V value) {
        NodeTreeMap<K,V> aNode= new NodeTreeMap<K,V>(key,value);
        V returnValue= this.add(aNode);
        return returnValue;
    }
    
    @Override
    public boolean containsKey(K key) {
        NodeTreeMap<K,V> checkNode= new NodeTreeMap(key);
        NodeTreeMap locatePosition= locate(this.root,key);
        if (locatePosition.compareTo(checkNode)==0) //if that locate postion data equals to the value mean value already in the tree
        {
            return true; //return true
        }
        return false; //else return false
    }
    
    
    @Override
    public BST<K> keySet() {
        return this.keySet;
    }
    
    
    @Override
    public BST<V> values() {
        return this.valueTreeCollection;
    }

    @Override //this TreeMap actually contain all the NodeTree for the map so 
    public TreeMapSet<K,V> entrySet() {
        return this;
    }
    
    //getter root

    public NodeTreeMap<K, V> getRoot() {
        return root;
    }
    

}
