// Problem Link :- https://www.codingninjas.com/codestudio/problems/implement-trie_1387095?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=1

class Node {
    Node[] list;
    int prefix;
    int end;
    
    public Node() {
    	list = new Node[26];
        prefix = 0;
        end = 0;
    }
    
    public Boolean containsKey(char ch) {
        if (getNode(ch) != null) {
            return true;
        }
        
        return false;
    }
    
    public void putNode(char ch, Node node) {
        list[ch - 'a'] = node;
        return;
    }
    
    public void increasePrefix() {
        prefix++;
    }
    
    public void decreasePrefix() {
        prefix--;
    }
    
    public void increaseEnd() {
        end++;
    }
    
    public void decreaseEnd() {
        end--;
    }
    
    public Node getNode(char ch) {
        return list[ch - 'a'];
    }
    
    public int getPrefix() {
        return prefix;
    }
    
    public int getEnd() {
        return end;
    }
}

public class Trie {
    public Node root;
    
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (!node.containsKey(ch)) {
                Node trieNode = new Node();
                node.putNode(ch, trieNode);
            }
            
            node = node.getNode(ch);
            node.increasePrefix();
        }
        
        node.increaseEnd();
        return;
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (node.containsKey(ch)) {
                node = node.getNode(ch);
            }
            else {
                return 0;
            }
        }
        
        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (node.containsKey(ch)) {
                node = node.getNode(ch);
            }
            else {
                return 0;
            }
        }
        
        return node.getPrefix();
    }

    public void erase(String word) {
        Node node = root;
        
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            
            if (node.containsKey(ch)) {
                node = node.getNode(ch);
                node.decreasePrefix();
            }
            else {
                return;
            }
        }
        
        node.decreaseEnd();
        
        return;
    }

}
