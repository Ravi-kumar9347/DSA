class Solution {
    public boolean checkValidString(String s) {

        //O(N)
        //S(N)
        // Stack<Integer> open = new Stack<>();
        // Stack<Integer> star = new Stack<>();
        // for(int i = 0; i < s.length(); i++){
        //     if(s.charAt(i) == '('){
        //         open.push(i);
        //     }
        //     else if(s.charAt(i) == '*'){
        //         star.push(i);
        //     }
        //     else{
        //         if(!open.isEmpty()){
        //             open.pop();
        //         }
        //         else if(!star.isEmpty()){
        //             star.pop();
        //         }
        //         else{
        //             return false;
        //         }
        //     }
        // }

        // while(!open.isEmpty()){
        //     if(star.isEmpty()){
        //         return false;
        //     }
        //     if(open.peek() < star.peek()){
        //         open.pop();
        //         star.pop();
        //     }
        //     else{
        //         return false;
        //     }
        // }

        // return true;

        //greedy ->
        //O(N)
        //S(1)

        int open = 0, star = 0, used = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else if(s.charAt(i) == '*'){
                if(open > 0){
                    open--;
                    used++;
                }
                else{
                    star++;
                }
            }
            else{
                if(open > 0){
                    open--;
                }
                else if(star > 0){
                    star--;
                }
                else if(used > 0){
                    used--;
                    star++;
                }
                else{
                    return false;
                }
            }
        }

        if(open != 0){
            return false;
        }

        return true;
    }
}