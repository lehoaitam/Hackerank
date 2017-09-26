package Implementation.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    public static void main(String[] args){
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.root = new BTNode(0);
        binaryTree.root.left = new BTNode(1);
        binaryTree.root.left.left = new BTNode(2);
        binaryTree.root.left.right = new BTNode(3);
        binaryTree.root.left.right.right = new BTNode(4);
        System.out.println("height by recursive : " + binaryTree.height(binaryTree.root));
        System.out.println("height by iterative : " + binaryTree.height_iterative(binaryTree.root));
    }
    public BinaryTree(){
        root = null;
    }
    public int height(BTNode root){
        if(root == null)return 0;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return leftHeight > rightHeight ? 1 + leftHeight : 1 + rightHeight;
    }

    public int height_iterative(BTNode root){
        if(root == null) return 0;
        Queue<BTNode> queue = new LinkedList<>();
        queue.add(root);
        int height = 0;
        do{
            int size = queue.size();
            height = size > 0 ? height + 1 : height;
            while(size > 0){
                BTNode temp = queue.poll();
                if(temp.left != null)queue.add(temp.left);
                if(temp.right != null)queue.add(temp.right);
                size--;
            }
        }while(!queue.isEmpty());
        return height;
    }


    BTNode root;

}
class BTNode{
    public int value;
    public BTNode left;
    public BTNode right;
    public BTNode(int value){
        this.value = value;
        left = right = null;
    }
}
