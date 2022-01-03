// Problem Link :- https://leetcode.com/problems/two-sum/submissions/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        
        result[0] = 0;
        result[1] = 0;
        
        for (i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        
        return result;
    }
}