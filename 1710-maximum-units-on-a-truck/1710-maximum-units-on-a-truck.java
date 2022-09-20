class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        sortbyColumn(boxTypes,1);
         for (int i = 0; i < boxTypes.length; i++) {
            for (int j = 0; j < boxTypes[0].length; j++)
                System.out.print(boxTypes[i][j] + " ");
            System.out.println();
        }
        int unit = 0;
        for(int i = boxTypes.length-1; i>=0; i--)
        {
            if(truckSize == 0) return unit;
            if(boxTypes[i][0] <= truckSize)
            {
                unit+=boxTypes[i][0]*boxTypes[i][1];
               // System.out.println(unit+"......");
                truckSize = truckSize - boxTypes[i][0];
                //System.out.println(truckSize + "*****");
            }
            else
            {
                unit+=(truckSize)*boxTypes[i][1];
                truckSize = 0;
                //truckSize = truckSize - boxTypes[i][1] -;
            }
        }
        return unit;
    }
    public static void sortbyColumn(int arr[][], int col)
    {
        // Using built-in sort function Arrays.sort
        Arrays.sort(arr, new Comparator<int[]>() {
            
          @Override              
          // Compare values according to columns
          public int compare(final int[] entry1, 
                             final int[] entry2) {
  
            // To sort in descending order revert 
            // the '>' Operator
            if (entry1[col] > entry2[col])
                return 1;
            else
                return -1;
          }
        });  // End of function call sort().
    }
}