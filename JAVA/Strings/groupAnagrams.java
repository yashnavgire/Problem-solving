// Problem Link :- https://leetcode.com/problems/group-anagrams/submissions/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int i = 0, j = 0;
        List<List<String>> ret = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        
        for (i = 0; i < strs.length; i++) {
            String word = strs[i];
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            
            if (!map.containsKey(s)) {
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(s, list);
            } 
            else {
                List<String> list = map.get(s);
                list.add(word);
                map.put(s, list);
            }
        }
        
        for (Map.Entry ele : map.entrySet()) {
            String key = (String)ele.getKey();
            List<String> tempList = (List<String>)ele.getValue();
            ret.add(tempList);
        }
        
        return ret; 
    }
}
