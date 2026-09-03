class Solution {
    public boolean canBeValid(String s, String locked) {
        int n = s.length();

        // Odd length can never form a valid parentheses string
        if (n % 2 != 0) {
            return false;
        }

        // Left to right:
        // Make unlocked characters '(' whenever necessary.
        int balance = 0;

        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0' || s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
            }

            // Too many ')' even after using unlocked chars as '('
            if (balance < 0) {
                return false;
            }
        }

        // Right to left:
        // Make unlocked characters ')' whenever necessary.
        balance = 0;

        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0' || s.charAt(i) == ')') {
                balance++;
            } else {
                balance--;
            }

            // Too many '(' even after using unlocked chars as ')'
            if (balance < 0) {
                return false;
            }
        }

        return true;
    }
}