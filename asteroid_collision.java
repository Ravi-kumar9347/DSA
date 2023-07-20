class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        int n = asteroids.length;
        //O(N)
        //S(N)
        for(int i = 0; i < n; i++){
            int add = 0;
            while(!s.isEmpty() && s.peek() > 0 && asteroids[i] < 0){
                int top = s.peek();
                int size = Math.abs(asteroids[i]);
                if(size > top){
                    s.pop();
                }
                else if(size == top){
                    s.pop();
                    add = 1;
                    break;
                }
                else{
                    add = 1;
                    break;
                }
            }
            if(add != 1) s.push(asteroids[i]);
        }    
        int len = s.size();
        int[] result = new int[len];
        while(len - 1 >= 0){
            result[len - 1] = s.pop();
            len--;
        }

        return result;
    }
}