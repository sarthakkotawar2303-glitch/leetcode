class Solution {
    List<String> ans = new ArrayList<>();
    HashMap<Character, String> map = new HashMap<>();
    

    public void backtracking(String digits,StringBuilder s,int idx){
        if(idx==digits.length()){
            ans.add(s.toString());
            return;
        }
        String digit=map.get(digits.charAt(idx));
        
        for(char c:digit.toCharArray()){
            s.append(c);
            backtracking(digits,s,idx+1);
            s.deleteCharAt(s.length()-1);
        }

    }

    public List<String> letterCombinations(String digits) {
        map.put('2',"abc");
    map.put('3',"def");
    map.put('4',"ghi");
    map.put('5',"jkl");
    map.put('6',"mno");
    map.put('7',"pqrs");
    map.put('8',"tuv");
    map.put('9',"wxyz");
        backtracking(digits,new StringBuilder(),0);
        return ans;
    }
}