
class Solution {
    static ArrayList<ArrayList<Integer>> transitiveClosure(int N, int graph[][]) {
        //O(N^3)
        //S(N^2)
        ArrayList<ArrayList<Integer>> transitive = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            transitive.add(new ArrayList<>());
            for (int j = 0; j < N; j++) {
                transitive.get(i).add(graph[i][j]);
            }
        }

        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i == j || (transitive.get(i).get(j) == 1) || (transitive.get(i).get(k) == 1 && transitive.get(k).get(j) == 1)) {
                        transitive.get(i).set(j, 1);
                    }
                }
            }
        }

        return transitive;
    }
}
