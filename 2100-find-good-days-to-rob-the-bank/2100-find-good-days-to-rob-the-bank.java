class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
         List<Integer> list = new ArrayList<>();
        int n = security.length;
        int[] a = new int[n];
        int[] b = new int[n];
        a[0] = 0;
        for(int i = 1; i<n; i++)
        {
            if(security[i-1]>=security[i])
            {
                a[i] = a[i-1] + 1;
            }
            else
            {
                a[i] = 0;
            }
           // System.out.println(a[i]);
        }
        b[n-1] = 0;
        for(int i = n-2; i>=0; i--)
        {
            if(security[i+1]>=security[i])
            {
                b[i] = b[i+1] + 1;
            }
            else
            {
                b[i] = 0;
            }
            //System.out.println(b[i]);
        }
        /*for(int i = 0; i<n; i++)
        {
            //System.out.print(b[i]);
        }
        System.out.println(" ");
        for(int i = 0; i<n; i++)
        {
            System.out.print(a[i]);
        }*/
        
        for(int i = time; i<n-time; i++)
        {
           
                    if(a[i]>=time && b[i]>=time)
                    {
                    list.add(i);
                    }
             
        }
        return list;
    }
}