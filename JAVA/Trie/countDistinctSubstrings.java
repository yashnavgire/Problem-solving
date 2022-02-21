// Problem Link :- https://www.codingninjas.com/codestudio/problems/count-distinct-substrings_985292?utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_tries_videos&leftPanelTab=1 

import java.util.*;

class Node {
    Node[] list;
    Boolean flag;
    
    public Node() {
        list = new Node[26];
        flag = false;
    }
    
    public Boolean containsKey(char ch) {
        if (getNode(ch) != null) {
            return true;
        }
        
        return false;
    }
    
    public void put(char ch, Node node) {
        list[ch - 'a'] = node;
        return;
    }
    
    public Node getNode(char ch) {
        return list[ch - 'a'];
    }
}

public class Solution 
{

	public static int countDistinctSubstrings(String s) {
		int i = 0, j = 0, times = 0;
        Node root = new Node();
        Node tempRoot = root;
        
        for (i = 0 ; i < s.length(); i++) {
            tempRoot = root;
            for (j = i ; j < s.length(); j++) {
                char ch = s.charAt(j);
                if (!tempRoot.containsKey(ch)) {
                    Node node = new Node();
                    tempRoot.put(ch, node);
                    times++;
                }
                
                tempRoot = tempRoot.getNode(ch);
            }
        }
        
        return times+1;
	}
}
