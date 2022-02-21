// Problem Link :- https://www.codingninjas.com/codestudio/problems/maximum-xor_973113?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=1

import java.util.*;

class Node {
	Node[] list;
    
    public Node() {
        list = new Node[2];
    }
    
    public Boolean containsKey(int bit) {
        if (getNode(bit) != null) {
            return true;
        }
        
        return false;
    }
    
    public void put(int bit, Node node) {
        list[bit] = node;
        return;
    }
    
    public Node getNode(int bit) {
        return list[bit];
    }
}

class Trie {
    private static Node root;
    
    public Trie() {
        root = new Node();
    }
    
    public static void insert(int num) {
        Node node = root;
        
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            
            node = node.getNode(bit);
        }
    }
    
    public int getMaxXor(int num) {
        Node node = root;
        int maxNum = 0;
        
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            
            if (node.containsKey(1-bit)) {
                maxNum = maxNum | (1<<i);
                node = node.getNode(1 - bit);
            }
            else {
                node = node.getNode(bit);
            }
        }
        
        return maxNum;
    }
}

public class Solution  {

	public static int maxXOR(int n, int m, ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
	    int i = 0, max = 0;
        Trie trie = new Trie();
        
        for (i = 0 ; i < arr1.size(); i++) {
            trie.insert(arr1.get(i));
        }
        
        for (i = 0; i < arr2.size(); i++) {
            max = Math.max(max, trie.getMaxXor(arr2.get(i)));
        }
        
        return max;
	}
}
