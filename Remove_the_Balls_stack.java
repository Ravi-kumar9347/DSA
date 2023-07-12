class Pair{
    int col;
    int rad;
    Pair(int col, int rad){
        this.col = col;
        this.rad = rad;
    }
}
class Solution {
    public static int finLength(int N, int[] color, int[] radius) {
        //O(N) S(N)
        Stack<Pair> st = new Stack<>();
        
        for(int i = 0; i < N; i++){
            if(st.isEmpty()){
                Pair p = new Pair(color[i], radius[i]);
                st.push(p);
            }
            else{
                Pair p = st.peek();
                
                if(p.col == color[i] && p.rad == radius[i]){
                    st.pop();
                }
                else{
                    Pair newPair = new Pair(color[i], radius[i]);
                    st.push(newPair);
                }
            }
        }
        
        return st.size();
    }
}