class Solution {
    int findMaxSum(int arr[], int n) {
        //O(N)
        //S(1)
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }

        int incl = arr[0];
        int excl = 0;

        for (int i = 1; i < n; i++) {
            int newIncl = excl + arr[i];
            int newExcl = Math.max(incl, excl);

            incl = newIncl;
            excl = newExcl;
        }

        return Math.max(incl, excl);
    }
}