
class Solution
{ 
    static void reverse(Stack<Integer> s)
    {
        //O(N)
        //S(N)
        if(s.isEmpty() || s.size() == 1) return;
        
        int top = s.pop();
        reverse(s);
        insertAtBottom(s, top);
    }
    
    private static void insertAtBottom(Stack<Integer> s, int element){
        if(s.isEmpty()){
            s.push(element);
            return;
        }
        
        int top = s.pop();
        insertAtBottom(s, element);
        s.push(top);
    }
}