class Solution {

    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> list) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        if (target < 0 || index == candidates.length)
            return;

        // Take current number
        list.add(candidates[index]);
        backtrack(candidates, target - candidates[index], index, list);

        // Backtrack
        list.remove(list.size() - 1);

        // Skip current number
        backtrack(candidates, target, index + 1, list);
    }
}