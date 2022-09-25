class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int prices[]=new int[n];
        Arrays.fill(prices,Integer.MAX_VALUE);
        prices[src]=0;
        int i=0;
        int[]tempPrices=prices.clone();
        while(i++<=k)
        {
            //the tempcost array will be same as original cost array initially
            tempPrices=prices.clone();
            //iterate through all the edges, since in bellman ford we have to iterate all the edges
            for(int[]flight:flights)
            {
                int s=flight[0];
                int d=flight[1];
                int c=flight[2];
                //if the cost of the current node is infinity then do not explore its neighbors 
                //since the cost of neighbors will still be infinity
                if(prices[s]==Integer.MAX_VALUE)
                    continue;
                //if the cost of the destination node d is lesser by going through the node s,
                //then update the tempcost array
                if(prices[s]+c<tempPrices[d])
                    tempPrices[d]=prices[s]+c;
                
            }
            //update the cost array
            prices=tempPrices;
        }
        if(prices[dst]==Integer.MAX_VALUE)
            return -1;
        else
            return prices[dst];
        
    }
}