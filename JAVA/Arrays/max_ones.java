class Solution {
	int getMaxConsecutiveOnes(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		
	    int i = 0, j = 0, max_len = Integer.MIN_VALUE, len = 0;
		
		for (i = 0; i < A.length; i++) {
			if (A[i] == 1) {
				len++;
			}
			else {
				max_len = Math.max(max_len, len);
				len = 0;
			}
		}
		
		return Math.max(max_len, len);
	}
}
