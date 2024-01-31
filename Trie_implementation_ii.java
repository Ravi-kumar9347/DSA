import java.util.* ;
import java.io.*; 

class Node{
    Node[] list = new Node[26];
    int endsWith = 0;
    int startsWith = 0;

    boolean containskey(char c){
        return list[c - 'a'] != null;
    }

    void put(char c, Node node){
        list[c - 'a'] = node;
    }

    Node get(char c){
        return list[c - 'a'];
    }

    void incrementStart(){
        startsWith++;
    }

    void incrementEnd(){
        endsWith++;
    }

    int getEnd(){
        return endsWith;
    }

    int getStart(){
        return startsWith;
    }

    void decrementStart(){
        startsWith--;
    }

    void decrementEnd(){
        endsWith--;
    }
}
public class Trie {
    static Node root;
    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containskey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.incrementStart();
        }

        node.incrementEnd();
    }

    public int countWordsEqualTo(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containskey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }

        return node.getEnd();
    }

    public int countWordsStartingWith(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            if(!node.containskey(word.charAt(i))){
                return 0;
            }
            node = node.get(word.charAt(i));
        }

        return node.getStart();
    }

    public void erase(String word) {
        Node node = root;
        for(int i = 0; i < word.length(); i++){
            node = node.get(word.charAt(i));
            node.decrementStart();
        }

        node.decrementEnd();
    }

}
