// class Solution {
//     public String removeOuterParentheses(String s) {
//         Stack<Character> bracket = new Stack<>();
//         StringBuilder sb = new StringBuilder("");
//         for(int i=0;i<s.length();i++){
//             if(s.charAt(i)=='('){
//                 if(bracket.size()>0){
//                     sb.append(s.charAt(i));
//                 }
//                 bracket.push(s.charAt(i));
//             }else{
//                 bracket.pop();
//                 if(bracket.size()>0){
//                     sb.append(s.charAt(i));
//                 }
//             }
//         }
//         return sb.toString();
//     }
// }

class Solution {
    public String removeOuterParentheses(String s) {
        //O(N)
        //S(1)
        StringBuilder result = new StringBuilder();
        int opened = 0;
        
        for (char c : s.toCharArray()) {
            if ((c == '(' && opened++ > 0) || 
                (c == ')' && opened-- > 1)) {
                result.append(c);
            }
        }

        return result.toString();
    }
}