class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);

        if (endWord.equals(beginWord))
            return 0;

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);
        int level = 1;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                String currentWord = q.poll();

                if (endWord.equals(currentWord))
                    return level;

                char[] currentWordArray = currentWord.toCharArray();
                for (int j = 0; j < currentWordArray.length; j++) {
                    char orignalChar=currentWordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                         if(c==currentWordArray[j]) continue;

                         currentWordArray[j]=c;
                         String newWord=String.valueOf(currentWordArray);

                         if(set.contains(newWord)){
                            q.offer(newWord);
                            set.remove(newWord);
                         }
                    }
                    currentWordArray[j]=orignalChar;
                }

            }
            level++;
        }
       return 0;
    }
}