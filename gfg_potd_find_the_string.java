class Solution{
    int K, N; // Variables to store the value of K and N
    long tot; // Variable to store the total number of possible combinations
    HashSet<String> st = new HashSet<>(); // HashSet to store visited combinations
    String ans; // Variable to store the final combination

    boolean dfs() {
        if(st.size() == tot) { // If all combinations are visited, return true
            return true;
        }

        String tmp = "";
        if(N > 1) {
            tmp = ans.substring(ans.length()-N+1); // Get the last N-1 digits of the current combination
        }

        for(int i = 0; i < K; i++)
        {
            tmp += i; // Append the current digit to the last N-1 digits of the current combination
            if(!st.contains(tmp)) {
                ans += i; // Append the current digit to the final combination
                st.add(tmp); // Add the current combination to the visited combinations
                if(dfs())
                    return true; // If a valid combination is found, return true
                st.remove(tmp); // Remove the current combination from the visited combinations
                ans = ans.substring(0, ans.length()-1); // Remove the last digit from the final combination
            }
            tmp = tmp.substring(0, tmp.length()-1); // Remove the last digit from the last N-1 digits of the current combination
        }

        return false; // If no valid combination is found, return false
    }

    public String findString(int n, int k){
       K = k; // Assign the value of k to the variable K
       N = n; // Assign the value of n to the variable N
       st.clear(); // Clear the visited combinations HashSet
       if(n == 1) { // If n is 1, return a string of digits from 0 to k-1
        char[] r = new char[k];
        for(int i = 0; i < k; i++)
            r[i] =(char)(i + '0');
        return new String(r);
       }
       tot=1;
       for(int i = 1; i <= n; i++)
            tot = (tot*k); // Calculate the total number of possible combinations
        char[] ansa = new char[n]; // Create a character array to store the final combination
        Arrays.fill(ansa, '0'); // Initialize the array with '0'
        ans = new String(ansa); // Convert the array to a string
        st.add(ans); // Add the initial combination to the visited combinations
        dfs(); // Call the dfs function to find the final combination
        return ans; // Return the final combination
    }
}