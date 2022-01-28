// Problem Link :- https://leetcode.com/problems/guess-number-higher-or-lower/submissions/

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is lower than the guess number
 *			      1 if num is higher than the guess number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int start = 1, end = n, mid = 0, guessed_no = 0;
        
        while (start <= end) {
            mid = start + (end - start)/2;
            
            guessed_no = guess(mid);
            
            if (guessed_no == 0) {
                break;
            } else if (guessed_no == 1) {
                start = mid + 1;
            } else if (guessed_no == -1) {
                end = mid - 1;
            }
        }
        
        return mid;
    }
}
