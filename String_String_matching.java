
class Solution {
    public int strStr(String haystack, String needle) {
        // return rabikarpAlgo(haystack, needle);
        // return zfunction(haystack, needle);
        return kmp(haystack, needle);
    }

    static int kmp(String haystack, String needle){
        //O(N+M)
        //S(M)
        int m = haystack.length(), n = needle.length();
        int[] lps = fillLPS(needle);
        int i = 0, j = 0;
        while(i < m){
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
            }
            else{
                if(j == 0){
                    i++;
                }
                else{
                    j = lps[j - 1];
                }
            }

            if(j == n){
                return i - n;
            }
        }

        return -1;
    }

    static int[] fillLPS(String s){
        int n = s.length();
        int[] lps = new int[n];
        int j = 0, i = 1;
        while(i < n){
            if(s.charAt(j) == s.charAt(i)){
                j++;
                lps[i] = j; 
                i++;
            }
            else{
                if(j == 0){
                    i++;
                }
                else{
                    j = lps[j - 1];
                }
            }
        }
        return lps;
    }

    static int zfunction(String haystack, String needle){
        String concat = needle + "$" + haystack;
        int[] zarray = zcaluculte(concat);
        //stores list of all indexes at which needle is present in haystack;
        List<Integer> result = new ArrayList<>();
        for(int i = needle.length() + 1; i < zarray.length; i++){
            if(zarray[i] == needle.length()){
                result.add(i - needle.length() - 1);
            }
        }

        return result.size() == 0 ? -1 : result.get(0);
    }

    static int[] zcaluculte(String concat){
        //O(N+M+1)
        int n = concat.length();
        int left = 0, right = 0;
        int[] z = new int[n];

        for(int k = 1; k < n; k++){
            if(k > right){
                left = right = k;
                while(right < n && concat.charAt(right) == concat.charAt(right - left)){
                    right++;
                }
                z[k] = right - left;
                right--;
            }
            else{
                int k1 = k - left;

                if(z[k1] < right - k + 1){
                    z[k] = z[k1];
                }
                else{
                    left = k;
                    while(right < n && concat.charAt(right) == concat.charAt(right - left)){
                        right++;
                    }
                    z[k] = right - left;
                    right--;
                }
            }
        }

        return z;
    }

    static int rabikarpAlgo(String haystack, String needle){
        //O(N-M+1 * M) -> in worst case
        int M = needle.length(); 
        int N = haystack.length();
		
		if(M>N)return -1;
		
        int i, j; 
        int p = 0; // hash value for needle 
        int t = 0; // hash value for haystack 
        int h = 1;
        int d= 256; // number of characters in the input alphabet 
        int q= 31; //a prime number

        char[] pat=needle.toCharArray();
        char[] txt=haystack.toCharArray();
        // The value of h would be "pow(d, M-1)%q" 
        for (i = 0; i < M - 1; i++) 
            h = (h * d) % q; 

        // Calculate the hash value of pattern and first 
        // window of text 
        for (i = 0; i < M; i++) { 
            p = (d * p + pat[i]) % q; 
            t = (d * t + txt[i]) % q; 
        } 

        // Slide the pattern over text one by one 
        for (i = 0; i <= N - M; i++) { 

            // Check the hash values of current window of text 
            // and pattern. If the hash values match then only 
            // check for characters on by one 
            if ( p == t ) { 
                /* Check for characters one by one */
                for (j = 0; j < M; j++) { 
                    if (txt[i+j] != pat[j]) 
                        break; 
                } 

                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1] 
                if (j == M) 
                    return i;
            } 

            // Calculate hash value for next window of text: Remove 
            // leading digit, add trailing digit 
            if ( i < N-M ) { 
                t = (d*(t - txt[i]*h) + txt[i+M])%q; 

                // We might get negative value of t, converting it 
                // to positive 
                if (t < 0) 
                t = (t + q); 
            } 
        }
        return -1;
    }
}