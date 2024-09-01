import java.util.Scanner;
import java.util.LinkedList;
import java.util.Queue;
public class Tree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static class BinaryTree {
        public static Node buildTree(Node root) {
            char op;
            Scanner sc = new Scanner(System.in);
            System.out.println("Does the element " + root.data + " have left child(Y/N):");
            op = sc.next().charAt(0);
            if (op == 'Y') {
                System.out.println("Enter the element:");
                int val = sc.nextInt();
                Node newnode = new Node(val);
                root.left = buildTree(newnode);
            } 

            System.out.println("Does the element " + root.data + " have right child(Y/N):");
            op = sc.next().charAt(0);
            if (op == 'Y') {
                System.out.println("Enter the element:");
                int val = sc.nextInt();
                Node newnode = new Node(val);
                root.right = buildTree(newnode);
            } 

            return root;
        }

        public static void preorder(Node root) {
            if (root == null) {
                return;
            }
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        public static void postorder(Node root) {
            if (root == null) {
                return;
            }
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }

        public static void inorder(Node root) {
            if (root == null) {
                return;
            }
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
        
        public static void levelorder(Node root) {
            Queue<Node> q = new LinkedList<>();
            q.offer(root);
            q.offer(null);
            while (!q.isEmpty()) {
                Node val = q.poll();
                if (val == null) {
                   System.out.println();
                   if (q.isEmpty()) {
                      break;
                   } else 
                      q.offer(null);
                } else {
                   System.out.print(val.data + " ");
                   if (val.left != null) {
                      q.offer(val.left);
                   } 
                   if (val.right != null) {
                      q.offer(val.right);
                   }
                }
            }
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root element:");
        int val = sc.nextInt();
        Node root = new Node(val);
        root = BinaryTree.buildTree(root);

        //traversals
        System.out.print("Preorder traversal :");
        BinaryTree.preorder(root);
        System.out.println();
        System.out.print("Postorder traversal :");
        BinaryTree.postorder(root);
        System.out.println();
        System.out.print("Inorder traversal :");
        BinaryTree.inorder(root);
        System.out.println();
        System.out.print("Levelorder traversal :\n");
        BinaryTree.levelorder(root);
    }
}
