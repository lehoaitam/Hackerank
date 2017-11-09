import java.io.File;
import java.util.Comparator;
import java.util.Scanner;

public class Trie {

    TrieNode root;
    Trie(){
        root = new TrieNode();
    }
    class TrieNode{
        int val;
        boolean isEndWord;
        TrieNode[] child;
        public TrieNode(){
            val = 0;
            isEndWord = false;
            child = new TrieNode[26];
            for(int i=0; i < 26; i++)
                child[i] = null;
        }
    }
    public void insert(String word){
        TrieNode n = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(n.child[index] == null)
                n.child[index] = new TrieNode();
            n.child[index].val++;
            n = n.child[index];
        }
        n.isEndWord = true;
    }
    public int searchPrefixCount(String word){
        TrieNode n = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(n.child[index] == null)
                return 0;
            n = n.child[index];
        }
        return n.val;
    }

    public static void main(String[] args) {
        Scanner in = null;
        try {
            in = new Scanner(new File("./resource/Trie/test"));
        } catch (Exception e) {
            e.printStackTrace();
        }
//        Scanner in = new Scanner(System.in);
        Trie trie = new Trie();
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            switch(op){
                case "add":
                    trie.insert(contact);
                    break;
                case "find":
                    System.out.println(trie.searchPrefixCount(contact));
                    break;
            }
        }
    }

}
