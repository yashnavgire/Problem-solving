class Complete{
    
    public static int[] greaterElement (int arr[], int n) {
        int prev = 0, curr = 0, next = 0, cnt= 0 , i = 0, j = 0;
        int[] ans = new int[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        
        for (int ele : arr) {
            pq.add(ele);
        }
        
        // System.out.println(pq.peek());
        
        while (!pq.isEmpty()) {
            curr = pq.poll();
            cnt++;
            if (cnt == 1 && prev == 0) {
                next = -10000000;
                for (i = 0; i < arr.length; i++) {
                    if (arr[i] == curr) {
                        arr[i] = next;
                    }
                }
            }
            else {
                for (i = 0; i < arr.length; i++) {
                    if (arr[i] == curr) {
                        arr[i] = prev;
                    }
                }
            }
            
            prev = curr;
        }
        
        
        return arr;
    }
    
    
}
