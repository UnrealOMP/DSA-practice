class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for( int i = 0; i < n; i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();

        for(int q : queries){
            List<Integer> list = map.get(nums[q]);

            if(list.size() == 1){
                result.add(-1);
                continue;
            }

            int idx = Collections.binarySearch(list, q);

            int ans = Integer.MAX_VALUE;

            int left = (idx - 1 + list.size()) % list.size();
            int leftIdx = list.get(left);

            int dist1 = Math.abs(q - leftIdx);
            dist1 = Math.min(dist1, n - dist1);

            int right = (idx + 1)% list.size();
            int rightIdx = list.get(right);

            int dist2 = Math.abs(q - rightIdx);
            dist2 = Math.min(dist2, n - dist2);

            ans = Math.min(dist1, dist2);

            result.add(ans);


        }

        return result;
    }
}