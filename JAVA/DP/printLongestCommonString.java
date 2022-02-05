/*

Given two strings, find the longest string that is a substring of both strings.

Input: X = "ABABC", Y = "BABCA"
Output: "BABC"
Explanation: The longest common substring of strings "ABABC" and "BABCA" is "BABC" having length 4. The other common substrings are "ABC", "A", "AB", "B", "BA", "BC", and "C".

*/

class Solution
{
	public static String findLongestCommonSubstring(String X, String Y) {
		int i = 0, j = 0, endingIndex = 0, xlen = X.length(), ylen = Y.length(), maxLen = 0;
		int[][] dp = new int[xlen+1][ylen+1];
		
		for (i = 1; i < xlen+1; i++) {
			for (j = 1; j < ylen+1; j++) {
				if (X.charAt(i-1) == Y.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
					
					if (dp[i][j] > maxLen) {
						maxLen = dp[i][j];
						endingIndex = i;
					}
				}
			}
		}
		
		return X.substring(endingIndex-maxLen, endingIndex);
	}
}
