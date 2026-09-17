class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        solve(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    void solve(int[] candidates, int target, int start,
               List<Integer> list, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate values
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // No need to continue
            if (candidates[i] > target) {
                break;
            }

            list.add(candidates[i]);

            // i + 1 means use each element only once
            solve(candidates, target - candidates[i],
                  i + 1, list, ans);

            // Backtrack
            list.remove(list.size() - 1);
        }
    }
}