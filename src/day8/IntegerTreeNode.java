/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package day8;

/**
 *
 * @author tom
 */
public class IntegerTreeNode {

    int value;
    IntegerTreeNode left = null;
    IntegerTreeNode right = null;
    private static String tempString;
    private static int depthCount, tempCount;
    
    public IntegerTreeNode (int value) {
        this.value = value;
    }
    
    public void add(int newNumber) {
        if (newNumber > this.value) {
            if (right == null) {
                right = new IntegerTreeNode(newNumber);
            } else {
                right.add(newNumber);
            }
        } else {
            if (left == null) {
                left = new IntegerTreeNode(newNumber);
            } else {
                left.add(newNumber);
            }
        }
    }
    
    private String nodeToString() {
        //return "["+this.value+" L"+this.left.value+" R"+this.right.value+"] ";
        String rightString, leftString;
        if(this.left==null) {
            leftString = "null";
        } else {
            leftString = Integer.toString(left.value);
        }
        if(this.right==null) {
            rightString = "null";
        } else {
            rightString = Integer.toString(right.value);
        }
        return "["+value+" L "+leftString+" R "+rightString+"] ";
    }
    
    public void travel() { 
        tempString = tempString + value;
        //System.out.print(nodeToString());
        if (this.left != null) {
            tempString = tempString + " [";
            this.left.travel();
        } else {
            tempString = tempString + "]";
        }
        if (this.right != null) {
            tempString = tempString + " [";
            this.right.travel();
        } else tempString = tempString + "]";
        //return nodeToString();
    }
    
    public String toString() {
        tempString = "[";
        this.travel();
        return tempString;
    }
    
    public boolean contains(int n) {
        if (n == this.value) {
            return true;
        } else if (n > this.value) {
            if (right == null) {
                return false;
            } else {
                return right.contains(n);
            }
        } else {
            if (left == null) {
                return false;
            } else {
                return left.contains(n);
            }            
        }
    }
    
    public int getMax() {
        // Returns the greatest value to the right from
        // the current node. Will only give the greatest
        // value if used from the top of the tree.
        if (right == null) {
            return this.value;
        } else {
            return right.getMax();
        } 
    }
    
    public int getMin() {
        // Returns the smallest value to the right from
        // the current node. Will only give the smallest
        // value if used from the top of the tree.
        if (left == null) {
            return this.value;
        } else {
            return left.getMin();
        } 
    }   
    
    public void goDown() {
        tempString = tempString + value;
        //System.out.print(nodeToString());
        if (this.left != null) {
            tempCount++;
            this.left.goDown();
        }
        if ((this.right != null)) {
            tempCount++;
            this.right.goDown();
        }
        
        if (tempCount > depthCount) {
            depthCount = tempCount;
            tempCount--;
        }
    }
    
    public int depth() {
        depthCount = 0;
        tempCount = -1;
        this.goDown();
        return depthCount;
    }
    
    public boolean isLeaf() {
        if (left == null && right == null) {
            return true;
        } else {
            return false;
        }
    }
    
    public void remove(int i) {
        System.out.println("Now at: "+this.value);
        if (left != null && left.value == i) {
            if (left.isLeaf()) {
                left = null;
                System.out.println("Node removed,.");
            } else {
                if (left.right != null) {
                    IntegerTreeNode leftOrphan = left.left;
                    IntegerTreeNode currentNode = left.right;
                    left = left.right;
                    while (currentNode.left != null) {
                        currentNode = currentNode.left;
                    }
                    currentNode.left = leftOrphan;
                } else {
                    left = left.left;
                }
            }
        }
        
        if (right != null && right.value == i) {
            if (right.isLeaf()) {
                right = null;
                System.out.println("Node removed,.");
            } else {
                if (right.right != null) {
                    IntegerTreeNode leftOrphan = right.left;
                    IntegerTreeNode currentNode = right.right;
                    right = right.right;
                    while (currentNode.left != null) {
                        currentNode = currentNode.left;
                    }
                    currentNode.left = leftOrphan;
                } else {
                    right = right.left;
                }
            }
        }
        
        if (i > value && right != null) {
            right.remove(i);
        } else if (i < value && left != null) {
            left.remove(i);
        } else {
            System.out.println("Number not found.");
        }
    }
    
}