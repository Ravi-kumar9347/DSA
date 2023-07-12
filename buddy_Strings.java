class Solution {
    public boolean buddyStrings(String s, String goal) {
        Map<Character, Integer> mpp = new HashMap<>();
        int i = 0;
        int maxi = 0;
        char s1 = 'a', g1 = 'b';
        int cnt = 0;
        while(i < s.length()){
            if(s.charAt(i) == goal.charAt(i)){
                mpp.put(s.charAt(i), mpp.getOrDefault(s.charAt(i), 0) + 1);
                maxi = Math.max(maxi, mpp.get(s.charAt(i)));
            }
            else if(cnt == 0){
                cnt++;
                s1 = s.charAt(i);
                g1 = goal.charAt(i);
            }else if(g1 == s.charAt(i) && s1 == goal.charAt(i) && cnt == 1){
                cnt++;
            }else{
                return false;
            }
            i++;
        }
        if((cnt == 2 || (maxi > 1 && cnt == 0)) && i == s.length() && i == goal.length()) return true;
        return false;
    }
}

class Solution {
    public boolean buddyStrings(String s, String goal) {
        int n = s.length();
        if (s.equals(goal)) {
            Set<Character> temp = new HashSet<>();
            for (char c : s.toCharArray()) {
                temp.add(c);
            }
            return temp.size() < goal.length(); // Swapping same characters
        }

        int i = 0;
        int j = n - 1;

        while (i < j && s.charAt(i) == goal.charAt(i)) {
            i++;
        }

        while (j >= 0 && s.charAt(j) == goal.charAt(j)) {
            j--;
        }

        if (i < j) {
            char[] sArr = s.toCharArray();
            char temp = sArr[i];
            sArr[i] = sArr[j];
            sArr[j] = temp;
            s = new String(sArr);
        }

        return s.equals(goal);
    }
}