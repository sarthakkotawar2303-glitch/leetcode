class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        // We need at least 3 nodes to have a critical point
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        int firstCriticalIndex = -1;
        int lastCriticalIndex = -1;
        int minDistance = Integer.MAX_VALUE;

        ListNode prev = head;
        ListNode curr = head.next;
        int currentIndex = 2; // 1-indexed, so head is 1, head.next is 2

        while (curr.next != null) {
            ListNode nextNode = curr.next;

            // Check if current node is a local maximum or local minimum
            boolean isLocalMaximum = curr.val > prev.val && curr.val > nextNode.val;
            boolean isLocalMinimum = curr.val < prev.val && curr.val < nextNode.val;

            if (isLocalMaximum || isLocalMinimum) {
                // If this is the first critical point we've ever found
                if (firstCriticalIndex == -1) {
                    firstCriticalIndex = currentIndex;
                } else {
                    // Update the minimum distance between adjacent critical points
                    minDistance = Math.min(minDistance, currentIndex - lastCriticalIndex);
                }
                // Update the most recently found critical point
                lastCriticalIndex = currentIndex;
            }

            // Move to the next triplet
            prev = curr;
            curr = nextNode;
            currentIndex++;
        }

        // If we found fewer than 2 critical points, return [-1, -1]
        if (firstCriticalIndex == lastCriticalIndex) {
            return new int[]{-1, -1};
        }

        int maxDistance = lastCriticalIndex - firstCriticalIndex;
        return new int[]{minDistance, maxDistance};
    }
}
