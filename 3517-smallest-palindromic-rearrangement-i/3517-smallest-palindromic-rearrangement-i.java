class Solution {
    public String smallestPalindrome(String s) {

        TreeMap<Character,Integer>map=new TreeMap<>();
        char[] arr=s.toCharArray();
        Arrays.sort(arr);

        for(char c:arr){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        StringBuilder left=new StringBuilder();
        StringBuilder middle=new StringBuilder();

        for(char key:map.keySet()){
            int freq=map.get(key);

            for(int i=0;i<freq/2;i++){
                left.append(key);
            }

            if(freq%2==1){
                middle.append(key);
            }
        }

        StringBuilder right=new StringBuilder(left).reverse();

        return left.toString()+middle.toString()+right.toString();

    }
}