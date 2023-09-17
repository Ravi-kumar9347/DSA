class Solution {
    static int makeStringEmpty(String s) {
        //O(N)
        //S(N)
        int n = s.length();
        int l = 0, r = 0, c = 0;
        StringBuilder str = new StringBuilder();

        for (int i = 0; i < n; i++) {
            str.append(s.charAt(i));
            if (str.length() - l <= 3) continue;

            if (str.substring(l).equals("geek")) {
                str.delete(l, str.length());
                c++;
                if (str.length() >= 3) l = str.length() - 3;
                else l = 0;
            } else {
                l++;
            }
        }
        
        return str.length() != 0 ? -1 : c;
    }
};