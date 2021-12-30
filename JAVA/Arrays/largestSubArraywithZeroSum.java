// Your code here
        HashMap<Integer , Integer> map = new HashMap<>();
        
        int curSum = 0 , max = 0;
        for(int i = 0; i<n; i++){
            curSum += arr[i];
            
            if(curSum == 0){
                max = i + 1;
            }
            
            if(map.containsKey(curSum)){
                
                int temp = i - map.get(curSum);
                max = Math.max(max , temp);
            }
            else map.put(curSum , i);
            
        }
        return max;
