class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        //use Map to store (i+j) -> level size in list -> O(N) S(N)
        //use bfs -> O(N) S(sqrt(N))
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0));
        int size = 0;
        for(List<Integer> list : nums){
            size += list.size();
        }
        int result[] = new int[size];
        int k = 0;
        while(!q.isEmpty()){
            Pair p = q.peek();
            q.poll();
            int i = p.row, j = p.col;
            result[k++] = nums.get(i).get(j);
            if(j == 0 && i + 1 < nums.size()){
                q.add(new Pair(i+1, j));
            }
            if(j + 1 < nums.get(i).size()){
                q.add(new Pair(i, j + 1));
            }
        }

        return result;
    }
}

class Pair{
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}