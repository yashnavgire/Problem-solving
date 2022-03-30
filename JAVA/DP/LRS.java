// longest Repetitive Subsequence

/*

Given a sequence, find the length of the longest subsequence of it that occurs at least twice where the repeated characters should holds a different index in the sequence.

Input: 'ATACTCGGA'
Output: 4
Explanation: The longest repeating subsequence is 'ATCG', having length 4.

'A' 'T'  A  'C'  T   C  'G'  G   A
 A   T  'A'  C  'T' 'C'  G  'G'  A

Input: 'YBYXBXBB'
Output: 5
Explanation: The longest repeating subsequence is 'YBXBB', having length 5.

'Y' 'B'  Y  'X' 'B'  X  'B'  B
 Y   B  'Y'  X  'B' 'X' 'B' 'B'

*/

class Solution
{
	public static int findLRSLength(String s)
	{
		int m = s.length();
		int[][] dp = new int[m + 1][m + 1];
		
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= s.length(); j++) {
				if (s.charAt(i-1) == s.charAt(j-1) && i != j) {
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		return dp[m][m];
	}
	
	public static int solve(int[][] dp, String s, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}
		
		if (dp[m][n] != -1) {
			return dp[m][n];
		}
		
		if (s.charAt(m - 1) == s.charAt(n - 1) && m != n) {
			dp[m][n] = 1 + solve(dp, s, m - 1, n - 1);
			return dp[m][n];
		}
		
		dp[m][n] = Math.max(solve(dp, s, m - 1, n), solve(dp, s, m, n - 1));
		
		return dp[m][n]; 
	}
}
