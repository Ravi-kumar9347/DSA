class Solution {
    boolean checkTriplet(int[] arr, int n) {
        //Expected Time Complexity: O(n+max(Arr[i])2)
        //Expected Auxiliary Space: O(max(Arr[i]))
        ArrayList<Double> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(!list.contains(Double.valueOf(arr[i]))){
                list.add(Double.valueOf(arr[i]));
            }
        }
        
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size(); j++){
                double a = list.get(i) * list.get(i);
                double b = list.get(j) * list.get(j);
                if(list.contains(Math.sqrt(a + b))) return true;
            }
        }
        
        return false;
    }
}