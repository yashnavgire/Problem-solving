// Problem Link :- https://www.codingninjas.com/codestudio/problems/unique-element-in-sorted-array_1112654?topList=striver-sde-sheet-problems&leftPanelTab=1

import java.util.*;

public class Solution 
{
    public static int uniqueElement(ArrayList<Integer> arr) {
        int ans = 0;
        Collections.sort(arr);
        
        for (int i = 0; i < arr.size(); i++) {
            ans = ans ^ arr.get(i);
        }
        
        return ans;
    }
}
