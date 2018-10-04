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
public class Association<K,V> {
    private K key;
    private V value;
    
    public Association(K key, V value)
    {
        this.key=key;
        this.value=value;
    }
    
    //compareTo
    public int compareTo(Association anotherAssociation)
    {
        int valueThis= (int) this.key;
        int valueThat= (int) anotherAssociation.getKey();
        return (valueThis-valueThat);
    }
    
    //toString
    
    //getter and setter
    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
    
}
