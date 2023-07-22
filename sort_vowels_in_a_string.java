class Solution {
    public String sortVowels(String s) {
        int size = s.length();
        Set<Character> set = new HashSet<>();
        set.add('A'); set.add('E'); set.add('I'); set.add('O'); set.add('U');
        set.add('a'); set.add('e'); set.add('i'); set.add('o'); set.add('u');
        
        List<Character> list = new ArrayList<>();
        for(int i = 0; i < size; i++){
            if(set.contains(s.charAt(i))){
                list.add(s.charAt(i));
            }
        }
        
        Collections.sort(list);
        
        String result = "";
        int j = 0;
        for(int i = 0; i < size; i++){
            if(set.contains(s.charAt(i))){
                result += list.get(j);
                j++;
            }
            else{
                result += s.charAt(i);
            }
        }
        
        return result;
    }
}