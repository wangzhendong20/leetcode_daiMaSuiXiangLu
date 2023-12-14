import java.util.*;

public class hard127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>();
        for (String word : wordList) {
            wordSet.add(word);
        }
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {  //特殊情况判断
            return 0;
        }
        Deque<String> queue = new LinkedList<>();
        HashMap<String,Integer> map = new HashMap<>();
        queue.offer(beginWord);
        map.put(beginWord,1);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            int path = map.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] wordChar = word.toCharArray();
                for (char k = 'a'; k <= 'z'; k++) {
                    wordChar[i] = k;
                    String newWord = String.valueOf(wordChar);
                    if (newWord.equals(endWord)) return path + 1;
                    if (wordSet.contains(newWord) && !map.containsKey(newWord)) {
                        map.put(newWord,path+1);
                        queue.offer(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
