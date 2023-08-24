class Solution {
    public String multiplyStrings(String s1, String s2) {
        //O(N * M)
        //S(N + M)
        int neg = 0;

        if (s1.charAt(0) == '-') {
            neg ^= 1;
            s1 = s1.substring(1);
        }

        if (s2.charAt(0) == '-') {
            neg ^= 1;
            s2 = s2.substring(1);
        }

        StringBuilder sb1 = new StringBuilder(s1);
        StringBuilder sb2 = new StringBuilder(s2);

        sb1.reverse();
        sb2.reverse();

        int n = sb1.length();
        int m = sb2.length();

        int[] res = new int[n + m + 20];
        for (int i = 0; i < m; i++) {
            int pos = i;
            int x = sb2.charAt(i) - '0';
            for (int j = 0; j < n; j++) {
                int y = sb1.charAt(j) - '0';

                res[pos] += x * y;

                if (res[pos] > 9) {
                    res[pos + 1] += res[pos] / 10;
                    res[pos] = res[pos] % 10;
                }

                pos++;
            }
        }
        boolean found = false;
        StringBuilder ans = new StringBuilder();

        for (int i = res.length - 1; i >= 0; i--) {
            if (res[i] != 0) {
                found = true;
            }

            if (found) {
                ans.append((char) (res[i] + '0'));
            }
        }

        if (neg == 1) {
            ans.insert(0, '-');
        }

        return ans.toString();
    }
}
