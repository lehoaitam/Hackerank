package Implementation.Easy;

public class MyLinkedList {
    public static void main(String[] args){
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.head = new LLNode(1);
    }
    public MyLinkedList(){
        head = null;
    }
    public LLNode head;

}
class LLNode{
    public int val;
    public LLNode next;
    public LLNode(){next = null;}
    public LLNode(int val){this.val = val;}
}
