/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeMap;


/**
 *
 * @author jimmynguyen
 */
public interface BSTMapInterface<K,V> {
    public V add(NodeTreeMap<K,V> aNode); //return lastAddedValue if the key already existed in data. else return null
    public NodeTreeMap<K,V> locate(NodeTreeMap<K,V> root, K key); //this function cant return null
    //we store dublicate value on left tree
    public NodeTreeMap<K,V> predecessor (NodeTreeMap<K,V> root); //find the node predecssor of the root (for example the root =10 , the predessor is the node that have less but cloest value to the root , ex =9
    public int treeSize();
    public boolean isEmpty();
    public int treeHeight(NodeTreeMap<K,V> root);
    public void traverse();

}
