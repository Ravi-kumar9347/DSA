

// User function Template for Java

class Solution {

    Vector<Integer> generateNextPalindrome(int num[], int n) {
        // code here
           Vector<Integer> ans=new Vector<>();
           if(search(num, n)){
           ans.add(1);
           
           for(int i=0;i<n-1;i++){
               ans.add(0);
           }
           ans.add(1);
       }
       else{
           generateNextPalindromeUtil(num, n);
           for(int i=0;i<n;i++){
               ans.add(num[i]);
           }
       }
       return ans;
   }
   
   void generateNextPalindromeUtil(int num[] , int n){
       
       int mid = n / 2;
       int i = mid - 1;
       int j = (n % 2 == 0) ? mid : mid + 1;
       boolean leftsmaller = false;
      
       while (i >= 0 && num[i] == num[j]) {
           i--;
           j++;
       }
      
       if (i < 0 || num[i] < num[j]){
           leftsmaller = true;
       }
      
       while (i >= 0){
           num[j++] = num[i--];
       }
       
       if (leftsmaller) {
           int carry = 1;
          
           if (n % 2 == 1) {
               num[mid] += 1;
               carry = num[mid] / 10;
               num[mid] %= 10;
           }
           i = mid - 1;
           j = (n % 2 == 0 ? mid : mid + 1);
           
           while (i >= 0) {
               num[i] = num[i] + carry;
               carry = num[i] / 10;
               num[i] %= 10;
               num[j] = num[i];
               i--;
               j++;
           }
       }
   }
   boolean search(int num[], int n) {

       for (int i = 0; i < n; i++)
           if (num[i] != 9){
               return false;
           }
       return true;
    }
}