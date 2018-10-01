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
        tree.inOrderTraverse(root);
        System.out.println(tree.getSize());
        
    }
    
}
