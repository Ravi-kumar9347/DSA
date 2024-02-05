class Node {
    Node[] links = new Node[2];

    boolean containsKey(int ind) {
        return (links[ind] != null);
    }

    Node get(int ind) {
        return links[ind];
    }

    void put(int ind, Node node) {
        links[ind] = node;
    }
}

class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int findMax(int num) {
        Node node = root;
        int maxNum = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                maxNum = maxNum | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[][] offlineQueries = new int[q][3];
        for (int i = 0; i < q; i++) {
            offlineQueries[i][0] = queries[i][1];
            offlineQueries[i][1] = queries[i][0];
            offlineQueries[i][2] = i;
        }

        Arrays.sort(offlineQueries, Comparator.comparingInt(a -> a[0]));
        Arrays.sort(nums);

        Trie trie = new Trie();
        int j = 0;
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int curNum = offlineQueries[i][0];
            while (j < n && nums[j] <= curNum) {
                trie.insert(nums[j]);
                j++;
            }

            if(j != 0) result[offlineQueries[i][2]] = trie.findMax(offlineQueries[i][1]);
            else result[offlineQueries[i][2]] = -1;
            
        }

        return result;
    }
}
