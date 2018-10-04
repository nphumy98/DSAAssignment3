/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TreeMap;

import BSTNormal.BST;

/**
 *
 * @author jimmynguyen
 */
public interface MapInterface<K,V> {
    public BST<V> get(K key);
    public V put(K key, V value);
    public boolean containsKey(K key);
    public BST<K> keySet(); //return all set
    public BST<V> values(); //return value range
    public TreeMapSet<K,V> entrySet(); //return set of association (entrySet) 
}
