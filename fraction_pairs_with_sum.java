class Solution {
    static int countFractions(int N, int[] numerator, int[] denominator) {
        //O(NlogN)
        //S(N)
        HashMap<String, Integer> map = new HashMap<>();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int gcd = gcd(numerator[i], denominator[i]);
            String fraction = (numerator[i] / gcd) + "/" + (denominator[i] / gcd);
            String complement = (denominator[i] / gcd - numerator[i] / gcd) + "/" + (denominator[i] / gcd);

            if (map.containsKey(complement)) {
                count += map.get(complement);
            }

            map.put(fraction, map.getOrDefault(fraction, 0) + 1);
        }

        return count;
    }

    static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

}