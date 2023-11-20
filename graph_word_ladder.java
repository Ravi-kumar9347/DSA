
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //O(N*M*26)
        //S(N)
        Set<String> wordSet = new HashSet<>();
        Queue<Pair> q = new LinkedList<>();
        for(String word : wordList) wordSet.add(word);
        q.add(new Pair(beginWord, 1));
        wordSet.remove(beginWord);

        while (!q.isEmpty()) {
            Pair p = q.poll();
            String word = p.word;
            int steps = p.steps;
            if (word.equals(endWord)) {
                return steps;
            }
            for (int i = 0; i < word.length(); i++) {
                StringBuilder s = new StringBuilder(word);
                for (int j = 0; j < 26; j++) {
                    char replacementChar = (char)('a' + j);
                    s.setCharAt(i, replacementChar);
                    String transformedWord = s.toString();
                    if (wordSet.contains(transformedWord)) {
                        wordSet.remove(transformedWord);
                        q.add(new Pair(transformedWord, steps + 1));
                    }
                }
            }
        }

        return 0;
    }
}

class Pair {
    String word;
    int steps;

    Pair(String word, int steps) {
        this.word = word;
        this.steps = steps;
    }
}
