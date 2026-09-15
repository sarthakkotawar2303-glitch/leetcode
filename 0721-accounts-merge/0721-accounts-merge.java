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

        return parent[a] = findParent(parent[a]);
    }
}

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet ds = new DisJointSet(n);

        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int m = accounts.get(i).size();

            for (int j = 1; j < m; j++) {
                if (!map.containsKey(accounts.get(i).get(j))) {
                    map.put(accounts.get(i).get(j), i);
                } else {
                    int node = map.get(accounts.get(i).get(j));
                    ds.Union(node, i);
                }
            }
        }

        List<List<String>> group = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            group.add(new ArrayList<>());
        }

        for (String mail : map.keySet()) {
            int accountIndex = map.get(mail);
            int rootParent = ds.findParent(accountIndex);
            group.get(rootParent).add(mail);
        }

      

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (group.get(i).isEmpty())
                continue;

            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            Collections.sort(group.get(i));
            for (String s : group.get(i)) {
                temp.add(s);
            }
            ans.add(temp);
        }

        return ans;
    }
}