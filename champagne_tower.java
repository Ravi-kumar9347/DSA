class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        //O(query_row * query_row)
        //S(query_row)
        double[] currentLevel = new double[1];
        currentLevel[0] = (double)poured;

        for(int row  = 0; row < query_row; row++){
            double[] nextLevel = new double[row + 2];
            for(int glass = 0; glass < currentLevel.length; glass++){
                double overFlow = (currentLevel[glass] - 1.0) / 2.0;
                if(overFlow > 0.0){
                    nextLevel[glass] += overFlow;
                    nextLevel[glass + 1] += overFlow;
                }
            }
            currentLevel = nextLevel;
        }

        return Math.min(1.0, currentLevel[query_glass]);
    }
}