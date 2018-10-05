/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMap;

/**
 *
 * @author jimmynguyen
 */
public interface MapInterface<K,V> {
    public V get(K key);
    public V put(K key, V value);
    public V remove(K key);
    public int size();
    public int capacity();
}
