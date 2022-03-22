class StockSpanner {
    Stack<int[]> st;
    
    public StockSpanner() {
        st = new Stack<>();    
    }
    
    public int next(int price) {
        int num = 1;
        
        if (st.isEmpty()) {
            // System.out.println("Here");
            st.push(new int[]{price, num});
        }
        else {
            if (st.peek()[0] > price) {
                st.push(new int[]{price, num});
            }
            else {
                while (!st.isEmpty() && st.peek()[0] <= price) {
                    num = num + st.pop()[1];
                }
                
                st.push(new int[] {price, num});
            }
        }
        
        return num;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
