import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        solve(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    static void solve(int[] candidates, int target, int index,
                      List<Integer> current,
                      List<List<Integer>> result) {

        // Target reached
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // No more candidates
        if (index == candidates.length || target < 0) {
            return;
        }

        // Choice 1: Take the current number
        current.add(candidates[index]);

        solve(candidates,
              target - candidates[index],
              index,
              current,
              result);

        // Remove it before trying the next choice
        current.remove(current.size() - 1);

        // Choice 2: Skip the current number
        solve(candidates,
              target,
              index + 1,
              current,
              result);
    }
}