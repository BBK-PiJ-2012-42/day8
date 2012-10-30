/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package day8;

/**
 *
 * @author tom
 */
public class Day8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IntegerTreeNode root = new IntegerTreeNode(6);
        root.add(5);
        root.add(9);
        root.add(3);
        root.add(8);
        root.add(11);
        root.add(12);
        root.add(15);
        
        System.out.println("Max value: "+root.getMax());
        System.out.println("Min value: "+root.getMin());
        
        System.out.println(root.toString());
        
        System.out.println("Depth "+root.depth());
        
        //root.travel();
        
        root.remove(11);
        
        System.out.println(root.toString());
        
    }
}
