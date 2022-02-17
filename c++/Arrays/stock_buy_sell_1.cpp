class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int max = 0;
        int buy = INT_MAX;
        
        for(int i=0;i<prices.size();i++){
            if((prices[i] - buy) > max)
                max = prices[i] - buy;
                
            if(prices[i] < buy){
                buy = prices[i];
            }
        }
        
        return max;
    }
};
