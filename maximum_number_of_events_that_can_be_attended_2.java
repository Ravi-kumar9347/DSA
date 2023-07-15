// class Solution {
//     public int maxValue(int[][] events, int k) {
//         int n = events.length;
//         // int[][][] MEMO = new int[n + 1][n + 1][k+1];
//         // Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));
//         // return backtrack(0, -1, 0, events, k, MEMO);

//         //tabularizaation ->
//         // for(int idx = n - 1; idx >= 0; idx--){
//         //     for(int prevIdx = idx - 1; prevIdx >= -1; prevIdx--){
//         //         for(int currK = k - 1; currK >= 0; currK--){
//         //             int currValue = 0 + MEMO[idx + 1][prevIdx + 1][currK];
//         //             if(prevIdx == -1 || events[prevIdx][1] < events[idx][0]){
//         //                 currValue = Math.max(currValue, events[idx][2] + MEMO[idx + 1][idx + 1][currK + 1]);
//         //             }

//         //             MEMO[idx][prevIdx + 1][currK] = currValue;
//         //         }
//         //     }
//         // }
//         // return MEMO[0][-1 + 1][0];

//         int[][] current = new int[n + 1][k + 1];
//         int[][] next = new int[n + 1][k + 1];
//         Arrays.sort(events, (a, b) -> Integer.compare(a[1], b[1]));

//         for(int idx = n - 1; idx >= 0; idx--){
//             for(int prevIdx = idx - 1; prevIdx >= -1; prevIdx--){
//                 for(int currK = k - 1; currK >= 0; currK--){
//                     int currValue = 0 + next[prevIdx + 1][currK];
//                     // take this value if it satisfies the condition
//                     if(prevIdx == -1 || events[prevIdx][1] < events[idx][0]){
//                         currValue = Math.max(currValue, events[idx][2] + next[idx + 1][currK + 1]);
//                     }

//                     current[prevIdx + 1][currK] = currValue;
//                 }
//             }
//             next = current;
//         }
//         return next[-1 + 1][0];
//     }

//     public int backtrack(int idx, int prevIdx, int currNoEvents, int[][] events, int k, int[][][] MEMO){
//         if(currNoEvents >= k || idx == events.length){
//             return 0;
//         }

//         if(MEMO[idx][prevIdx + 1][currNoEvents] != 0){
//             return MEMO[idx][prevIdx + 1][currNoEvents];
//         }

//         int currValue = 0 + backtrack(idx + 1, prevIdx, currNoEvents, events, k, MEMO);
//         if(prevIdx == -1 || events[prevIdx][1] < events[idx][0]){
//             currValue = Math.max(currValue, events[idx][2] + backtrack(idx + 1, idx, currNoEvents + 1, events, k, MEMO));
//         }

//         return MEMO[idx][prevIdx + 1][currNoEvents] = currValue;
//     }
// }

class Solution {
    public int maxValue(int[][] events, int k) {
        int n = events.length;
        int[][] MEMO = new int[n + 1][k];
        Arrays.sort(events, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });
        return backtrack(0, -1, 0, events, k, MEMO);
    }

    public int backtrack(int idx, int prevIdx, int currK, int[][] events, int k, int[][] MEMO){
        if(currK >= k || idx == events.length){
            return 0;
        }

        if(MEMO[prevIdx + 1][currK] != 0){
            return MEMO[prevIdx + 1][currK];
        }

        // don't take this value
        int currValue = 0 + backtrack(idx + 1, prevIdx, currK, events, k, MEMO);
        if(prevIdx == -1 || events[prevIdx][1] < events[idx][0]){
            currValue = Math.max(currValue, events[idx][2] + backtrack(idx + 1, idx, currK + 1, events, k, MEMO));
        }

        return MEMO[prevIdx + 1][currK] = currValue;
    }
}