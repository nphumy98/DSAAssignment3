/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleLinkedList;

/**
 *
 * @author jimmynguyen
 */
public abstract class AbstractSingleLinkedList<E> implements SingleLinkedListInterface<E> {
    private int size;
    public int size()
    {
        return size;
    }
    
    public boolean isEmpty()
    {
        return (size<=0);
    }
    
    //getter and setter
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
