
class GFG
{
    ArrayList<Integer> find(int arr[], int n, int x)
    {
        //O(logN)
        //S(1)
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        int lb = lowerBound(arr, n, x);
        
        int ub = upperBound(arr, n, x);
        
        result.add(lb);
        result.add(ub);
        
        return result;
    }
    
    private int lowerBound(int arr[], int n, int x){
        int low = 0, high = n - 1;
        int lb = -1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[mid] == x){
                lb = mid;
                high = mid - 1;
            }
            else if(arr[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return lb;
    }
    
    private int upperBound(int arr[], int n, int x){
        int low = 0, high = n - 1;
        int ub = -1;
        
        while(low <= high){
            int mid = (low + high) / 2;
            
            if(arr[mid] == x){
                ub = mid;
                low = mid + 1;
            }
            else if(arr[mid] < x){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        
        return ub;
    }
}

