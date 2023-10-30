class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        //O(N1) + O(N2)
        //S(1)
        int n1 = nums1.length, n2 = nums2.length, c1 = 0, c2 = 0;
        long sum1 = 0, sum2 = 0;
        for(int i = 0; i < n1; i++){
            sum1 += nums1[i];
            if(nums1[i] == 0){
                c1++;
            }
        }
        
        for(int i = 0; i < n2; i++){
            sum2 += nums2[i];
            if(nums2[i] == 0){
                c2++;
            }
        }
        System.out.println(sum1);
        System.out.println(c1);
        System.out.println(sum2);
        System.out.println(c2);
        sum1 += c1;
        sum2 += c2;
        
        if(sum1 == sum2) return sum1;
        if(sum1 < sum2 && c1 != 0) return sum2;
        if(sum2 < sum1 && c2 != 0) return sum1;
        return -1;
        
    }
}