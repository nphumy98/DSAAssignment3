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
public abstract class AbstractHashMap<E> {
    private int size; //this is number of element in HashMap
    private int capacity;//this is the number of bucket
    
    public int size()
    {
        return size;
    }
    
    public int capacity()
    {
        return capacity;
    }
    
    //getter and setter
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
}
