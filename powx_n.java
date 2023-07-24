class Solution {
    public double myPow(double x, int n) {
        //O(log n)
        //S(1)
        // double ans=1.0;
        // long nn=n;
        // if(nn<0){
        //     nn= -1 * nn;
        // }

        // while(nn!=0) { 
        //     if(nn%2==1){
        //         ans=ans*x;
        //         nn--;
        //     }else{
        //         x=x*x;
        //         nn=nn/2;
        //     }
        // }
        // if(n<0) ans=(double)(1.0)/(double)(ans);
        // return ans;
        double ans = fun(x, n);

        return (n < 0) ? (1 / ans) : ans;
    }

    double fun(double x, int n){
        if(n == 0) return 1;
        if(n == 1) return x;

        double ans = fun(x, n/2);
        if(n % 2 == 0){
            ans = ans * ans;
        }
        else{
            ans = ans * ans * x;
        }
        return ans;
    }
}