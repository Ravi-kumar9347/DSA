class Solution {
    static int isPerfectNumber(long N) {
        //O(Sqrt(N))
        //S(1)
        if (N <= 1) {
            return 0;  // Perfect numbers are always greater than 1
        }

        long factorSum = 1;  // Initialize the sum with 1 (since 1 is always a factor)

        // Find factors up to the square root of N
        for (long i = 2; i * i <= N; i++) {
            if (N % i == 0) {
                factorSum += i;
                if (i != N / i) {  // Avoid counting the same factor twice
                    factorSum += N / i;
                }
            }
        }

        return factorSum == N ? 1 : 0;
    }
};