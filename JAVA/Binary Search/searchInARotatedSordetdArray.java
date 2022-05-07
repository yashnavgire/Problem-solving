class Solution {
	int getElementIndex(int[] arr, int target) {
	    int start = 0, end = arr.length - 1, mid = 0;
		
		int begin = solve(arr);
	
		// System.out.println("idx" + " " + begin);
		
		if (target == arr[begin]) {
			return begin;
		} else if (target <= arr[begin - 1] && target >= arr[start]) {
			return search(arr, 0, begin - 1, target);
		} else {
			return search(arr, begin, end, target);
		}
	}
	
	int solve(int[] arr) {
		int low = 0, mid = 0, high = arr.length - 1;
		
		while (low <= high) {
			mid = low + (high - low) / 2;
			//System.out.println("MId" + mid);
			
			if (mid > 0 && mid < high && arr[mid] < arr[mid - 1] && arr[mid] < arr[mid + 1]) {
				return mid;
			} else if (arr[mid] > arr[high]) {
				low = mid + 1;
			}
			else {
				high = mid;
			}
		}
		
		return -1;
	}
	
	int search(int[] arr, int start, int end, int target) {
		int mid = 0;
		
		while (start <= end) {
			mid = start + (end - start) / 2;
			
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				end--;
			}
			else {
				start++;
			}
		}
		
		return -1;
	}
}
