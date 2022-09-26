class Solution {
    final int M = 1000000007;
    
    int n;
    int dist[];
    
    List<List<Edge>> adj;
    
    boolean vis[];
    HashMap<Integer, Long> dp = new HashMap<>();
    public int countRestrictedPaths(int n, int[][] edges) {
        this.n = n;
        
        PriorityQueue<Edge> q = new PriorityQueue<>((a,b)->a.weight-b.weight);
        
        dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        adj = new ArrayList<>();
        vis = new boolean[n];
        
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        
        for(int edge[] : edges){
            int u = edge[0];
            int v = edge[1];
            
            int w  = edge[2];
            
            adj.get(u-1).add(new Edge(v-1,w));
            adj.get(v-1).add(new Edge(u-1,w));
        }
        
        // Dijkstra's Algorithm 
        int source = n-1;
        
        dist[source] = 0;
        
        q.add(new Edge(source, 0));
        
        while(q.size()>0){
            Edge curr = q.poll();
            
            int currNode = curr.node;
            int currDist = curr.weight;
            
            for(Edge v:adj.get(currNode)){
                if(currDist+v.weight < dist[v.node]){
                    dist[v.node] = currDist+v.weight;
                    q.add(new Edge(v.node, dist[v.node]));
                }
            }
        }
        
        // DFS with Memo
        long answer = dfs(0);
        
        return (int)answer;
    }
    
    long dfs(int u){
        if(u == n-1)
            return 1;
        
        if(dp.containsKey(u))
            return dp.get(u);
        
        vis[u] = true;
        
        long count = 0;
        
        for(Edge vEdge: adj.get(u)){
            int v = vEdge.node;
            
            if(dist[v]<dist[u]){
                count+=dfs(v);
                count%=M;
            }
        }
        
        dp.put(u,count);
        
        return count%M;
    }
}

class Edge{
    int node;
    int weight;
    
    Edge(int node, int weight){
        this.node = node;
        this.weight = weight;
    }
}