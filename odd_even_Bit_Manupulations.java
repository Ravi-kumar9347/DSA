public class Solution {
    public static String oddEven(int N){
        int bit = N & 1;
        if(bit == 1) return "odd";
        return "even";
    }
}