class Solution {
    public static int maxHappy(int n, int[] bags, int m, int[] requirement) {
        //O(nlogn)
        //S(1)
        Arrays.sort(bags);
        Arrays.sort(requirement);
        
        int i = n - 1, j = m - 1;
        int count = 0;
        while(i >= 0 && j >= 0){
            if(bags[i] >= requirement[j]){
                i--;
                j--;
                count++;
            }
            else{
                j--;
            }
        }
        
        return count;
    }
}