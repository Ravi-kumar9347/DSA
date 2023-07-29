class Tree
{
    //O(N)
    //S(N)
    public static float findMedian(Node root)
    {
        List<Node> inOrder = new ArrayList<>();
        funInOrder(root, inOrder);
        
        int n = inOrder.size();
        float ans = 0;
        if(n % 2 == 1){
            ans = (float) inOrder.get(n / 2).data;
        }
        else{
            ans = (float) (inOrder.get(n / 2).data + inOrder.get((n / 2) - 1).data) / 2;
        }
        
        return ans;
    }
    
    private static void funInOrder(Node root, List<Node> inOrder){
        if(root == null) return;
        
        funInOrder(root.left, inOrder);
        inOrder.add(root);
        funInOrder(root.right, inOrder);
        
        return;
    }
}

    //O(N)
    //S(1)
// class Tree {
//     private static int count;

//     public static float findMedian(Node root) {
//         count = 0;
//         int totalNodes = countNodes(root);

//         if (totalNodes % 2 == 1) {
//             return findKthNode(root, (totalNodes + 1) / 2);
//         } else {
//             return (findKthNode(root, totalNodes / 2) + findKthNode(root, totalNodes / 2 + 1)) / 2.0;
//         }
//     }

//     private static int countNodes(Node root) {
//         if (root == null)
//             return 0;
//         return countNodes(root.left) + countNodes(root.right) + 1;
//     }

//     private static int findKthNode(Node root, int k) {
//         if (root == null)
//             return 0;

//         int leftCount = countNodes(root.left);

//         if (k == leftCount + 1)
//             return root.data;
//         else if (k <= leftCount)
//             return findKthNode(root.left, k);
//         else
//             return findKthNode(root.right, k - leftCount - 1);
//     }
// }