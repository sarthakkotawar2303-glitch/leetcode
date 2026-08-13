class Solution {
    public String reverseVowels(String s) {
        
        char[] st=s.toCharArray();
        int left=0;
        int right=s.length()-1;
        String vowel="aeiouAEIOU";

        while(left<right){
            while(left<right && !vowel.contains(st[left]+"")) left++;
            while(left<right && !vowel.contains(st[right]+"")) right--;

            char temp=st[left];
            st[left]=st[right];
            st[right]=temp;
            left++;
            right--;

        }

        return new String(st);
        
    }
}