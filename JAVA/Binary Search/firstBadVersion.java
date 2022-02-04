// link :- https://leetcode.com/problems/first-bad-version/submissions/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int badVersion = 0, start = 1, mid = 0, end = n, lastSeen = 0, index = 0;
        
        while (start < end) {
            mid = start + (end - start)/2;
            
            if (isBadVersion(mid)) {
                end = mid;
            }
            else {
                start = mid + 1;   
            }
        }
        
        return start;
    }
}
