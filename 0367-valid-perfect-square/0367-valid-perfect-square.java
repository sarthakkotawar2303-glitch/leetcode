class Solution {
    public boolean isPerfectSquare(int num) {
        for(long i=1;i<=num;i++){
            if(i*i==(long)num) return true;
        }
        return false;
    }
}