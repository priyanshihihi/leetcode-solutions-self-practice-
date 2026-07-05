class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        
        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ')
            i++;

        // Check sign
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-')
                sign = -1;
            i++;
        }

        int ans = 0;

        // Read digits
        while (i < n && Character.isDigit(s.charAt(i))) {
            int d = s.charAt(i) - '0';

            // Overflow check
            if (ans > Integer.MAX_VALUE / 10 ||
                (ans == Integer.MAX_VALUE / 10 && d > 7)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            ans = ans * 10 + d;
            i++;
        }

        return ans * sign;
    }
}