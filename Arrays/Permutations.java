// Problem Link :- https://leetcode.com/problems/permutations/submissions/ 

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>list = new ArrayList<>();
        
        backTrack(list, new ArrayList<>(), nums, 0);
        
        return list;
    }
    
    public void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!tempList.contains(nums[i])) {
                tempList.add(nums[i]);
                backTrack(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
