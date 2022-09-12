class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int i  = 0;
        int j = tokens.length -1;
        int count = 0;
        while(i <= j)
        {
          if(power>=tokens[i]){
              power-=tokens[i++];
              count++;
          }
            else
            {
               if(power+ tokens[j] >= tokens[i] && count != 0 && i != j)
               {
                   power +=tokens[j--];
                   count--;
               }
                else
                {
                    break;
                }
            }
        }
        return count;
    }
}