class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
        //O(N*N)
        //S(N)
        int n = arr.length;
        HashMap<Integer, Long> map = new HashMap<>();
        Arrays.sort(arr);
        int mod = (int)1e9 + 7;
        for (int i = 0; i < n; i++) {
            map.put(arr[i], 1L); // Initialize with 1
            for (int j = 0; j < i; j++) {
                if (arr[i] % arr[j] == 0 && map.containsKey(arr[i] / arr[j])) {
                    map.put(arr[i], (map.get(arr[i]) + (map.get(arr[j]) * map.get(arr[i] / arr[j])) % mod) % mod);
                }
            }
        }

        long count = 0;
        for (int num : arr) {
            count = (count + map.get(num)) % mod;
        }

        return (int) count;
    }
}
