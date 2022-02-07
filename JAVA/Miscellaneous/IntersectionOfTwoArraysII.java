// Problem Link :- https://leetcode.com/problems/intersection-of-two-arrays-ii/submissions/

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        while (i <= nums1.length-1 && j <= nums2.length-1) {
            
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }
        
        int[] ans = new int[list.size()];
        
        for (i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        
        return ans;
    }
}
