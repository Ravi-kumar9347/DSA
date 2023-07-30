class Solution {
    public int maximumNumber(int num) {
        //O(N)
        //S(1)
        
        String n = String.valueOf(num);
        String ans ="";
        int i;
        for(i = 0; i < n.length(); i++){
            if(n.charAt(i) == '7'){
                ans += '9';
                break;
            }
            ans += n.charAt(i);
        }
        i++;
        while(i < n.length()){
            ans += n.charAt(i++);
        }
        
        return Integer.parseInt(ans);
    }
}