class Solution {

    public int compute(int n, int x, int[] a, int[] b) {
        int cost = 0;

        for (int j = 0; j < n; j++) {
            if (a[j] >= x) {
                cost += b[j];
            }
        }

        return cost;
    }

    public static void main(String[] args) {
        Solution obj = new Solution();

        int[] a = {1, 3, 5, 2, 4};
        int[] b = {10, 20, 30, 40, 50};

        int result = obj.compute(5, 3, a, b);

        System.out.println(result);
    }
}