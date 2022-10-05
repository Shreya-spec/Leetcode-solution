class LUPrefix {
    int maxo = 0;
    HashMap<Integer, Integer> map = new HashMap<>();
    public LUPrefix(int n) {
        maxo = 0;
    }
    
    public void upload(int video) {
       map.put(video, 1);
        while(map.get(maxo+1) != null && (map.get(maxo+1)>0))
        {
            maxo++;
        }
    }
    
    public int longest() {
        return maxo;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */