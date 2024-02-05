class Node{
    Node[] list = new Node[2];

    boolean containsKey(int ind){
        return list[ind] != null;
    }

    Node get(int ind){
        return list[ind];
    }

    void put(int ind, Node node){
        list[ind] = node;
    }
}

class Trie{
    private static Node root;

    Trie(){
        root = new Node();
    }

    public static void insert(int num){
        Node node = root;
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }

            node = node.get(bit);
        }
    }

    public static int getMax(int num){
        Node node = root;
        int maxNum = 0;
        for(int i = 31; i >= 0; i--){
            int bit = (num >> i) & 1;
            if(node.containsKey(1 - bit)){
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            }
            else{
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution {
    public int findMaximumXOR(int[] nums) {
        Trie t = new Trie();
        for(int num : nums){
            t.insert(num);
        } 

        int ans = 0;
        for(int num : nums){
            ans = Math.max(ans, t.getMax(num));
        }

        return ans;
    }
}