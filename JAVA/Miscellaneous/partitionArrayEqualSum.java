/*

Given an integer array, partition it into two contiguous subarrays having the same sum of elements and return the index that points to the starting of the second subarray. Return -1 if no partition is possible.

Input : [6, -4, -3, 2, 3]
Output: 2
Explanation: The subarrays [6, -4] and [-3, 2, 3] have equal sum of 2. The second subarray starts from index 2.

Input : [6, -5, 2, -4, 1]
Output: -1
Explanation: No equal sum partition possible.

In case multiple solutions is possible, return the index of the first occurrence. For example,

Input : [1, -1, 1, -1, 1, -1]
Output: 0

*/

class Solution {
	public static int findPartitionIndex(int[] nums) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		
		int i = 0, j = 0, sum = nums[0], len = nums.length;
		int[] pre = new int[len];
		int[] post = new int[len];
		
		pre[0] = nums[0];
		
		for (i = 1; i < nums.length; i++) {
			sum += nums[i];
			pre[i] = sum;
		}
		
		if (sum == 0) {
			return 0;
		}
		
		sum = nums[len-1];
		post[len-1] = nums[len-1];
		
		for (i = len-2; i >= 0; i--) {
			sum += nums[i];
			post[i] = sum;
		}
		
		for (i = 0; i < len-1; i++) {
			if (pre[i] == post[i+1]) {
				return (i+1);
			}
		}
		
		return -1;
	}
}
