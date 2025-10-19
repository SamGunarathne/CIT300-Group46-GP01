package SCRP;

//AVLTree.java
public class AVLTree {
 private AVLNode root;

 int height(AVLNode N) {
     return (N == null) ? 0 : N.height;
 }

 int getBalance(AVLNode N) {
     return (N == null) ? 0 : height(N.left) - height(N.right);
 }

 AVLNode rightRotate(AVLNode y) {
     AVLNode x = y.left;
     y.left = x.right;
     x.right = y;
     y.height = Math.max(height(y.left), height(y.right)) + 1;
     x.height = Math.max(height(x.left), height(x.right)) + 1;
     return x;
 }

 AVLNode leftRotate(AVLNode x) {
     AVLNode y = x.right;
     x.right = y.left;
     y.left = x;
     x.height = Math.max(height(x.left), height(x.right)) + 1;
     y.height = Math.max(height(y.left), height(y.right)) + 1;
     return y;
 }

 AVLNode insert(AVLNode node, String key) {
     if (node == null) return new AVLNode(key);

     if (key.compareTo(node.key) < 0)
         node.left = insert(node.left, key);
     else if (key.compareTo(node.key) > 0)
         node.right = insert(node.right, key);
     else
         return node; // duplicate not allowed

     node.height = 1 + Math.max(height(node.left), height(node.right));
     int balance = getBalance(node);

     // Rebalancing
     if (balance > 1 && key.compareTo(node.left.key) < 0)
         return rightRotate(node);
     if (balance < -1 && key.compareTo(node.right.key) > 0)
         return leftRotate(node);
     if (balance > 1 && key.compareTo(node.left.key) > 0) {
         node.left = leftRotate(node.left);
         return rightRotate(node);
     }
     if (balance < -1 && key.compareTo(node.right.key) < 0) {
         node.right = rightRotate(node.right);
         return leftRotate(node);
     }
     return node;
 }

 public void insert(String key) {
     root = insert(root, key);
 }

 public void inorder() {
     inorderTraversal(root);
 }

 private void inorderTraversal(AVLNode node) {
     if (node != null) {
         inorderTraversal(node.left);
         System.out.print(node.key + " ");
         inorderTraversal(node.right);
     }
 }
}

