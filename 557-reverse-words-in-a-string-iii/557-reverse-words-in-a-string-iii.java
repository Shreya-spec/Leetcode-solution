class Solution {
    public String reverseWords(String s) {
        char[] temp = s.toCharArray();
         String ans = "";
        String k ="";
        int i = 0;
       for(i = 0; i<s.length(); i++)
       {
           if(temp[i]== ' ')
           {
              ans += reverseString(k);
              ans+=' ';
               k="";
           }
          
           else
           {
           k+=temp[i];
           }
       }
        if(i == s.length())
        {
             ans += reverseString(k);
        }
        
        return ans;
    }
    public String reverseString(String input)
    {
        String l ="";
        StringBuilder input1 = new StringBuilder();
  
        // append a string into StringBuilder input1
        input1.append(input);
  
        // reverse StringBuilder input1
        input1.reverse();
        l = input1.toString();
        return l;
    }
}