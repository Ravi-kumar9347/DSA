
class CharCount {
    int count;
    char ch;

    CharCount(int count, char ch) {
        this.count = count;
        this.ch = ch;
    }
}

class Solution {
    public String frequencySort(String s) {

        //O(N log K) //S(N+k)
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char ch : s.toCharArray()) {
            frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<CharCount> priorityQueue = new PriorityQueue<>((a, b) -> b.count - a.count);

        for (char ch : frequencyMap.keySet()) {
            priorityQueue.offer(new CharCount(frequencyMap.get(ch), ch));
        }

        StringBuilder sb = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            CharCount cc = priorityQueue.poll();
            for (int i = 0; i < cc.count; i++) {
                sb.append(cc.ch);
            }
        }

        return sb.toString();

        
    }
}
