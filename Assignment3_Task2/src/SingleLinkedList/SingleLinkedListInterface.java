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
public interface SingleLinkedListInterface<E> {
    public void add(E value);
    public E remove(int index);
    public NodeLinkedList<E> get(int index);
    public boolean contain(E value);
    public void traverse();
    public boolean isEmpty();
    public int size();
    public int indexOf(E value);
    public void replace(int index, E value);
}
