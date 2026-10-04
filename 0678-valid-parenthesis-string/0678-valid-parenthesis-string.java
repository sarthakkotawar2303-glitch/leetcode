class Solution {
  
     //memorization;
     Boolean[][] dp;
     public boolean memorization(int idx, int balance, String s) {
        
        if(balance<0) return false;

        if(idx==s.length()){
            return balance==0;
        }
        if(dp[idx][balance]!=null) return dp[idx][balance];

        //if i get '(' the idx+1 and balance+1
        if (s.charAt(idx) == '(') {
           return  memorization(idx + 1, balance + 1, s);
        }

        //if i get ')' the idx+1 and balance-1
        if (s.charAt(idx) == ')') {
           return  memorization(idx + 1, balance - 1, s);
        }

        //if i get start i gave to explore and check means
        //ekda )  ekda ( ani ekda ""

        
            //take * as (
            boolean open = memorization(idx + 1, balance + 1, s);

            //take * as (
            boolean close = memorization(idx + 1, balance - 1, s);

            //take * as (
 
            boolean empty = memorization(idx + 1, balance, s);
        

        return dp[idx][balance]=open || close || empty;

    }


    //first i should balance logic 
    //explore three conditions of start 
    //and find the valid

    public boolean recursion(int idx, int balance, String s) {
        
        if(balance<0) return false;

        if(idx==s.length()){
            return balance==0;

        }

      

        //if i get '(' the idx+1 and balance+1
        if (s.charAt(idx) == '(') {
           return  recursion(idx + 1, balance + 1, s);
        }

        //if i get ')' the idx+1 and balance-1
        if (s.charAt(idx) == ')') {
           return  recursion(idx + 1, balance - 1, s);
        }

        //if i get start i gave to explore and check means
        //ekda )  ekda ( ani ekda ""

        
            //take * as (
            boolean open = recursion(idx + 1, balance + 1, s);

            //take * as (
            boolean close = recursion(idx + 1, balance - 1, s);

            //take * as (
 
            boolean empty = recursion(idx + 1, balance, s);
        

        return open || close || empty;

    }

    public boolean checkValidString(String s) {
        //return recursion(0, 0, s); --> time limits fails

        dp=new Boolean[s.length()][s.length()+1];
        return memorization(0, 0, s);

        
    }
}