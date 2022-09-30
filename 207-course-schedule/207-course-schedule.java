class Solution {
    public boolean canFinish(int n, int[][] p) {
        List<List<Integer>> nm=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            nm.add(new ArrayList<>());
        }
        System.out.println(nm);
        for(int i=0;i<p.length;i++)
        {
            nm.get(p[i][0]).add(p[i][1]);
        }
        System.out.println(nm);
        Queue<Integer> kk=new LinkedList<>();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int k:nm.get(i))
            {
                a[k]++;
                 //System.out.println(a[k] +" " + k);
            }
            //System.out.println("");
           // System.out.println(a[0] + " " + a[1]);
        }
         //System.out.println(a[0] + " " + a[1]);
        for(int i=0;i<a.length;i++)
        {
            if(a[i]==0)
            {
                kk.offer(i);
            }
        }
        System.out.println(kk);
        List<Integer> k=new ArrayList<>();
        while(!kk.isEmpty())
        {
            int x=kk.poll();
            k.add(x);
            System.out.println(k);
            for(int j:nm.get(x))
            {
                a[j]--;
                if(a[j]==0)
                {
                    kk.offer(j);
                }
            }
        }
        return k.size()==n;
    }
}