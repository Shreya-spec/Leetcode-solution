class Solution {
    public static void solveConfiguration(char[] a, int j, int k)
    {
        if(a[j] == 'L' && a[k] == 'L')
        {
          for(int i = j+1; i<k; i++)
          {
              a[i] = 'L';
          }
        }
        else if(a[j] == 'R' && a[k] == 'R')
        {
            for(int i = j+1; i<k; i++)
          {
              a[i] = 'R';
          }
        }
        else if(a[j] == 'L' && a[k] == 'R')
        {
            return;
        }
        else
        {
          int diff = k - j;
            int mid = (k+j)/2;
            if(diff % 2 == 0)
            {
                for(int i = j + 1; i < mid; i++)
                {
                    a[i] ='R';
                }
                for(int i = mid + 1; i < k; i++)
                {
                    a[i] ='L';
                }
            }
            else
            {
                 for(int i = j + 1; i <= mid; i++)
                {
                    a[i] ='R';
                }
                for(int i = mid + 1; i < k; i++)
                {
                    a[i] ='L';
                }
            }
        }
    }
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] a = new char[n+2];
        a[0] = 'L';
        a[n+1] = 'R';
        for(int i = 1; i<n+1;i++)
        {
            a[i] = dominoes.charAt(i-1);
        }
        int j = 0;
        int k = 1;
        while(k<(n+2))
        {
            while(a[k]=='.')
            {
                k++;
            }
            if(k-j>1)
              solveConfiguration(a, j, k);
            j = k;
            k++;
        }
        StringBuilder res = new StringBuilder();
        for(int i = 1; i<n+1; i++)
        {
            res.append(a[i]);
        }
        return res.toString();
    }
}