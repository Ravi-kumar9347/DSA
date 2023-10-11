
class Solution{
    public int[] findBots(String usernames[], int n){
        //O(N)
        //S(1)
        HashSet<Integer> prime = new HashSet<>();
        prime.add(2);
        prime.add(3);
        prime.add(5);
        prime.add(7);
        
        int[] result = new int[n];
        int j = 0;
        for(String s : usernames){
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < s.length(); i += 2){
                // System.out.print(s.charAt(i));
                set.add(s.charAt(i));
            }
            if(prime.contains(set.size())){
                result[j] = 1;
            }
            j++;
        }
        
        return result;
    }
}
