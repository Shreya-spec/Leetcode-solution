class TimeMap {
    Map<String, Map<Integer, String>> keyPair;
    public TimeMap() {
       keyPair = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        keyPair.putIfAbsent(key, new TreeMap<>());
        Map<Integer, String> tm = keyPair.get(key);
        tm.put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        Map<Integer, String> tm = keyPair.get(key);
        if(tm == null) return "";
        Integer k = (Integer)((TreeMap)tm).floorKey(timestamp);
        if(k == null) return "";
        return tm.get(k);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */