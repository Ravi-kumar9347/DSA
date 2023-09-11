
class Solution {
    public static String solve(int N, String s) {
        
        //O(N)
        //S(N)
        HashMap<Character, Integer> map = new HashMap<>();
        String str = "";
        int max = 0;
        char prev = 'A';
        
        for(int i = 0; i < N; i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            if(max < map.get(s.charAt(i)) || (max == map.get(s.charAt(i)) && prev > s.charAt(i))){
                max = map.get(s.charAt(i));
                prev = s.charAt(i);
                str = Character.toString(s.charAt(i));
            }
        }
        
        return str;
    }
}