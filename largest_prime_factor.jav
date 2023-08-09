
class Solution{
    static long largestPrimeFactor(int N) {
        //O(sqrt(N))
        int largestFactor = -1;

        while (N % 2 == 0) {
            largestFactor = 2;
            N /= 2;
        }

        for (int i = 3; i * i <= N; i += 2) {
            while (N % i == 0) {
                largestFactor = i;
                N /= i;
            }
        }

        if (N > 2) {
            largestFactor = N;
        }

        return largestFactor;
    }
}