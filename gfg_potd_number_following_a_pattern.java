class Solution{
    static String printMinNumberForPattern(String S){
        //O(N)
        //S(1)
        int num = 1;
        Stack<Integer> st = new Stack<>();
        StringBuilder s = new StringBuilder();
        
        for(int i = 0; i < S.length(); i++){
            st.push(num++);
            if(S.charAt(i) == 'I'){
                while(st.size() > 0){
                    s.append(st.pop());
                }
            }
        }
        
        st.push(num);
        while(st.size() > 0){
            s.append(st.pop());
        }
        
        return s.toString();
    }
}
