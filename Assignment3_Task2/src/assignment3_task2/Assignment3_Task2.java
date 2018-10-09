/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_task2;

import HashMap.HashTableWithChaining;
import HashMap.Person;
import SingleLinkedList.SingleLinkedList;
import java.util.Scanner;

/**
 *
 * @author jimmynguyen
 */
public class Assignment3_Task2 {

    /**
     * @param args the command line arguments
     */
    private static Scanner keyboard= new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
    
        //create HashTable with initial capacity of 10
        HashTableWithChaining<Person> hashTable= new HashTableWithChaining<Person>(10);
        int option=-1;
        while(option!=6)
        {
            printMenu();
            option= keyboard.nextInt();
            keyboard.nextLine();// clear buffer
            if(option==1)
            {
                System.out.println("Please provide person nane:");
                String name = keyboard.nextLine();
                System.out.println("Please provide phone number:");
                String phoneNumber= keyboard.nextLine();
                System.out.println("Please person's age:");
                int age= keyboard.nextInt();
                keyboard.nextLine();// clear buffer
                Person addedPerson= new Person(name, phoneNumber, age);
                hashTable.add(addedPerson);//add person to hashtable
            }
            else if (option==2)
            {
                System.out.println("Please provide person nane:");
                String name = keyboard.nextLine();
                Person removePerson= new Person(name);
                hashTable.remove(removePerson);// remove person from hashtable
            }
            else if (option==3)
            {
                System.out.println("Please provide person nane:");
                String name = keyboard.nextLine();
                Person checkPerson= new Person(name);
                if (hashTable.contains(checkPerson))// //check if person belong to
                {
                    System.out.println("This person: "+checkPerson.getName()+" in the hash table");
                }
                else
                {
                    System.out.println("This person: "+checkPerson.getName()+" NOT in the hash table");
                }
            }
            else if (option==4)
            {
                 System.out.println("Size of the hash table:"+hashTable.getSize());
            }
            else if (option==5)
            {
                System.out.println("************************************************************************************************");
                System.out.println("Print out the whole hash table:");
                hashTable.toString();
                System.out.println("************************************************************************************************");
            }
            else if (option==6)
            {
                System.out.println("Good bye. Thank for using our program!!!");
            }
        }
//        Person person1 =new Person("hihi","021",21);
//        Person person2= new Person("hoho","021",21);
//        Person person3= new Person("haha","021",21);
//        Person person4= new Person("huhu","021",21);
//        Person person5= new Person("kaka","022",22);
//        Person person6= new Person("6","021",21);
//        Person person7= new Person("7","021",21);
//        Person person8= new Person("8","021",21);
//        hashTable.toString();
//        hashTable.add(person1);
//        hashTable.add(person2);
//        hashTable.add(person3);
//        hashTable.add(person4);
//        hashTable.add(person5);
//        hashTable.add(person6);
//        hashTable.add(person7);
//        hashTable.add(person8);
//        hashTable.toString();
//        System.out.println(hashTable.contains(person5));
//        System.out.println(hashTable.remove(person4));
//        System.out.println(hashTable.getSize());
//        hashTable.toString();
//        System.out.println(hashTable.getSize());
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
    
    public static void printMenu()
    {
        System.out.println("1. Add a person to HashTable");
        System.out.println("2. Remove a person to HashTable");
        System.out.println("3. Check a person (test contains method)");
        System.out.println("4. Get size of HashTable");
        System.out.println("5. To String method");
        System.out.println("6. Quit program");
    }
}
