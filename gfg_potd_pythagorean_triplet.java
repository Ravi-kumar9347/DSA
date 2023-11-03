
// class Solution {
//     boolean checkTriplet(int[] arr, int n) {
//         int maxi = -1;
//         for(int num : arr) maxi = Math.max(maxi, num);
        
//         int[] present = new int[maxi + 1];
//         for(int num : arr){
//             present[num] = 1;
//         }
        
//         for(int i = 1; i <= maxi; i++){
//             if(present[i] == 0){
//                 continue;
//             }
//             for(int j = 1; j <= maxi; j++){
//                 if(present[j] == 0 || i == j){
//                     continue;
//                 }
//                 int x = i * i;
//                 int y = j * j;
//                 int z = x + y;
//                 double zsqrt = Math.sqrt(z);
//                 if(zsqrt > maxi || z != (double)(zsqrt * zsqrt)){
//                     continue;
//                 }
//                 if(present[(int)zsqrt] == 1){
//                     return true;
//                 }
//             }
//         }
        
//         return false;
//     }
// }

class Solution {
    boolean checkTriplet(int[] arr, int n) {
        //Expected Time Complexity: O(n+max(Arr[i])2)
        //Expected Auxiliary Space: O(max(Arr[i]))
        TreeSet<Integer> a=new TreeSet<Integer>();
        for(int i=0;i<arr.length;i++)
        {
            a.add(arr[i]);
        }
        ArrayList<Integer> res=new ArrayList<Integer>();
        for(int x:a)
        {
            res.add(x);
        }
        TreeSet<Integer> hash=new TreeSet<Integer>();
        for(int i=0;i<res.size();i++)
        {
            if(hash.contains(res.get(i)*res.get(i))==true)
            {
                return true;
            }
            for(int j=i-1;j>=0;j--)
            {
                int value=res.get(j)*res.get(j)+res.get(i)*res.get(i);
                hash.add(value);
            }
        }
        return false;
    }
}