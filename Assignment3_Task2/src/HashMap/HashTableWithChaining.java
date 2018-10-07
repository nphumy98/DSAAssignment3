/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMap;

import SingleLinkedList.SingleLinkedListInterface;

/**
 *
 * @author jimmynguyen
 */
public class HashTableWithChaining<E> extends AbstractHashMap<E> {
    private SingleLinkedListInterface<E>[] bucketArray;
    
    public HashTableWithChaining()
    {
        bucketArray= new SingleLinkedListInterface[this.getCapacity()];
        //set all to null
        for(int i=0;i<bucketArray.length;i++)
        {
            bucketArray[i]=null;
        }
    }
    
    public void add()
    {
        
    }
    
    public E remove(E element)
    {
        int indexBucket = getBucketIndex(element);
        //find index
        int indexInList = bucketArray[indexBucket].indexOf(element);
        if (indexInList!=-1)//if element exist
        {
            return bucketArray[indexBucket].remove(indexInList);
        }
        else
        {
            return null;
        }
    }
    
    public boolean contains(E element)
    {
        int index= getBucketIndex(element);
        if (bucketArray[index].contain(element))
        {
            return true;
        }
        return false;
    }
    
    public void String()
    {
        
    }
    
    public int getBucketIndex(E element)
    {
        Person aPerson= (Person) element;
        long key= aPerson.generateHashCode();
        int index= (int) (key%this.getCapacity());
        return index;
    }
}
