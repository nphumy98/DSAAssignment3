/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SingleLinkedList;

import HashMap.Person;

/**
 *
 * @author jimmynguyen
 */
public class SingleLinkedList<E> extends AbstractSingleLinkedList<E> implements SingleLinkedListInterface<E> {
    private NodeLinkedList<E> head;
    private NodeLinkedList<E> tail;
    
    //constructor
    public SingleLinkedList()
    {
        this.head=this.tail=null;
        this.setSize(0);//set size to 0
    }
    
    public SingleLinkedList(NodeLinkedList<E> head)
    {
        this.head=head;
        this.tail=this.head;
        this.setSize(1); //set size to 1
    }
    @Override
    public void add(E value) {
        NodeLinkedList<E> newNode= new NodeLinkedList(value);
        if (head==null)
        {
            head= newNode;
            tail= newNode;
        }
        else
        {
            tail.setNextNode(newNode);
            tail= tail.getNextNode();
        }
        this.setSize(this.getSize()+1);// increment size to 1
    }
    
    @Override
    public E remove(int index) {
        NodeLinkedList<E> removeNode= null;
        if (index>this.getSize()-1)
        {
            System.out.println("The index exceed the size. cant get this index");
        }
        else
        {
            if (index==0)//mean remove head
            {
                removeNode=this.head;
                this.head=head.getNextNode();
            }
            else
            {
                NodeLinkedList<E >previousRemoveNode=this.get(index-1);// get the previous node
                removeNode= this.get(index);// get the removeNode
                previousRemoveNode.setNextNode(removeNode.getNextNode()); //link previous node to next node of remove node
            }
            this.setSize(this.getSize()-1); //decrement size by 1
        }
        return removeNode.getData();
    }
    
    @Override//index from 0
    public NodeLinkedList<E> get(int index) {
        if (index>this.getSize()-1)
        {
            System.out.println("The index exceed the size. cant get this index");
            return null;
        }
        else
        {
            NodeLinkedList<E> currentNode= this.head;
            for(int i=1;i<=index;i++)
            {
                currentNode= currentNode.getNextNode();
            }
            return currentNode;
        }
    }

    @Override
    public void traverse() {
        if (!this.isEmpty())//if list is not empty
        {
            NodeLinkedList<E> currentNode= this.head;
            System.out.print(" "+currentNode.getData()+" ");
            for(int i=1;i<this.getSize();i++)
            {
                currentNode= currentNode.getNextNode();
                Person aPerson= (Person) currentNode.getData();
                System.out.print(aPerson+" ");
            }
        }
        else
        {
            System.out.println("The list is empty. It cant be printed");
        }
        System.out.println();
        
    }
    
    //getter and setter
    public NodeLinkedList<E> getHead() {
        return head;
    }

    public void setHead(NodeLinkedList<E> head) {
        this.head = head;
    }

    public NodeLinkedList<E> getTail() {
        return tail;
    }

    public void setTail(NodeLinkedList<E> tail) {
        this.tail = tail;
    }

    

    @Override
    public boolean contain(E value) {
        Person aPerson= (Person) value;
        if (!this.isEmpty())
        {
            for(int i=0;i<this.getSize();i++)
            {
                Person linkListPerson = (Person) this.get(i).getData();
                if (aPerson.compareTo(linkListPerson)) //if 2 Person has the same key
                {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int indexOf(E value) {
        NodeLinkedList<E> currentNode= this.head;
        Person aPerson= (Person) value;
        Person linkListPerson = (Person)currentNode.getData();
         if (aPerson.compareTo(linkListPerson))// if head is the data
        {
            return 0;
        }
        for(int i=1;i<this.getSize();i++)
        {
            currentNode= currentNode.getNextNode();
            linkListPerson=(Person)currentNode.getData();
            if (aPerson.compareTo(linkListPerson))
            {
                return i;
            }           
        }
        return -1;
    }

    @Override
    public void replace(int index, E value) {
        if((index>=0)&&(index<this.getSize()))
        {
            NodeLinkedList<E> oldNode=this.get(index);
            oldNode.setData(value);
        }    
    }
}
