// class Solution {
//     public String longestCommonPrefix(String[] v) {
           //O(NMlogN)
           //S(1)
//         StringBuilder ans = new StringBuilder();
//         Arrays.sort(v);
//         String first = v[0];
//         String last = v[v.length-1];
//         for (int i=0; i<Math.min(first.length(), last.length()); i++) {
//             if (first.charAt(i) != last.charAt(i)) {
//                 return ans.toString();
//             }
//             ans.append(first.charAt(i));
//         }
//         return ans.toString();
//     }
// }

class Solution {
    public String longestCommonPrefix(String[] strs) {
        //O(N*M)
        //S(M)
        if(strs.length == 1) return strs[0];
        int n = strs.length;
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < strs[0].length(); i++){
            set.add(strs[0].substring(0, i+1));
        }

        String ans = new String();
        int size = (int)1e9;
        for(int i = 1; i < n; i++){
            String cur = new String();
            for(int j = 0; j < strs[i].length(); j++){
                if(set.contains(strs[i].substring(0, j+1))){
                    cur = strs[i].substring(0, j+1);
                }
                else break;
            }

            if(size > cur.length()){
                ans = cur;
                size = cur.length();
            }
        }

        return ans;
    }
}