package Implementation.Easy;

import java.util.Stack;

public class MyLinkedList {
    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.head = new LLNode(1);
        linkedList.head.next = new LLNode(2);
        linkedList.head.next.next = new LLNode(3);
        linkedList.head.next.next.next = new LLNode(4);
        linkedList.print(linkedList.head);
        LLNode newHead = linkedList.reverseByStack();
        linkedList.print(newHead);
        LLNode newHead2 = linkedList.reverse();
        linkedList.print(newHead2);
    }
    public MyLinkedList(){
        head = null;
    }
    public void print(LLNode head){
        LLNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " > ");
            temp = temp.next;
        }
        System.out.println();
    }
    public LLNode reverseByStack(){
        Stack<LLNode> stack = new Stack<>();
        LLNode temp = head;
        while(temp != null){
            stack.push(temp);
            temp = temp.next;
        }
        LLNode newHead = stack.pop();
        temp = newHead;
        while(!stack.isEmpty()){
            LLNode node = stack.pop();
            temp.next = node;
            temp = node;
        }
        temp.next = null;
        head = newHead;
        return newHead;
    }
    public LLNode reverse(){
        LLNode previous = null;
        LLNode next = null;
        LLNode current = head;
        while(current !=  null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public LLNode head;

}
class LLNode{
    public int val;
    public LLNode next;
    public LLNode(){next = null;}
    public LLNode(int val){this.val = val;}
}
