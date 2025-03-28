class Solution {
    public String minWindow(String s, String t) {

        int start = 0;
        int end = 0;
        int count = 0;
        int sidx = -1;
        int minlength = s.length() + 1;
        int[] tarray = new int[128];

        for(int i=0;i<t.length();i++)
        {
            tarray[t.charAt(i)]++;
        }

        while(end<s.length())
        {
            if(tarray[s.charAt(end)] > 0) count++;
            tarray[s.charAt(end)]--;
            
            while(count==t.length())
            {
                if(minlength > end-start + 1){
                    minlength = end - start + 1;
                    sidx = start;
                }
                tarray[s.charAt(start)]++;
                if(tarray[s.charAt(start)] > 0)
                {
                    count--;
                }
        
                start++;

            }
            end++;

        }
        return (sidx == -1) ? "" : s.substring(sidx, sidx + minlength);
    }
}