class Solution {
    public int minimumSeconds(List<Integer> nums) {
        //O(N)
        //S(N)
        Map<Integer, List<Integer>> ref = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            if (!ref.containsKey(num)) {
                ref.put(num, new ArrayList<>());
            }
            ref.get(num).add(i);
        }
        int ans = Integer.MAX_VALUE;
        for (List<Integer> indexes : ref.values()) {
            int k = 0;
            int m = indexes.size();
            for (int j = 0; j < m; j++) {
                int x = indexes.get(j);
                int y = indexes.get((j - 1 + m) % m);
                if (x > y) {
                    k = Math.max(k, x - y - 1);
                } else {
                    k = Math.max(k, nums.size() - y + x - 1);
                }
            }
            if (k % 2 == 1) {
                k += 1;
            }
            ans = Math.min(ans, k / 2);
        }
        return ans;
    }
}