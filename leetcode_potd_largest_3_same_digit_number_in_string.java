class Solution {
    public String largestGoodInteger(String num) {
        //O(N)
        //S(1)
        int n = num.length();
        char c = '0';
        int flag = 0;
        for(int i = 1; i < n; i++){
            int j = i;
            while(j < n && num.charAt(j-1) == num.charAt(j)) j++;
            if(j - i >= 2 && c <= num.charAt(j-1)){
                flag = 1;
                c = num.charAt(j-1);
            } 
            i = j; 
        }
        StringBuilder ans = new StringBuilder();
        ans.append(c);
        ans.append(c);
        ans.append(c);
        return flag == 1 ? ans.toString() : "";
    }
}