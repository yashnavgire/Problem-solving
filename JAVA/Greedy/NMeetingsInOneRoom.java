class Meeting {
    int start;
    int end;
    int pos;
    
    public Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class meetingComparator implements Comparator<Meeting> {
    @Override
    public int compare(Meeting o1, Meeting o2) {
        if (o1.end > o2.end) {
            return 1;
        } else if (o1.end < o2.end) {
            return -1;
        } else {
            return 0;
        }
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        int i = 0, meets = 0;
        List<Meeting> list = new ArrayList<>();
        
        for (i = 0; i < start.length; i++) {
            list.add(new Meeting(start[i], end[i], i + 1));
        }
        
        meetingComparator mc = new meetingComparator();
        Collections.sort(list, mc);
        
        int prev = list.get(0).start;
        
        for (i = 1; i < list.size(); i++) {
            if (list.get(i).end > prev) {
                meets++;
                prev = list.get(i).start;
                // ans.add(list.get(i).pos);
            }
        }
        
        return meets;
    }
}
