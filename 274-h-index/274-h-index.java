class Solution{
public int hIndex(int[] citations) {
int i,m=0;
Arrays.sort(citations);
for(i=0;i<citations.length;i++){
if((citations.length-i)==citations[i])
 return citations[i];
else if((citations.length-i)<citations[i])
  m++;
}
return m;
}
}