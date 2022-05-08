/* This is the JewelStone class definition
class JewelStone {
    int weight, value;
    JewelStone(int weight, int value) {
        this.weight = weight;
        this.value = value;
    }
}
*/
class Solution {
	int getMaxValue (JewelStone[] stones, int capacity) {
		int[][] dp = new int[stones.length + 1][capacity + 1];
		
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		
		return solve(stones, dp, 0, capacity);
	}
	
	int solve(JewelStone[] stones, int[][] dp, int idx, int capacity) {
		if (idx >= stones.length) {
			return 0;
		}
		
		if (dp[idx][capacity] != -1) {
			return dp[idx][capacity];
		}
		
		if (stones[idx].weight <= capacity) {
			return dp[idx][capacity] = Math.max(stones[idx].value + solve(stones, dp, idx + 1, capacity - stones[idx].weight), solve(stones, dp, idx + 1, capacity));
		}
		
		return dp[idx][capacity] = solve(stones, dp, idx + 1, capacity);
	}
}
