public class Results {

    boolean isUpper(char c) {
        return java.lang.Character.isUpperCase(c);
    }

    char toUpper(char c) {
        return java.lang.Character.toUpperCase(c);
    }

    int canMake(char[] ca, char[] cb, int ja, int jb, int[][] dp) {

        int res = -1;

        // Out of bounds
        if(ja < 0) {
            return -1;
        }

        // Last elements of string a and string b have been reached
        if(ja == 0 && jb == 0) {
            if(ca[ja] != cb[jb] && isUpper(ca[ja])) {
                return -1;
            }
            return 2;
        }

        // Last element of string b has been reached
        if(jb == 0 && ja >= 0) {
            if(ca[ja] != cb[jb] && isUpper(ca[ja])) {
                return -1;
            }
            return canMake(ca, cb, ja - 1, jb, dp);
        }

        // Get results from memo table if available
        if(dp[ja][jb] != 0) {
            return dp[ja][jb];
        }

        // Letters are the same
        if(ca[ja] == cb[jb]) {
            res = canMake(ca, cb, ja - 1, jb - 1, dp);
        }

        // Letters differ
        if(ca[ja] != cb[jb]) {
            char up = toUpper(ca[ja]);
            boolean isU = isUpper(ca[ja]);

            // Char ca[ja] can be capitalized to cb[jb]
            if(!isU && up == cb[jb]) {
                int val1 = canMake(ca, cb, ja - 1, jb - 1, dp);
                int val2 = canMake(ca, cb, ja - 1, jb, dp);
                res = val1 == 2 || val2 == 2 ? 2 : -1;
            }
            // Char ca[ja] cannot be capitalized to cb[jb]
            if(!isU && up != cb[jb]) {
                res = canMake(ca, cb, ja - 1, jb, dp);
            }
            // Capital letter in string a is not present in string b
            if(isU && up != cb[jb]) {
                res = -1;
            }
        }

        // Store results in memo table
        dp[ja][jb] = res;

        return res;
    }

    /*
     * Complete the 'abbreviation' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */

    public String abbreviation(String a, String b) {

        char[] ca = a.toCharArray();
        char[] cb = b.toCharArray();

        int na = ca.length;
        int nb = cb.length;

        int[][] dp = new int[na + 1][nb + 1];

        int val = canMake(ca, cb, na - 1, nb - 1, dp);

        return val == 2 ? "YES" : "NO";
    }
}