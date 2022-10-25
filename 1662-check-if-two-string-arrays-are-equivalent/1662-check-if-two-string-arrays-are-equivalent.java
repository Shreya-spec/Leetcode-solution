class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        for(int i = 0; i<word1.length; i++)
        {
            sb.append(word1[i]);
        }
        for(int j = 0; j<word2.length; j++)
        {
            sb1.append(word2[j]);
        }
        String s = sb.toString();
          String s1 = sb1.toString();
        if(s.equals(s1) == true)
        {
            return true;
        }
        else return false;
    }
}