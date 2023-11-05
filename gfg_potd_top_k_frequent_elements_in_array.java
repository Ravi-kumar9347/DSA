class Solution {
    public int[] topK(int[] nums, int k) {
        //O(NlogK)
        //S(N)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new int[]{entry.getKey(), entry.getValue()});
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int i = k - 1;

        while (!pq.isEmpty()) {
            result[i] = pq.poll()[0];
            i--;
        }

        return result;
    }
}