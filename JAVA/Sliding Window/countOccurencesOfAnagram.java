// Problem Link :- https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1#

class Solution {

    int search(String pat, String txt) {
        int i = 0, j = 0, K = pat.length(), sum = 0, ret = 0;
        
        int[] arr = new int[26];
        int[] ans = new int[26];
        
        for (i = 0; i < pat.length(); i++) {
            arr[pat.charAt(i) - 'a']++;
        }
        
        i = 0;
        j = 0;
        
        while (j < txt.length()) {
            //System.out.println(j);
            
            if (Math.abs(j - i) + 1 < K) {
                char ch = txt.charAt(j);
                //System.out.println(ch);
                ans[ch - 'a']++;
                j++;    
            } else if (Math.abs(j - i) + 1 == K) {
                System.out.println(Math.abs(j - i) + 1 + " " + txt.substring(i, j + 1));
                int flag = 0;
                
                for (int m = 0; m < ans.length; m++) {
                    System.out.print(ans[m]);
                    System.out.print(arr[m]);
                    
                    if (arr[m] != ans[m]) {
                        
                        flag = 1;
                        //break;
                    }
                }
                System.out.println("");
                
                if (flag == 0) {
                    ret++;
                    flag = 0;
                }
                
                char ch = txt.charAt(i);
                ans[ch - 'a']--;
                i++;
                j++;
            }
        }
        
        return ret;
    }
}
