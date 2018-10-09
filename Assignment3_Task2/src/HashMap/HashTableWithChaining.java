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
    
    public HashTableWithChaining(int initialCapacity)
    {
        bucketArray= new SingleLinkedList[initialCapacity];
        this.setCapacity(initialCapacity);
        this.setSize(0);
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
            this.setSize(this.getSize()+1);//increase the size of the Hash Table
             //print out information
        System.out.println("Person "+element+" has been added. The current size of the map is "+this.getSize()+" with the capacity of "+this.getCapacity());
        }
        else // Collision happen .if list already there , it mean it must have element (if it has no element it will be null as remove method do)
        {
            int indexElement= bucketArray[indexBucket].indexOf(element); //check if element has been in the list
            if(indexElement==-1) // if element has not been in the list
            {
                bucketArray[indexBucket].add(element); //add element to list
                this.setSize(this.getSize()+1);//increase the size of the Hash Table
                 //print out information
        System.out.println("Person "+element+" has been added. The current size of the map is "+this.getSize()+" with the capacity of "+this.getCapacity());
            }
            else //if element already in the list , it mean it has the same key. 
            {
                bucketArray[indexBucket].replace(indexElement,element); //we replace value of old element to value of new element
            }          
        }
        
       
        
        if (1.0d*this.getSize()/this.getCapacity()>=0.75) // check if it exceed load factor
        {
            SingleLinkedList<E> listElement= this.getAllElement(); //save all the elements to a list
            int oldCapacity = this.getCapacity();
            int newCapacity= oldCapacity*2;// double capacity
            //set the new array and attribute
            bucketArray= new SingleLinkedList[newCapacity];
            this.setCapacity(newCapacity);
            this.setSize(0);
            //set all to null
            for(int i=0;i<bucketArray.length;i++)
            {
                bucketArray[i]=null;
            }
            //print information to inform that Hash Table has been extended
            System.out.println("===========================================================================================================================================================");
            System.out.println("The load factor has exceed 0.75. Hash Table are exapanded by a factor of 2 . The old capacity is: "+oldCapacity+" The new capacity is: "+this.getCapacity());
            System.out.println("All elements will be rehashed as follow:");
            //add back all element
            for(int i=0;i<listElement.getSize();i++)
            {
                this.add(listElement.get(i).getData());
            }
            System.out.println("===========================================================================================================================================================");
        }

    }
    
    public E remove(E element)
    {
        int indexBucket = getBucketIndex(element);
        //find index
        if (bucketArray[indexBucket]!=null)
        {
            int indexInList = bucketArray[indexBucket].indexOf(element);
            if (indexInList!=-1)//if element exist
            {
                E removeElement= bucketArray[indexBucket].remove(indexInList);
                if(bucketArray[indexBucket].isEmpty()) // if bucket Array is empty
                {
                    bucketArray[indexBucket]=null; // set bucket Array to null
                }
                this.setSize(this.getSize()-1);//reduce the size of the Hash Table
                //print out information
                System.out.println("Person "+removeElement+" has been removed. The current size of the map is "+this.getSize()+" with the capacity of "+this.getCapacity());
                return removeElement;
            }
        }
        return null;
    }
    
    public boolean contains(E element)
    {
        
        int index= getBucketIndex(element);
        if ((bucketArray[index]!=null)&&(bucketArray[index].contain(element)))
        {
            return true;
        }     
        return false;
    }
    
    public String toString()
    {
        for(int i=0;i<this.getCapacity();i++)
        {
            if (bucketArray[i]!=null) //if bucketArray element is not null and not empty
            {
                System.out.print("Bucket "+"["+i+"]: ");
                bucketArray[i].traverse();
            }
            else
            {
                System.out.println("Bucket "+"["+i+"]: Null");
            }
        }
        return "";
    }
    
    private int getBucketIndex(E element)
    {
        Person aPerson= (Person) element;
        long key= aPerson.generateHashCode();
        int index= (int) (key%this.getCapacity());
        return index;
    }
    
    private SingleLinkedList<E> getAllElement()
    {
        SingleLinkedList<E> listElement= new SingleLinkedList<E>();
        for(int i=0;i<this.getCapacity();i++)
        {
            if (bucketArray[i]!=null) //if bucketArray element is not null and not empty
            {
                for(int j=0;j<bucketArray[i].getSize();j++)
                {
                    listElement.add(bucketArray[i].get(j).getData()); //add element
                }
            }           
        }
        return listElement;
    }
}
