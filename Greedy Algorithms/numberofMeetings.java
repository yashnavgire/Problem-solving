// Problem Link :- https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1

class MeetingSorter implements Comparator<Meeting> {
    
    @Override
    public int compare(Meeting m1, Meeting m2) {
        if (m1.end < m2.end) {
            return -1;
        }
        else if (m1.end > m2.end) {
            return 1;
        }
        else {
            return 0;
        }
    }
}

class Meeting {
    int start;
    int end;
    int pos;
    
    Meeting(int start, int end, int pos) {
        this.start = start;
        this.end = end;
        this.pos = pos;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n) {
        int i = 0, j = 0, c = 1;
        
        //List<Integer> list = new ArrayList<>();
        List<Meeting> meet = new ArrayList<>();
        
        MeetingSorter ms = new MeetingSorter();
        
        for (i = 0; i  < start.length; i++) {
            meet.add(new Meeting(start[i], end[i], i + 1));
        }
        
        Collections.sort(meet, ms);
        
        //list.add(meet.get(0).pos);
        
        int prev_end = meet.get(0).end;
        
        for (i = 1; i < meet.size(); i++) {
            if (meet.get(i).start > prev_end) {
                //list.add(meet.get(i).pos);
                prev_end = meet.get(i).end;
                c++;
            }
        }
        
        return c; 
        
    }
}
