class Solution {
    public int minimumRounds(int[] tasks) {
        int i = 0, prev = 0, curr = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int ele : tasks) {
            if (!map.containsKey(ele)) {
                map.put(ele, 1);
            }
            else {
                map.put(ele, map.get(ele) + 1);
            }
        }
        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            int key = e.getKey();
            int val = e.getValue();
            
            if (val == 1) {
                return -1;
            }
            
            if (val < 3) {
                ans++;
            }
            else if (val >= 3) {
                while (val > 0) {
                    val = val - 3;
                    ans++;
                }
            }
        }
        
        return ans;
        
    }
}
