class Solution {

    public boolean valid(String s1,String s2){
        int n=s1.length();
        int m=s2.length();

        if(n-m!=1) return false;

        int a=0;
        int b=0;

        while(a<n && b<m){
            if(s1.charAt(a)==s2.charAt(b)){
                b++;
            }
            a++;
        }

        return m==b;
    }
    public int longestStrChain(String[] words) {

        Arrays.sort(words,(a,b)->a.length()-b.length());
        int maxLen=1;
        int[]dp=new int[words.length];
        Arrays.fill(dp,1);

        for(int i=0;i<words.length;i++){
            for(int j=0;j<i;j++){
                if(valid(words[i],words[j]) && dp[i]<dp[j]+1){
                    dp[i]=dp[j]+1;
                    maxLen=Math.max(dp[i],maxLen);
                }
            }
        }
        return maxLen;
        
    }
}