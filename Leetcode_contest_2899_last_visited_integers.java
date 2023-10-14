class Solution {
    public List<Integer> lastVisitedIntegers(List<String> words) {
        ArrayList<Integer> list = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int c = 0;
        for (int i = 0; i < words.size(); i++) {
            if (!words.get(i).equals("prev")) {
                    c = 0;
                    int number = Integer.parseInt(words.get(i));
                    list.add(number);
            
            } else {
                c++;
                if (list.size() - c >= 0) {
                    result.add(list.get(list.size() - c));
                }
                else{
                    result.add(-1);
                }
            }
        }
        
        for(int i = 0; i < list.size(); i++) System.out.println(list.get(i));
        return result;
    }
}