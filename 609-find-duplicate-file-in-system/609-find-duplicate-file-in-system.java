class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
       Map<String, List<String>> list = new HashMap<>();
        for(String path : paths)
        {
            String[] arr = path.split(" ");
            String directory = arr[0];
            for(int i = 1; i< arr.length; i++)
            {
                //fileName(content)
                String fileName = arr[i].substring(0, arr[i].indexOf("("));
                String content = arr[i].substring(arr[i].indexOf("(") +1 , arr[i].length() -1);
                List<String> filePaths = list.getOrDefault(content, new ArrayList<>());
                filePaths.add(directory + "/" + fileName);
                list.put(content, filePaths);
            }
        }
        list.entrySet().removeIf(entry -> entry.getValue().size()<2);
       return new ArrayList<>(list.values());
    }
}