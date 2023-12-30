class Solution
{
    public static String[] winner(String arr[], int n) {
        //O(N)
        //S(N)
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        String word = " ";
        int votes = -1;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String can = entry.getKey();
            int curVotes = entry.getValue();
            if (curVotes > votes) {
                word = can;
                votes = curVotes;
            } else if (votes == curVotes) {
                word = fun(word, can);
            }
        }

        return new String[]{word, String.valueOf(votes)};
    }

    static String fun(String s, String t) {
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) < t.charAt(j)) {
                return s;
            } else if (s.charAt(i) > t.charAt(j)) {
                return t;
            }
            i++;
            j++;
        }

        if (i == n) return s;
        return t;
    }
}
