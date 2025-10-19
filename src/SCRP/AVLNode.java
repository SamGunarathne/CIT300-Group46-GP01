package SCRP;

//AVLNode.java
public class AVLNode {
 String key;
 int height;
 AVLNode left, right;

 public AVLNode(String key) {
     this.key = key;
     height = 1;
 }
}
