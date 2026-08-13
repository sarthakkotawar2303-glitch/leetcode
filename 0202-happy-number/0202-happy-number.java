class Solution {
    HashSet<Integer>set=new HashSet();
    public boolean isHappy(int n) {
        if(n==1) return true;
        set.add(n);
        
        
         
        int k=n;
        int sum=0;
        while(k>0){
            int mod=k%10;
            sum+=(mod*mod);
            k=k/10;
        }
        if(set.contains(sum)) return false;
       
        
        return isHappy(sum);
    }
}