/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_task1;

import BinarySearchTree.BST;
import BinarySearchTree.NodeTree;
import TreeMap.NodeTreeMap;
import TreeMap.TreeMapSet;
import java.util.HashMap;
import java.util.TreeMap;



/**
 *
 * @author jimmynguyen
 */
public class Assignment3_Task1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        NodeTreeMap root= new NodeTreeMap(20,30);
        NodeTreeMap aNode= new NodeTreeMap(30,30);
        NodeTreeMap aNode2= new NodeTreeMap(40,20);
        NodeTreeMap aNode3= new NodeTreeMap(50,30);
        NodeTreeMap aNode4= new NodeTreeMap(60,75);
        NodeTreeMap aNode5= new NodeTreeMap(20,80);
        NodeTreeMap aNode6= new NodeTreeMap(90,30);
        NodeTreeMap aNode7= new NodeTreeMap(95,30);
        TreeMapSet aTreeMap= new TreeMapSet(root);
        aTreeMap.add(aNode);
        aTreeMap.add(aNode2);
        aTreeMap.add(aNode3);
        aTreeMap.add(aNode4);
        aTreeMap.add(aNode5);
        aTreeMap.add(aNode6);
        aTreeMap.add(aNode7);
        aTreeMap.traverse();
        System.out.println("====");
        aTreeMap.keySet().traverse();
        System.out.println("====");
        aTreeMap.values().traverse();
//TreeMap<Integer, String> hash_map = new TreeMap<Integer, String>(); 
//  
//        // Mapping string values to int keys 
//        hash_map.put(10, "Geeks");
//        hash_map.put(10, "Geek"); 
//        hash_map.put(15, "4"); 
//        hash_map.put(20, "haha"); 
//        hash_map.put(25, "Welcomes"); 
//        hash_map.put(30, "You"); 
//        String a=hash_map.put(10,"hehe");
//        // Displaying the HashMap 
//        System.out.println("Initial Mappings are: " + hash_map); 
//        System.out.println(a);
//        // Using values() to get the set view of values 
//        System.out.println("The collection is: " + hash_map.values()); 

    }
    
    
}
