/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3_task1;

import BinarySearchTreeMap.BST;
import BinarySearchTreeMap.NodeTree;



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
        int a1=50;
        int a2=45;
        NodeTree root = new NodeTree(50);
        NodeTree root2= new NodeTree(a2);
        
        System.out.println(root.compareTo(root2));
        BST tree = new BST(root);
        tree.add(45);
        tree.add(60);
        tree.add(16);
        tree.add(48);
        tree.add(55);
        tree.add(72);
        tree.add(50);
        tree.traverse();
        System.out.println(tree.getSize());
        System.out.println("====================");
        System.out.println(tree.contains(16));
        System.out.println(tree.contains(45));
        System.out.println(tree.contains(48));
        System.out.println(tree.contains(50));
        System.out.println(tree.contains(55));
        System.out.println(tree.contains(60));
        System.out.println(tree.contains(72));
        System.out.println("====================");
        System.out.println(tree.contains(80));
        System.out.println(tree.contains(10));
        System.out.println(tree.contains(20));
        System.out.println("====================");
        NodeTree root3= new NodeTree(500);
        BST tree2 = new BST(root3);
        tree2.add(600);
       tree2.add(700);
        tree2.add(880);
 //       tree2.add(550);
//        tree2.add(540);
        tree2.add(400);
        tree2.add(300);
        tree2.add(450);
        tree2.traverse();
        System.out.println(tree2.treeHeight(tree2.getRoot()));
        
    }
    
}
