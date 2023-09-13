
class Solution{
    static String findLargest(int N, int S){
        //O(N)
        //S(1)
        if(S == 0 && N > 1) return "-1"; 
        int s = S, curSum = 0;
        StringBuilder num = new StringBuilder();
        
        while(N > 0){
            if(s >= 9){
                num.append('9');
                s -= 9;
                curSum += 9;
            }
            else if(s > 0){
                char c = (char) (s + '0');;
                num.append(c);
                curSum += s;
                s = 0;
            }
            else{
               num.append('0');
            }
            N--;
        }
        
        return curSum == S ? num.toString() : "-1";
    }
}