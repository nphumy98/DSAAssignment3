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
public class SingleLinkedList<E> extends AbstractSingleLinkedList<E> implements SingleLinkedListInterface<E> {
    private Node<E> head;
    private Node<E> tail;
    
    //constructor
    public SingleLinkedList()
    {
        this.head=this.tail=null;
        this.setSize(0);//set size to 0
    }
    
    public SingleLinkedList(Node<E> head)
    {
        this.head=head;
        this.tail=this.head;
        this.setSize(1); //set size to 1
    }
    @Override
    public void add(E value) {
        Node<E> newNode= new Node(value);
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

    @Override//index from 0
    public Node<E> get(int index) {
        if (index>this.getSize()-1)
        {
            System.out.println("The index exceed the size. cant get this index");
            return null;
        }
        else
        {
            Node<E> currentNode= this.head;
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
            Node<E> currentNode= this.head;
            System.out.println(currentNode.getData());
            for(int i=1;i<this.getSize();i++)
            {
                currentNode= currentNode.getNextNode();
                System.out.println(currentNode.getData());
            }
        }
        else
        {
            System.out.println("The list is empty. It cant be printed");
        }
        
    }
    
    //getter and setter
    public Node<E> getHead() {
        return head;
    }

    public void setHead(Node<E> head) {
        this.head = head;
    }

    public Node<E> getTail() {
        return tail;
    }

    public void setTail(Node<E> tail) {
        this.tail = tail;
    }
}
