
class Solution {
    static List<Integer> maxCombinations(int N, int K, int A[], int B[]) {
        //O(NlogN)
        //S(N)
        Arrays.sort(A);
        Arrays.sort(B);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i = N - 1; i >= N - K; i--){
            for(int j = N - 1; j >= N - K; j--){
                int sum = A[i] + B[j];
                if(pq.size() < K){
                    pq.add(sum);
                }
                else {
                    if(pq.peek() < sum){
                        pq.remove();
                        pq.add(sum);
                    }
                    else break;
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        
        while(pq.size() > 0){
            result.add(0, pq.poll());
        }
        
        return result;
    }
}
