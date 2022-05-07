class Solution {
	int[] distintNumbersInWindow(int[] A, int k) {
		
	    int i = 0, j = 0;
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		
		while (j <= A.length - 1) {
			if (!map.containsKey(A[j])) {
				map.put(A[j], 1);
			}
			else {
				map.put(A[j], map.get(A[j]) + 1);
			}
			// set.add(A[j]);
			if ((j - i + 1) < k) {
				j++;
			}
			else if((j - i + 1) == k) {
				list.add(map.size());
				if (map.get(A[i]) == 1) {
					map.remove(A[i]);
				}
				else {
					map.put(A[i], map.get(A[i]) - 1);
				}
				// set.remove(A[i]);
				i++;
				j++;
			}
		}
    
		int[] ans = new int[list.size()];
		
		for (i = 0; i < list.size(); i++) {
			ans[i] = list.get(i);
		}
		
		return ans;
	}
}
