// Problem Link :- https://leetcode.com/problems/contains-duplicate/submissions/

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for (int ele : nums) {
            if (!set.contains(ele)) {
                set.add(ele);
            }
            else {
                return true;
            }
        }
        
        return false;
    }
}
