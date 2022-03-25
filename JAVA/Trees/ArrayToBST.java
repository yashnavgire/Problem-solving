class Solution
{
    public int[] sortedArrayToBST(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        int[] ans = new int[nums.length];
        
        preorder(nums, 0, nums.length - 1, list);
        
        for (int i = 0; i < nums.length; i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
    
    public void preorder(int[] nums, int s, int e, ArrayList<Integer> list) {
        if (s > e) {
            return;
        }
        
        int mid = (s + e) / 2;
        list.add(nums[mid]);
        preorder(nums, s, mid - 1, list);
        preorder(nums, mid + 1, e, list);
    }
}
