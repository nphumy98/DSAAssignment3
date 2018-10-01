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
public interface BSTInterface<E> {
    public void add(E value);
    public E remove(E data);
    public NodeTree locate(NodeTree root, E value); //this function cant return null
    //we store dublicate value on left tree
    public NodeTree predecessor (NodeTree root); //find the node predecssor of the root (for example the root =10 , the predessor is the node that have less but cloest value to the root , ex =9
    public int treeSize();
    public boolean isEmpty();
    public boolean contains(E value);
    public int treeHeight();
    public void inOrderTraverse(NodeTree root);
    public void postOrderTraverse(NodeTree root);
    public void preOrderTraverse(NodeTree root);
}
