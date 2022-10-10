class Solution {
    public String breakPalindrome(String s) {
       if(s.length()==1)   //always a palindrome
           return "";
       int i=0;
       StringBuffer sb = new StringBuffer(s);
       while(i<s.length() && s.charAt(i)=='a')
           i++;
       
       if((s.length()%2==1 && i==s.length()/2) || i==s.length())  //types of string --> aaa...x...aaa (x is any other character but not 'a') || aaaa....aaaaa
       {
           sb.setCharAt(s.length()-1,'b'); //replace the last character with 'b'
           return sb.toString();
       }
       else //replace the first non 'a' character in the string
       {
           sb.setCharAt(i,'a');
           return sb.toString();  //replace the last character with 'a'
       }
    }
}