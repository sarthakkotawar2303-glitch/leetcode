class Solution {
    public String smallestPalindrome(String s) {
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }

        StringBuilder left=new StringBuilder();
        StringBuilder middle=new StringBuilder();

        for(int i=0;i<26;i++){
            char curr=(char)('a'+i);
            int f=freq[i];

            for(int j=0;j<f/2;j++){
                left.append(curr);
            }

            if(f%2==1){
                middle.append(curr);
            }

        }

        StringBuilder right=new StringBuilder(left).reverse();
        return left.toString()+middle.toString()+right.toString();
    }
}