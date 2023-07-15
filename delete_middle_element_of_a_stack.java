class Solution
{
    //Function to delete middle element of a stack.
    private static void fun(int ind, int midEleIndex, Stack<Integer>s){
        if(ind == midEleIndex){
            s.pop();
            return;
        }
        int num = s.pop();
        
        fun(ind + 1, midEleIndex, s);
        
        s.push(num);
        
        return;
    }
    public void deleteMid(Stack<Integer>s,int sizeOfStack){
        fun(0, sizeOfStack/2, s);
    } 
}

