
class Solution
{
    public ArrayList<String> permutation(String S)
    {
        //O(N * N!)
        //S(1)
        ArrayList<String> ans = new ArrayList<>();
        backtrack(0, S.toCharArray(), ans);
        Collections.sort(ans);
        return ans;
    }
       
    private void backtrack(int ind, char[] s, ArrayList<String> ans)
    {
        if (ind == s.length)
        {
            ans.add(new String(s));
            return;
        }

        for (int i = ind; i < s.length; i++)
        {
            swap(i, ind, s);
            backtrack(ind + 1, s, ans);
            swap(i, ind, s);
        }
    }

    private void swap(int i, int ind, char[] s)
    {
        char c = s[i];
        s[i] = s[ind];
        s[ind] = c;
    }
}
