/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_task1;

import BSTNormal.BST;
import BSTNormal.NodeTree;
import TreeMap.NodeTreeMap;
import TreeMap.TreeMapSet;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;


/**
 *
 * @author jimmynguyen
 */
public class Assignment3_Task1 {

    /**
     * @param args the command line arguments
     */
    private static Scanner keyboard= new Scanner(System.in);
    public static void main(String[] args) {
        // TODO code application logic here
        TreeMapSet<Integer, Integer> mainTreeMap = null;
        int option=-1;
        while (option!=7)
        {
            printMenu();
            option= keyboard.nextInt();
            keyboard.nextLine();// clean all buffer
            if(option==1)
            {
                System.out.println("Please enter a key and value in format: key,value");
                String input= keyboard.next();
                String[] splitKeyValueString= input.split(",");
                Integer key= Integer.parseInt(splitKeyValueString[0]);
                Integer value= Integer.parseInt(splitKeyValueString[1]);
                if (mainTreeMap==null) // if it is first time
                {
                    NodeTreeMap<Integer, Integer> root= new NodeTreeMap<Integer, Integer>(key,value);
                    mainTreeMap = new TreeMapSet<Integer, Integer>(root);
                }
                else
                {
                    mainTreeMap.put(key, value);
                }
                
            }
            else if (option==2)
            {
                if (mainTreeMap==null)
                {
                    System.out.println("Tree Map is empty, please put key value to have data first");
                }
                else
                {
                    System.out.println("Please enter a key");
                    Integer key= keyboard.nextInt();
                    keyboard.nextLine();// clear buffer
                    BST<Integer> treeMapValue=mainTreeMap.get(key);
                    if (treeMapValue!=null)
                    {
                        System.out.println("Collection of values which associated with the Key ["+key+"]");
                        treeMapValue.traverse();
                    }
                    else
                    {
                        System.out.println("This Key is not existed in the data");
                    }
                }
            }
            else if (option==3) //note that if tree only has root, the height will be 0;
            {
                if (mainTreeMap==null)
                {
                    System.out.println("Tree Map is empty, please put key value to have data first");
                }
                else
                {
                    System.out.println("Tree Height is "+mainTreeMap.treeHeight(mainTreeMap.getRoot()));
                }
            }
            else if (option==4)
            {
                if (mainTreeMap==null)
                {
                    System.out.println("Tree Map is empty, please put key value to have data first");
                }
                else
                {
                    BST<Integer> keySet= mainTreeMap.keySet();
                    System.out.println("The Set of All Keys");
                    keySet.traverse();
                }
            }
            else if (option==5)
            {
                if (mainTreeMap==null)
                {
                    System.out.println("Tree Map is empty, please put key value to have data first");
                }
                else
                {
                    BST<Integer> valueCollection= mainTreeMap.values();
                    System.out.println("The Collection of all Values");
                    valueCollection.traverse();
                }
            }
            else if (option==6)
            {
                if (mainTreeMap==null)
                {
                    System.out.println("Tree Map is empty, please put key value to have data first");
                }
                else
                {
                    TreeMapSet<Integer, Integer> entrySet= mainTreeMap;
                    System.out.println("All the Entry Set (NodeTree)");
                    entrySet.traverse();
                }
            }
        }
        

    }
    
    public static void printMenu()
    {
        System.out.println("Please select an option");
        System.out.println("1. Add key and value");
        System.out.println("2. Get value from key");
        System.out.println("3. Get Tree Height");
        System.out.println("4. Get Key Set");
        System.out.println("5. Get Values Collection");
        System.out.println("6. Get Entry Set");
        System.out.println("7. Quit Program");
    }
    
}
