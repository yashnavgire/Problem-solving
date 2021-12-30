// Problem Link :- https://leetcode.com/problems/merge-intervals/submissions/

class Solution {
        public int[][] merge(int[][] intervals) {
            int start = 0, end = 0, times = 0, prev_start = 0, prev_end = 0;
            List<int[]> list = new ArrayList<>();
            
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
            
            prev_start = intervals[0][0];
            prev_end = intervals[0][1];
            
            for (int[] ele : intervals) {
            
                if (ele[0] <= prev_end) {
                    prev_end = Math.max(ele[1], prev_end);
                }
                else {
                    list.add(new int[]{prev_start, prev_end});
                    prev_start = ele[0];
                    prev_end = ele[1];
                }
            }
            
            list.add(new int[]{prev_start, prev_end});
            
            return list.toArray(new int[0][]);
        }
    }