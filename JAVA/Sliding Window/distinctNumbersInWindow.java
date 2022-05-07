class Solution {
	int[] distintNumbersInWindow(int[] A, int k) {
		
	    int i = 0, j = 0, m = 0;
		Set<Integer> set = new HashSet<>();
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		int[] ans = new int[A.length - k + 1];
		
		while (j <= A.length - 1) {
			if (!map.containsKey(A[j])) {
				map.put(A[j], 1);
			}
			else {
				map.put(A[j], map.get(A[j]) + 1);
			}
			
			if ((j - i + 1) < k) {
				j++;
			}
			else if((j - i + 1) == k) {
				list.add(map.size());
				ans[m++] = map.size();
				if (map.get(A[i]) == 1) {
					map.remove(A[i]);
				}
				else {
					map.put(A[i], map.get(A[i]) - 1);
				}
				
				i++;
				j++;
			}
		}
		
		return ans;
	}
}
