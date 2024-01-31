class Node{
    Node[] list = new Node[26];
    boolean flag = false;

    boolean isContains(char c){
        return list[c - 'a'] != null;
    }

    void put(char c, Node node){
        list[c - 'a'] = node;
    }

    Node get(char c){
        return list[c - 'a'];
    }
}

class Trie {
    static Node root;

    public Trie() {
        root = new Node();
    }
    
    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.isContains(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }

            node = node.get(word.charAt(i));
        }

        node.flag = true;
    }
    
    public boolean search(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.isContains(word.charAt(i))){
                return false;
            }

            node = node.get(word.charAt(i));
        }

        return node.flag;
    }
    
    public boolean startsWith(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.isContains(word.charAt(i))){
                return false;
            }

            node = node.get(word.charAt(i));
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */