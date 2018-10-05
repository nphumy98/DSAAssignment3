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
public class Node<E> {
    private E data;
    private Node nextNode;
    
    //constructor
    public Node(E data)
    {
        this.data= data;
        this.nextNode=null;
    }
    //getter and setter
    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
    
}
