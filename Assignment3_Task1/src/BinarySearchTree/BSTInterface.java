/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BinarySearchTree;

/**
 *
 * @author jimmynguyen
 */
public interface BSTInterface<E> {
    public void add(E value, boolean allowDuplicate);
    public NodeTree<E> removeTop(); //remove the top node or the root, return new root which has no parent
    public NodeTree<E> locate(NodeTree<E> root, E value); //this function cant return null
    //we store dublicate value on left tree
    public NodeTree predecessor (NodeTree root); //find the node predecssor of the root (for example the root =10 , the predessor is the node that have less but cloest value to the root , ex =9
    public int treeSize();
    public boolean isEmpty();
    public boolean contains(E value);
    public int treeHeight(NodeTree<E> root);
    public void traverse();
}
