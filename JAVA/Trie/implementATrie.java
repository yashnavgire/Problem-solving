import java.util.*;

class Node {
    Node[] list;
    Boolean flag;
    
    public Node() {
        list = new Node[26];
        flag = false;
    }
    
    public void insertChar(char ch, Node node) {
        list[ch - 'a'] = node;
        return;
    }
    
    public Boolean containsKey(char ch) {
        if (getNode(ch) != null) {
            return true;
        }
        
        return false;
    }
    
    public Node getNode(char ch) {
        return list[ch - 'a'];
    }
    
    public void setEnd() {
        flag = true;
    }
    
    public Boolean getEnd() {
        return flag;
    }
}

public class Trie {

    //Initialize your data structure here
    public static Node root;
    
    Trie() {
        root = new Node();
    }

    //Inserts a word into the trie

    public static void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
        
            if (!node.containsKey(ch)) {
                Node trieNode = new Node();
                node.insertChar(ch, trieNode);
            }
            
            node  = node.getNode(ch);
        }
        
        node.setEnd();
    }
    
    //Returns if the word is in the trie
    public static boolean search(String word) {
        Node node = root;
    	
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (!node.containsKey(ch)) {
                return false;
            }
            
            node = node.getNode(ch);
        }
        
        if (node.getEnd()) {
            return true;
        }
        
        return false;
    }

    //Returns if there is any word in the trie that starts with the given prefix
    public static boolean startsWith(String word) {
        Node node = root;
    	
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (!node.containsKey(ch)) {
                return false;
            }
            
            node = node.getNode(ch);
        }
        
        return true;
    }
}
