class Isomorphic{
    public static boolean areIsomorphic(String S1,String S2)
    {
        //O(N)
        //S(1)
        int len1,len2;
        len1 = S1.length();
        len2 = S2.length();
        if(len1!=len2)
            return false;
        else
        {
            int map[] = new int[256];
            int traverse[] = new int[256];
            int i;
            Arrays.fill(map,-1);
            Arrays.fill(traverse,0);
            for(i=0;i<len1;i++)
            {
                if(map[S1.charAt(i)]==-1)
                {
                    if(traverse[S2.charAt(i)]!=0)
                        return false;
                    traverse[S2.charAt(i)] = 1;
                    map[S1.charAt(i)] = S2.charAt(i);
                }
                else
                {
                    if(map[S1.charAt(i)]!=S2.charAt(i))
                        return false;
                }
            }
        }
        return true;
        
    }
}