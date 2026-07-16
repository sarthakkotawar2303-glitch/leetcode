class Solution {
    public int minimumOperationsToMakeEqual(int x, int y) {
        if (x == y)
            return 0;
        Set<Integer> visited = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();

        q.offer(x);
        visited.add(x);
        int operations = 0;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int num = q.poll();

                if (num == y)
                    return operations;

                ArrayList<Integer> nums = new ArrayList<>();
                //divide by 11 if is it multiple of 11;
                if (num % 11 == 0) {
                    nums.add(num / 11);
                }
                //divide by 5 if is it multiple of 5;
                if (num % 5 == 0) {
                    nums.add(num / 5);
                }

                //Incement
                nums.add(num + 1);

                //Decement
                nums.add(num - 1);

                for (int n : nums) {
                    if (!visited.contains(n)) {
                        q.offer(n);
                        visited.add(n);
                    }
                }
            }
             operations++;
        }
        return operations;
    }
}