/*
https://leetcode.com/problems/insert-interval/

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.

Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

Return intervals after the insertion.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
*/


class Solution {
public:
    vector<vector<int>> insert(vector<vector<int>>& intervals, vector<int>& newInterval) {
        //3 scenarios
        // Non-overlap of new interval at beginning
        // Overlap of new interval with given list of intervals
        // Non-overlap of new interval at end

        int n = intervals.size(), i = 0;
        vector<vector<int>> res;
        //case 1: no overlapping case before the merge intervals
		//compare ending point of intervals to starting point of newInterval
        while(i < n && intervals[i][1] < newInterval[0]){
            res.push_back(intervals[i]);
            i++;
        }                           
		//case 2: overlapping case and merging of intervals
        while(i < n && newInterval[1] >= intervals[i][0]){
            newInterval[0] = min(newInterval[0], intervals[i][0]);
            newInterval[1] = max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.push_back(newInterval);
        // case 3: no overlapping of intervals after newinterval being merged
        while(i < n){
            res.push_back(intervals[i]);
            i++;
        }
        return res;
        
    }
};

/*

intervals = [[1,3], [6,9]]
newInterval = [2, 5]
o/p = [[1,5], [6,9]]

intervals = [[1,3], [6,9]]
newInterval = [10, 11]
o/p = [[1,5], [6,9], [10, 11]]

intervals = [[1,3], [6,9]]
newInterval = [-2, 0]
o/p = [[-2, 0], [1,5], [6,9]]

intervals = [[1,3], [6,9]]
newInterval = [0, 2]
o/p = [[0,3], [6,9]]

intervals = [[1,3], [6,9]]
newInterval = [7, 10]
o/p = [[1,5], [6,10]]

intervals = [[1,3], [4,5] [10,12]]
newInterval = [2, 11]
o/p = [[1,12]]

*/
