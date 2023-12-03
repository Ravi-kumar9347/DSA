class Solution
{
	public static int countPairs(Node root1, Node root2, int x)
	{
	    //O(N)
	    //S(N)
		HashSet<Integer> set = new HashSet<>();
		fun(root1, x, set);
		
		int ans = 0;
		Queue<Node> q = new LinkedList<>();
		q.add(root2);
		while(!q.isEmpty()){
		    Node root = q.poll();
		    if(set.contains(root.data)){
		        ans++;
		    }
		    
		    if(root.left != null) q.add(root.left);
		    if(root.right != null) q.add(root.right);
		}
		
		return ans;
	}
	
	private static void fun(Node root, int x, HashSet<Integer> set){
	    if(root == null) return;
	    set.add(x - root.data);
	    fun(root.left, x, set);
	    fun(root.right, x, set);
	}
}