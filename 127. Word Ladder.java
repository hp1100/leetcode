class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>();
        for(String word: wordList)
            words.add(word);
        
        if(beginWord.equals(endWord))
            return 1;
        
        Set<String> set = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        set.add(beginWord);
        
        int length = 1;
        while(!queue.isEmpty()){
            length++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String word = queue.poll();
                for(String nextWord : getNextWords(word, words)){
                    if(set.contains(nextWord))
                        continue;
                    if(nextWord.equals(endWord))
                        return length;
                    set.add(nextWord);
                    queue.offer(nextWord);
                }
            }
        }
        
        return 0;
    }
    
    private List<String> getNextWords(String word, Set<String> words){
        List<String> nextWords = new ArrayList<String>();
        for (char c = 'a'; c <= 'z'; c++) {
            for (int i = 0; i < word.length(); i++) {
                if (c == word.charAt(i)) {
                    continue;
                }
                String nextWord = replace(word, i, c);
                if (words.contains(nextWord)) {
                    nextWords.add(nextWord);
                }
            }
        }
        return nextWords;
    }
    
    private String replace(String s, int index, char c) {
        char[] chars = s.toCharArray();
        chars[index] = c;
        return new String(chars);
    }
    
}
