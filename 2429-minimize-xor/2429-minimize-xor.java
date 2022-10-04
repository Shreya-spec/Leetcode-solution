class Solution {
    public int minimizeXor(int num1, int num2) {
         int noOfBits = 0;
        while(num2 != 0){
            noOfBits += num2 & 1;
            num2>>=1;
        }
        int[] bits1 = new int[32];
        Arrays.fill(bits1, 0);
        int[] bits2 = new int[32];
        Arrays.fill(bits2,0);
        int pos=0;
        while(num1 != 0){
            if((num1 & 1) == 1){
                bits1[pos]++;
            }
            pos++;
            num1>>=1;
        }
        for(int i=31;i>=0;i--){
            if(bits1[i] != 0 && noOfBits != 0){
                noOfBits--;
                bits2[i]++;
            }
        }
        for(int i=0;i<32;i++){
            if(bits1[i]==0 && noOfBits!=0){
                noOfBits--;
                bits2[i]++;
            }
        }
        int ans=0;
        for(int i=0;i<32;i++){
            if(bits2[i] == 1){
                ans+=Math.pow(2,i);
            }
        }
        return ans;
    }
}