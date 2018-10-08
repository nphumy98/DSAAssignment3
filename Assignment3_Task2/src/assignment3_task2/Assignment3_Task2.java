/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_task2;

import HashMap.HashTableWithChaining;
import HashMap.Person;
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
        Person person1 =new Person("hihi","021",21);
        Person person2= new Person("hoho","021",21);
        Person person3= new Person("haha","021",21);
        Person person4= new Person("huhu","021",21);
        Person person5= new Person("kaka","022",22);
        Person person6= new Person("6","021",21);
        Person person7= new Person("7","021",21);
        Person person8= new Person("8","021",21);
        HashTableWithChaining<Person> hashTable= new HashTableWithChaining<Person>(10);
        hashTable.toString();
        hashTable.add(person1);
        hashTable.add(person2);
        hashTable.add(person3);
        hashTable.add(person4);
        hashTable.add(person5);
        hashTable.add(person6);
        hashTable.add(person7);
        hashTable.add(person8);
        hashTable.toString();
        System.out.println(hashTable.contains(person5));
        System.out.println(hashTable.remove(person4));
        System.out.println(hashTable.getSize());
        hashTable.toString();
        System.out.println(hashTable.getSize());
//          Person aPerson= new Person("ab","0212345",12);
//          System.out.println(aPerson.generateHashCode());
//        SingleLinkedList<Person> aList= new SingleLinkedList<Person>();
//        aList.traverse();
//        System.out.println(aList.getSize());
//        System.out.println(aList.get(0));
//        aList.add(person1);
//        aList.add(person2);
//        aList.add(person3);
//        aList.add(person4);
//        
//        System.out.println("===");
//        aList.traverse();
//        System.out.println(aList.getSize());
//        System.out.println("===");
//        System.out.println(aList.contain(person1));
//        System.out.println(aList.contain(person2));
//        System.out.println(aList.contain(person3));
//        System.out.println(aList.contain(person4));
//        System.out.println(aList.contain(person5));
//
//        System.out.println(aList.indexOf(person1));
//        System.out.println(aList.indexOf(person2));
//        System.out.println(aList.indexOf(person3));
//        System.out.println(aList.indexOf(person4));
//        System.out.println(aList.indexOf(person5));
//        
//        aList.replace(3, person5);
//        aList.traverse();

        
    }
    
}
