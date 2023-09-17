class Solution {
    static String solve(int A, int B) {
        //O(1) S(1)
        if(A % 2 == 0 && B % 2 == 0) return "He";
        
        if(A % 2 != 0 && B % 2 != 0) return "She";
        
        return "Punished";
    }
}