class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        for (int ele : stones) {
            pq.add(ele);
        }
        
        while (!pq.isEmpty() && pq.size() >=2) {
            int ele1 = pq.poll();
            int ele2 = pq.poll();
            
            if (ele1 != ele2) {
                pq.add(ele1 - ele2);
            }
        }
        
        if (pq.size() > 0) {
            return pq.poll();
        }
        else {
            return 0;
        }
        
    }
}
