class Solution {
	int getKthElement(int[] firstArr, int[] secondArr, int k) {
	   	int i = 0, j = 0, idx = 0;
		int[] ans = new int[firstArr.length + secondArr.length];
		
		while (i < firstArr.length && j < secondArr.length) {
			if (firstArr[i] < secondArr[j]) {
				ans[idx++] = firstArr[i];
				i++;
			} else if (firstArr[i] >= secondArr[j]) {
				ans[idx++] = secondArr[j];
				j++;
			}
		}
		
		while (i < firstArr.length) {
			ans[idx++] = firstArr[i];
			i++;
		}
		
		while (j < secondArr.length) {
			ans[idx++] = secondArr[j];
			j++;
		}
		
		return ans[k - 1];
	}
}
