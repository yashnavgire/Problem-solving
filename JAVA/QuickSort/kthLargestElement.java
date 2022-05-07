// The present solution is a quick select algorithm
// It can be enhanced to kth smallest by just passing k instead of k - len + 1

class Solution {
	int getKthLargestElement(int[] list, int k) {
		int len = list.length;
		if (k < 0 || k > len) {
			return -1;
		}
	    return solve(list, 0, list.length - 1, len - k + 1);
	}
	
	int solve(int[] list, int low, int high, int k) {
		int part = 0;
		
		part = partition(list, low, high);
		
		if (part == k - 1) {
			return list[part];
		}
		else if (part > k - 1) {
			return solve(list, 0, part - 1, k);
		}
		else {
			return solve(list, part + 1, high, k);
		}
	}
	
	int partition(int[] arr, int low, int high) {
		int pivot = arr[high];
		int pl = low;
		
		for (int i = low; i <= high; i++) {
			if (arr[i] < pivot) {
				int temp = arr[i];
				arr[i] = arr[pl];
				arr[pl] = temp;
				pl++;
			}
		}
		
		int temp = arr[high];
		arr[high] = arr[pl];
		arr[pl] = temp;
		
		return pl;
	}
}
