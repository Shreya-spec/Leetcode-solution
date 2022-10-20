class Solution {
    public int[] productQueries(int n, int[][] queries) {
        int mod=1000000007;
        List<Integer> arr = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] a = new int[queries.length];
       while(n>0){  
            arr.add((int)n%2);
            n/=2;
        }
         //System.out.print(arr);
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)==1){ 
                int t=(int)Math.pow(2,i);
                list.add(t);
            }
        }
        //System.out.println(list);
           int j = 0;
           
        for(int[] q : queries){
             long sum1 = 1;
            for(int k = q[0]; k<=q[1]; k++)
            {
                sum1= (sum1*list.get(k)%mod);
            }
            a[j++] = (int)sum1%mod;
            //System.out.println(a[j]);
        }
        return a;
    }
}