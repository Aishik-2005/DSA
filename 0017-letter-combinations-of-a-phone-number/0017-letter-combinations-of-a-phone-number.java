class Solution {
    public List<String> letterCombinations(String digits) {
        
        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, "", result, phone);

        return result;
    }

    public void backtrack(String digits, int index, String current,
                          List<String> result, String[] phone) {

        // If all digits are used
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        // Get letters for current digit
        String letters = phone[digits.charAt(index) - '0'];

        // Try every letter
        for (char c : letters.toCharArray()) {
            backtrack(digits, index + 1, current + c, result, phone);
        }
    }
}