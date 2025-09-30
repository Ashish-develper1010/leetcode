class Solution {
public:
    int characterReplacement(string s, int k) {
        vector<int> ar(26,0);
        int i=0,j=0,res=0,mxcnt=0;
        while(j<s.size()){
            ar[s[j]-'A']++;
            mxcnt=max(mxcnt,ar[s[j]-'A']);

            while((j-i+1)-mxcnt > k){
                ar[s[i]-'A']--;
                mxcnt=max(mxcnt,ar[s[i]-'A']);
                i++;
            }
            res=max(res,j-i+1);
            j++;
        }
        return res;
    }
};