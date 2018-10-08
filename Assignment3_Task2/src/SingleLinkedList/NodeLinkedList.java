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
public class NodeLinkedList<E> {
    private E data;
    private NodeLinkedList nextNode;
    
    //constructor
    public NodeLinkedList(E data)
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

    public NodeLinkedList getNextNode() {
        return nextNode;
    }

    public void setNextNode(NodeLinkedList nextNode) {
        this.nextNode = nextNode;
    }
    
}
