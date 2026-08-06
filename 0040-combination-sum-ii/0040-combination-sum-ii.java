class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] arr, int target, int start,
                           List<Integer> temp,
                           List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            // Skip duplicates
            if (i > start && arr[i] == arr[i - 1])
                continue;

            // No need to continue further
            if (arr[i] > target)
                break;

            temp.add(arr[i]);

            // Move to next index (use each number only once)
            backtrack(arr, target - arr[i], i + 1, temp, ans);

            temp.remove(temp.size() - 1);
        }
    }
}