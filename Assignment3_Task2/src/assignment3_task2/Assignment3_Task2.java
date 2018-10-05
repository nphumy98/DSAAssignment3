/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_task2;

import SingleLinkedList.SingleLinkedList;

/**
 *
 * @author jimmynguyen
 */
public class Assignment3_Task2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        SingleLinkedList<String> aList= new SingleLinkedList<String>();
        aList.traverse();
        System.out.println(aList.getSize());
        System.out.println(aList.get(0));
        aList.add("hee");
        aList.add("haha");
        aList.add("hoho");
        System.out.println("===");
        aList.traverse();
        System.out.println(aList.getSize());
        System.out.println(aList.get(1).getData());

        
    }
    
}
