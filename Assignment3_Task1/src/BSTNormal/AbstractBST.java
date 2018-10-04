/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BSTNormal;

/**
 *
 * @author jimmynguyen
 */
public abstract class AbstractBST<E> implements BSTInterface<E> {
    private int size;// number of element in the tree
    
    @Override
    public int treeSize()
    {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        if (size==0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    //getter and setter

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
}
