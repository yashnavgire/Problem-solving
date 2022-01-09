// Problem Link :- https://leetcode.com/problems/subsets-ii/submissions/

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        solve(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }
    
    public void solve(List<List<Integer>> list, List<Integer> tempList, int[] nums, int itr) {
        
        if (!list.contains(tempList))
            list.add(new ArrayList<>(tempList));
        
        for (int i = itr; i < nums.length; i++) {
            tempList.add(nums[i]);
            solve(list, tempList, nums, i+1);
            tempList.remove(tempList.size()-1);
        } 
        
        return;
    }
}
