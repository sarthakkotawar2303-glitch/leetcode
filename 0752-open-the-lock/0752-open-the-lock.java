import java.util.*;

class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>(Arrays.asList(deadends));

        // to avoid infinite loop
        Set<String> visited = new HashSet<>();

        // using bfs algo to find in turn to unlock
        Queue<String> q = new LinkedList<>();
        int turns = 0;
        String current = "0000";

        if (dead.contains(current)) return -1;
        if (target.equals(current)) return turns;
        q.offer(current);
        visited.add("0000");

        while (!q.isEmpty()) {
            int size = q.size();
            
            // iterating the neighbours 
            for (int i = 0; i < size; i++) {
                String curr = q.poll();
                if (target.equals(curr)) return turns;

                for (int j = 0; j < 4; j++) {
                    
                    // --- 1. UPWARD SPIN (+1) ---
                    char[] charsUp = curr.toCharArray(); 
                    char currCharUp = charsUp[j];
                    charsUp[j] = currCharUp == '9' ? '0' : (char)(currCharUp + 1); 
                    String upward = new String(charsUp);

                    if (!dead.contains(upward) && !visited.contains(upward)) {
                        visited.add(upward);
                        q.offer(upward);
                    }

                    // --- 2. DOWNWARD SPIN (-1) ---
                    char[] charsDown = curr.toCharArray(); 
                    char currCharDown = charsDown[j];
                    // FIXED: charsDown ki jagah currCharDown use kiya aur proper brackets lagaye
                    charsDown[j] = currCharDown == '0' ? '9' : (char)(currCharDown - 1); 
                    String downward = new String(charsDown);

                    if (!dead.contains(downward) && !visited.contains(downward)) {
                        visited.add(downward);
                        q.offer(downward);
                    }
                }
            }
            turns++;
        }
        return -1;
    }
}

