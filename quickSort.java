class Solution {
    // Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high) {
        if (low < high) {
            // Partition the array using Hoare partition scheme.
            int pivotIndex = partition(arr, low, high);
            
            // Sort the left partition
            quickSort(arr, low, pivotIndex);
            
            // Sort the right partition
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    static int partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low - 1;
        int j = high + 1;
        
        while (true) {
            do {
                i++;
            } while (arr[i] < pivot);
            
            do {
                j--;
            } while (arr[j] > pivot);
            
            if (i >= j) {
                return j;
            }
            
            swap(arr, i, j);
        }
    }
    
    static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
