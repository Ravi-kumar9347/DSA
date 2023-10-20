class Solution {
    static int isPossible(int N, int arr[]) {
        //O(N)
        //S(1)
        long sum = 0;
        for(int num : arr) sum += num;
        return sum % 3 == 0 ? 1 : 0;
    }
}