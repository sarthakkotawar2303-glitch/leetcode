import java.util.*;

class Solution {
    // 1. Store the original one-way roads as text strings (e.g., "parent,child")
    private Set<String> originalRoads;
    
    // 2. Map to find all neighboring cities (treating roads as two-way for walking)
    private List<List<Integer>> adjacencyList;
    
    private boolean[] visited;
    private int flipCount;

    public int minReorder(int n, int[][] connections) {
        originalRoads = new HashSet<>();
        adjacencyList = new ArrayList<>();
        visited = new boolean[n];
        flipCount = 0;

        // Initialize lists for each city
        for (int i = 0; i < n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        // Build our map structures
        for (int[] road : connections) {
            int fromCity = road[0];
            int toCity = road[1];
            
            // Save the exact original direction
            originalRoads.add(fromCity + "," + toCity); 
            
            // Allow us to walk between them in either direction during inspection
            adjacencyList.get(fromCity).add(toCity); 
            adjacencyList.get(toCity).add(fromCity); 
        }

        // Start checking the tree from the top leader (City 0)
        visited[0] = true;
        checkFamilyTree(0);

        return flipCount;
    }

    private void checkFamilyTree(int parent) {
        // Look at all cities connected to this parent
        for (int child : adjacencyList.get(parent)) {
            
            // If we already visited this city, it means it is an ancestor. Skip it!
            if (visited[child]) {
                continue;
            }

            // RULE: The road MUST point from Child -> Parent to flow toward City 0.
            // If that correct road does NOT exist, it means the real road points from Parent -> Child.
            if (!originalRoads.contains(child + "," + parent)) {
                flipCount++; // Wrong direction! We must flip it.
            }

            // Mark this child as visited and check its own children down the line
            visited[child] = true;
            checkFamilyTree(child); // The current child now acts as the parent for the next step
        }
    }
}
