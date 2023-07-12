

import java.io.*;
import java.util.*;


class Solution{
    
    public static boolean isHappyNumber(int num){
        //O(NlogN) S(1)
        Set<Integer> visited = new HashSet<>();
        while(num != 1){
            num = sumOfSquares(num);
            if(visited.contains(num)){
                return false;
            }
            visited.add(num);
        }
        return true;
    }
    
    public static int sumOfSquares(int num){
        int sum =0;
        while(num>0){
            int digit = num%10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }

    static int nextHappy(int N){
        N += 1;
        while(true){
            if(isHappyNumber(N)){
                return N;
            }
            N += 1;
        }
    }
}