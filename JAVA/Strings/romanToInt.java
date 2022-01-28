// Problem Link :- https://leetcode.com/problems/triangle/submissions/

class Solution {
    public int romanToInt(String s) {
        int i = 0, j = 0, sum = 0;
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        
        char[] arr = s.toCharArray();
        
        for (i = arr.length-1; i >= 0; i--) {
            char ch = arr[i];
            
            if ((ch == 'V' || ch == 'X') && (i != 0)) {
                sum += map.get(ch);
                
                if ((i != 0) && (arr[i-1] == 'I')) {
                    sum = sum - map.get(arr[i-1]);
                    i--;
                }
            } else if ((ch == 'L' || ch == 'C')) {
                sum += map.get(ch);
                
                if ((i != 0) && (arr[i-1] == 'X')) {
                    sum = sum - map.get(arr[i-1]);
                    i--;
                }
            } else if ((ch == 'D' || ch == 'M') ) {
                sum += map.get(ch);
                
                if ((i != 0) && (arr[i-1] == 'C')) {
                    sum = sum - map.get(arr[i-1]);
                    i--;
                }
            } else {
                sum += map.get(ch);
            }
            
            System.out.println(sum);
        }
        
        return sum;
    }
}
