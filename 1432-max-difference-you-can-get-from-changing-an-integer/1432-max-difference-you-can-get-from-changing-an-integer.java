class Solution {
    public int maxDiff(int num) {
        String str = String.valueOf(num) ; 
        char ch = '0' ; 

        for ( int i = 0 ; i < str.length() ; i++ ) {
            if( str.charAt(i) != '9' ) {
                ch = str.charAt(i) ; 
                break ; 
            }
        }
        String Min = str ;  
        char ch2 = '0' ; 
        String maxNum = str.replace(ch , '9') ; 

        for ( int i = 0 ; i < Min.length() ; i++ ) {
            if(Min.charAt(i) == '1' || Min.charAt(i) == '0') continue ; 
            else {
                ch2 = Min.charAt(i) ; 
                break ; 
            }
        }
        String minNum = Min ; 
        if(Min.charAt(0) != '1')minNum = str.replace(Min.charAt(0) , '1') ; 
        else minNum = str.replace(ch2 , '0') ; 
        int a = Integer.parseInt(maxNum) ; 
        int b = Integer.parseInt(minNum) ; 

        return a - b ; 

    }
}