// Problem Link :- https://leetcode.com/problems/non-overlapping-intervals/submissions/

class interval {
    int start;
    int end;
    
    public static final Comparator<interval> intevalComp = new Comparator<interval>() {
        @Override
        public int compare(interval o1, interval o2) {
            return o1.end - o2.end;  
        }
    };
    
    public interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return 0;
        }
        
        int i = 0, j = 0, start = intervals[0][0], end = intervals[0][1], odd = 1;
        List<interval> list = new ArrayList<>();
        
        for (int[] ele : intervals) {
            list.add(new interval(ele[0], ele[1]));
        }
        
        Collections.sort(list, interval.intevalComp);
        
        for (i = 1; i < list.size(); i++) {
            
            if(list.get(i).start >=  list.get(j).end) {
                end = list.get(i).end;
                j = i;
                odd++;
            }
        }
    
        return intervals.length - odd;
    }
}
