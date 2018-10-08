/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashMap;

import SingleLinkedList.NodeLinkedList;
import SingleLinkedList.SingleLinkedList;

/**
 *
 * @author jimmynguyen
 */
public class HashTableWithChaining<E> extends AbstractHashMap<E> {
    private SingleLinkedList<E>[] bucketArray;
    
    public HashTableWithChaining()
    {
        bucketArray= new SingleLinkedList[this.getCapacity()];
        //set all to null
        for(int i=0;i<bucketArray.length;i++)
        {
            bucketArray[i]=null;
        }
    }
    
    public void add(E element)
    {
        int indexBucket = getBucketIndex(element);
        if(bucketArray[indexBucket]==null) // if bucketArray is null , it mean it has no element
        {
            NodeLinkedList<E> root= new NodeLinkedList<E>(element); //set element as the root 
            bucketArray[indexBucket]= new SingleLinkedList<E>(root); //initialise the list 
        }
        else // Collision happen .if list already there , it mean it must have element (if it has no element it will be null as remove method do)
        {
            int indexElement= bucketArray[indexBucket].indexOf(element); //check if element has been in the list
            if(indexElement==-1) // if element has not been in the list
            {
                bucketArray[indexBucket].add(element); //add element to list
            }
            else //if element already in the list , it mean it has the same key. 
            {
                bucketArray[indexBucket].replace(indexElement,element); //we replace value of old element to value of new element
            }
            
        }
        this.setSize(this.getSize()+1);//increase the size of the Hash Table

    }
    
    public E remove(E element)
    {
        int indexBucket = getBucketIndex(element);
        //find index
        int indexInList = bucketArray[indexBucket].indexOf(element);
        if (indexInList!=-1)//if element exist
        {
            E removeElement= bucketArray[indexBucket].remove(indexInList);
            if(bucketArray[indexBucket].isEmpty()) // if bucket Array is empty
            {
                bucketArray[indexBucket]=null; // set bucket Array to null
            }
            this.setSize(this.getSize()-1);//reduce the size of the Hash Table
            return removeElement;
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
    
    public String toString()
    {
        for(int i=0;i<this.getSize();i++)
        {
            if (bucketArray[i]!=null) //if bucketArray element is not null and not empty
            {
                System.out.println("Bucket "+"["+i+"]:");
                bucketArray[i].traverse();
            }
            else
            {
                System.out.println("Bucket "+"["+i+"]: Null");
            }
        }
        return "";
    }
    
    public int getBucketIndex(E element)
    {
        Person aPerson= (Person) element;
        long key= aPerson.generateHashCode();
        int index= (int) (key%this.getCapacity());
        return index;
    }
}
