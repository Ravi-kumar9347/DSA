
class Solution 
{
        //O(min(a.length(), b.length()) + n + m), where n and m are the lengths of 'a' and 'b'.
        // S(min(a.length(), b.length()) + max(a.length() + b.length(), s.length() + c.length()) + 6)
    // Function to merge two strings by removing common characters
    public static String mergeStrings(String a, String b) 
    {
        String commonCharacters = "";
        int minLength = Math.min(a.length(), b.length());

        // Find common characters at the end of string 'a' and the beginning of string 'b'
        for (int i = 1; i <= minLength; i++) 
        {
            if (a.substring(a.length() - i).equals(b.substring(0, i)))
                commonCharacters = a.substring(a.length() - i);
        }

        // Merge the strings by removing the common characters
        String mergedString = a + b.substring(commonCharacters.length());

        return mergedString;
    }

    // Function to find the shortest superstring among 'a', 'b', and 'c'
    public String shortestSuperstring(String a, String b, String c)
    {
        // Check if 'a' contains 'b' as a substring, if yes, directly return 'a'
        // Otherwise, merge 'a' and 'b' to find the merged string 's'
        String s = a.contains(b) ? a : mergeStrings(a, b);

        // Check if 's' contains 'c' as a substring, if yes, directly return 's'
        // Otherwise, merge 's' and 'c' to find the final shortest superstring
        return s.contains(c) ? s : mergeStrings(s, c);
    }

    // Function to find the minimum superstring among permutations of 'a', 'b', and 'c'
    public String minimumString(String a, String b, String c) 
    {
        ArrayList<String> ls = new ArrayList<>();

        // Get all possible superstrings using different permutations of 'a', 'b', and 'c'
        ls.add(shortestSuperstring(a, b, c));
        ls.add(shortestSuperstring(a, c, b));
        ls.add(shortestSuperstring(b, a, c));
        ls.add(shortestSuperstring(b, c, a));
        ls.add(shortestSuperstring(c, a, b));
        ls.add(shortestSuperstring(c, b, a));

        // Debug: Print all possible superstrings
        System.out.println(ls);

        // Sort the superstrings based on length and lexicographical order
        Collections.sort(ls, (p, q) -> {
            if (p.length() != q.length()) 
                return p.length() - q.length();
            else
                return p.compareTo(q);
        });

        // Return the minimum superstring, which is the first element in the sorted list
        return ls.get(0);
    }
}