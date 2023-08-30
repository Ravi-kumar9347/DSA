// class Solution {
//     public int bestClosingTime(String customers) {
//         //O(N)
//         //S(1)
//         int len = customers.length();
//         int y = 0, n = 0;
//         for(int i = 0; i < len; i++){
//             if(customers.charAt(i) == 'Y') y++;
//             else n++;
//         }

//         int dy = 0;
//         int prefix = n;
//         int min = prefix, hour = len;
//         for(int i = len - 1; i >= 0; i--){
//             if(customers.charAt(i) == 'Y'){
//                 y--;
//                 dy++;
//             }
//             else{
//                 n--;
//             }
//             prefix = n + dy;
//             if(min >= prefix){
//                 min = prefix;
//                 hour = i;
//             }
//         }

//         return hour;
//     }
// }

public class Solution {
    public int bestClosingTime(String customers) {
        int max_score = 0, score = 0, best_hour = -1;
        for(int i = 0; i < customers.length(); ++i) {
            score += (customers.charAt(i) == 'Y') ? 1 : -1;
            if(score > max_score) {
                max_score = score;
                best_hour = i;
            }
        }
        return best_hour + 1;
    }
}