import java.util.List;
import java.util.*;
public class Solution{
    public static List< Integer > printDivisors(int n) {
        //O(sqrt(N))
        //S(1)
        List<Integer> result = new ArrayList<>();
        int j = 0;
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                result.add(j, i);
                j++;
                if(i == (n / i)) continue;
                result.add(j, n / i);
            }
        }

        return result;
    }
}