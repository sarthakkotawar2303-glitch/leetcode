import java.util.*;

class DisJointSet {
    int[] parent;
    int[] unionBySize;

    DisJointSet(int n) {
        parent = new int[n];
        unionBySize = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            unionBySize[i] = 1;
        }
    }

    public void Union(int a, int b) {
        int parentA = findParent(a);
        int parentB = findParent(b);

        if (parentA == parentB) return;

        if (unionBySize[parentA] < unionBySize[parentB]) {
            parent[parentA] = parentB;
            unionBySize[parentB] += unionBySize[parentA];
        } else {
            parent[parentB] = parentA;
            unionBySize[parentA] += unionBySize[parentB];
        }
    }

    public int findParent(int a) {
        if (parent[a] == a)
            return a;
        return parent[a] = findParent(parent[a]); // Path compression
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet ds = new DisJointSet(n);
        HashMap<String, Integer> map = new HashMap<>();

        // Step 1: Map emails to account IDs and union overlapping accounts
        for (int i = 0; i < n; i++) {
            int m = accounts.get(i).size();
            for (int j = 1; j < m; j++) {
                String mail = accounts.get(i).get(j);
                if (!map.containsKey(mail)) {
                    map.put(mail, i);
                } else {
                    int node = map.get(mail);
                    ds.Union(node, i);
                }
            }
        }

        // Step 2: Group emails by their absolute representative parent component
        List<List<String>> group = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            group.add(new ArrayList<>());
        }

        for (String mail : map.keySet()) {
            int accountIndex = map.get(mail);
            int rootParent = ds.findParent(accountIndex);
            group.get(rootParent).add(mail);
        }

        // Step 3: Format the final output (Sort emails and append names)
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (group.get(i).isEmpty()) {
                continue; // Skip empty groups
            }

            Collections.sort(group.get(i)); // Emails must be sorted
            
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0)); // Add account owner's name
            temp.addAll(group.get(i));        // Add sorted emails
            ans.add(temp);
        }

        return ans;
    }
}
