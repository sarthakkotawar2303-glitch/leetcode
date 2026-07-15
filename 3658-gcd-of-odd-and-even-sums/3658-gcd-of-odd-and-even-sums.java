class Solution {
    public int gcdOfOddEvenSums(int n) {
        // Cast input to long to force 64-bit safety during multiplication
        long longN = (long) n;

        // Sn = (n * [2a + (n - 1)d]) / 2 
        // The count of terms for both groups is exactly n
        long oddSum = (longN * (2 * 1 + (longN - 1) * 2)) / 2;
        long evenSum = (longN * (2 * 2 + (longN - 1) * 2)) / 2;

        // Euclidean Algorithm using long values
        while (evenSum != 0) {
            long remainder = oddSum % evenSum;
            oddSum = evenSum;
            evenSum = remainder;
        }

        // Return type requires a safe narrow down to int
        return (int) oddSum;
    }
}
