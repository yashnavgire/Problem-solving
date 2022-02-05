/*

Given a sequence, find the longest subsequences of it that is also a palindrome.

Input: "ABBDCACB"
Output: 5
Explanation: The longest palindromic subsequence is "BCACB", having length 5.

*/

class Solution
{
	public static int findLPSLength(String s) {
		int i = 0, j = 0, xlen = s.length(), ylen = s.length();
		StringBuffer sb = new StringBuffer(s);
		String Y = sb.reverse().toString();
	
		int[][]dp = new int[xlen+1][ylen+1];
		
		for (i = 1; i < xlen+1; i++) {
			for (j  = 1; j < ylen+1; j++) {
				if (s.charAt(i-1) == Y.charAt(j-1)) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		
		return dp[xlen][ylen];
	}
}
