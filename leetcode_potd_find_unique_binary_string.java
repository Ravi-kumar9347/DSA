

class Solution {
    public String findDifferentBinaryString(String[] nums) {
        // HashSet<String> set = new HashSet<>();
        // for (String str : nums) set.add(str);
        // if (!fun(new StringBuilder("0"), set, nums[0].length()).equals("ravi")) {
        //     return fun(new StringBuilder("0"), set, nums[0].length());
        // }
        // return fun(new StringBuilder("1"), set, nums[0].length());

        //O(N)
        //S(N)
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<nums.length;i++)
        {
            sb.append(nums[i].charAt(i) == '0'? "1": "0");
        }
        return new String(sb);
    }

    // private static String fun(StringBuilder s, HashSet<String> set, int n) {
    //     if (s.length() == n) {
    //         if (!set.contains(s.toString())) return s.toString();
    //         else return "ravi";
    //     }

    //     for (int i = 0; i < 2; i++) {
    //         if (i == 0) {
    //             s.append('0');
    //         } else {
    //             s.deleteCharAt(s.length() - 1);
    //             s.append('1');
    //         }

    //         String result = fun(new StringBuilder(s), set, n);
    //         if (!result.equals("ravi")) return result;
    //     }

    //     return "ravi";
    // }
}
