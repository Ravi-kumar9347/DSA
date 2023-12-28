class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        //O(nlogn) + O(N*M)
        //S(M) -> M = max deadline
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for(int i = 0; i < n; i++){
            if(maxDeadline < arr[i].deadline){
                maxDeadline = arr[i].deadline;
            }
        }
        
        int[] deadlinearr = new int[maxDeadline + 1];
        Arrays.fill(deadlinearr, -1);
        
        int count = 0, profit = 0;
        for(int i = 0; i < n; i++){
            for(int j = arr[i].deadline; j > 0; j--){
                if(deadlinearr[j] == -1){
                    deadlinearr[j] = arr[i].id;
                    count++;
                    profit += arr[i].profit;
                    break;
                }
            }
        }
        
        int[] result = {count, profit};
        return result;
    }
}

/*
class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}