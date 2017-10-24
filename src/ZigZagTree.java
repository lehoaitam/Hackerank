import java.util.*;

public class ZigZagTree {
    public static void main(String[] args){
        Tree tree = new Tree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.root.left.left.left = new Node(8);
        tree.root.left.left.right = new Node(9);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(11);

        tree.root.right.left.left = new Node(12);
        tree.root.right.left.right = new Node(13);
        tree.root.right.right.left = new Node(14);
        tree.root.right.right.right = new Node(15);
        Stack<Node> list = new Stack<>();
        list.add(tree.root);
        reverseZigZag(list, 1);
    }
    public static void reverseZigZag(Stack<Node> stack, int flip){
        if(stack == null || stack.isEmpty()) return;
        Stack<Node> stackTemp = new Stack<>();
        while(!stack.isEmpty()){
            Node n = stack.pop();
            System.out.print(n.value + " ");
            if(flip > 0){
                if(n.left != null) stackTemp.push(n.left);
                if(n.right != null) stackTemp.push(n.right);
            } else{
                if(n.right != null) stackTemp.push(n.right);
                if(n.left != null) stackTemp.push(n.left);
            }
        }
        stack.addAll(stackTemp);
        flip *= -1;
        reverseZigZag(stack, flip);

    }

    public static void dfs(Node root){
        if(root == null) return;
        System.out.print(root.value + " ");
        dfs(root.left);
        dfs(root.right);


    }
    public static void Lbfs(Node root){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node n = queue.poll();
            System.out.print(n.value + " ");
            if(n.left != null) queue.add(n.left);
            if(n.right != null) queue.add(n.right);
        }
    }
    public static class Tree{
        Node root;
    }
    public static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }
}
