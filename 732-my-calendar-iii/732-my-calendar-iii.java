class MyCalendarThree {
  private TreeMap<Integer, Integer> tmap;
    public MyCalendarThree() {
        tmap = new TreeMap<>();
    }
    
    public int book(int start, int end) {
        tmap.put(start, tmap.getOrDefault(start, 0) + 1);
        tmap.put(end, tmap.getOrDefault(end, 0) - 1);
        int actives = 0;
        int max = 0;
        for(int events: tmap.values())
        {
            actives +=events;
            if(max<actives)
            {
                max = actives;
            }
        }
        return max;
    }
}

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree obj = new MyCalendarThree();
 * int param_1 = obj.book(start,end);
 */