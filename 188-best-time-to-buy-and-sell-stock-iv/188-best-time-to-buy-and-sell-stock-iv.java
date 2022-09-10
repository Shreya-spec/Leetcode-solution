class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0) {
            return 0;
        }
        
        // buy[i]: min cost at (i + 1)-th time stock purchased
        int[] buy = new int[k]; 
        
        // sell[i]: max revenue at (i + 1)-th time stock sold
        int[] sell = new int[k]; 
        
        Arrays.fill(buy, Integer.MIN_VALUE);
        Arrays.fill(sell, 0);
        
        for (int price : prices) {
            buy[0] = Math.max(buy[0], price * -1);
            sell[0] = Math.max(sell[0], buy[0] + price);
            // The i-th time buy & sell depens on the (i - 1)-th time buy & sell
            for (int j = 1; j < k; j++) { 
                buy[j] = Math.max(buy[j], sell[j - 1] - price);
                sell[j] = Math.max(sell[j], buy[j] + price);
            }
        }
        return sell[k - 1];
    }
}