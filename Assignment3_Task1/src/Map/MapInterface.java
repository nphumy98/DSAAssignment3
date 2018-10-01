/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Map;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author jimmynguyen
 */
public interface MapInterface<K,V> {
    public V get(K key);
    public V put(K key, V value);
    public V remove(K key);
    public boolean containsKey(K key);
    public boolean containsValue(V value);
    public Set<K> keySet(); //return all set
    public ArrayList<V> values(); //return value range
    public Set<Association<K,V>> entrySet(); //return set of association (entrySet) 
}
