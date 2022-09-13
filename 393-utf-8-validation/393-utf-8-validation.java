class Solution {
    public boolean validUtf8(int[] data) {
        for(int i = 0; i< data.length; i++)
        {
           int numberOfBytes = 0;
            int value = data[i];
            if(value>=255){
                return false;
            }
            else if((value & 128) == 0)
            {
                numberOfBytes = 1;
            }
            else if((value & 224) == 192)
            {
                numberOfBytes = 2;
            }
            else if((value & 240) == 224)
            {
                numberOfBytes = 3;
            }
            else if((value & 248) == 240){
                numberOfBytes = 4;
            }
            else
            {
                return false;
            }
            for(int j = 1; j<numberOfBytes; j++)
            {
                if((j+i) >= data.length)
                {
                    return false;
                }
                else if((data[i+j] & 192 )!= 128){
                    return false;
                }
            }
            i = i+numberOfBytes-1;
        }
        return true;
    }
}