class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int[] info : edges) {
            int from = info[0];
            int to = info[1];
            int d = info[2];
            list.get(from).add(new int[] { to, d });
            list.get(to).add(new int[] { from, d });

        }

        int[] citiesNBR = new int[n];

        for (int i = 0; i < n; i++) {

            int[] distance = new int[n];
            Arrays.fill(distance, Integer.MAX_VALUE);
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.offer(new int[] { i, 0 });
            distance[i] = 0;

            while (!pq.isEmpty()) {
                int[] info = pq.poll();
                int node = info[0];
                int dist = info[1];

                if (dist > distance[node])
                    continue;
                for (int[] arr : list.get(node)) {
                    int nbr = arr[0];
                    int nbd = arr[1];
                    if(dist + nbd<=distanceThreshold && dist + nbd<=distance[nbr] ){
                        pq.offer(new int[] { nbr, dist + nbd });
                        distance[nbr] = dist + nbd;
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                if (distance[j] <= distanceThreshold) {
                    citiesNBR[i]++;
                }
            }
        }

        int minNbr = Integer.MAX_VALUE;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            if (minNbr >= citiesNBR[i]) {
                minNbr = citiesNBR[i];
                idx = i;
            }
        }
        return idx;
    }
}