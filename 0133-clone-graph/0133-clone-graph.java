/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        // Base case: If graph is empty
        if (node == null) {
            return null;
        }

        // HashMap to store (Original Node -> Cloned Node)
        Map<Node, Node> map = new HashMap<>();
        
        // Queue for BFS traversal (stores original nodes)
        Queue<Node> queue = new LinkedList<>();

        // Clone the starting node and map it
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);
        
        // Push the original starting node to the queue
        queue.add(node);

        // Standard BFS Loop
        while (!queue.isEmpty()) {
            Node curr = queue.poll();

            // Iterate through all neighbors of the current original node
            for (Node neighbor : curr.neighbors) {
                
                // If neighbor has not been cloned yet
                if (!map.containsKey(neighbor)) {
                    // Clone the neighbor
                    Node clonedNeighbor = new Node(neighbor.val);
                    map.put(neighbor, clonedNeighbor);
                    
                    // Add original neighbor to queue for processing later
                    queue.add(neighbor);
                }
                
                // Connect the cloned current node to the cloned neighbor
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        // Return the clone of the starting node
        return cloneNode;
    }
}
