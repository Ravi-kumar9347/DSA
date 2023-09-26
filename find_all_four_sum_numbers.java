
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int total) {
        //O(N*N*N)
        //S(1)
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int n = arr.length;
        
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates
                if (j > i + 1 && arr[j] == arr[j - 1]) {
                    continue;
                }
                
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    int sum = arr[i] + arr[j] + arr[left] + arr[right];
                    
                    if (sum == total) {
                        ArrayList<Integer> quadruplet = new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        result.add(quadruplet);
                        
                        // Skip duplicates
                        while (left < right && arr[left] == arr[left + 1]) {
                            left++;
                        }
                        while (left < right && arr[right] == arr[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if (sum < total) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return result;
    }
}