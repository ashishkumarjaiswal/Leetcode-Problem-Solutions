class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        if (s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() == 0)
            return s1.equals(s3);
        dp = new Boolean[s1.length()][s2.length()];
        return fun(s1, s2, s3, 0, 0, 0);
    }

    boolean fun(String s1, String s2, String s3, int i, int j, int k) {
        if (k >= s3.length())
            return true;
        if (j >= s2.length()) {
            return s1.substring(i, s1.length()).equals(s3.substring(k, s3.length()));
        }
        if (i >= s1.length()) {
            return s2.substring(j, s2.length()).equals(s3.substring(k, s3.length()));
        }
        if (dp[i][j] != null)
            return dp[i][j];
        if (s1.charAt(i) != s2.charAt(j)) {
            if (s1.charAt(i) == s3.charAt(k)) {
                return dp[i][j] = fun(s1, s2, s3, i + 1, j, k + 1);
            } else if (s2.charAt(j) == s3.charAt(k)) {
                return dp[i][j] = fun(s1, s2, s3, i, j + 1, k + 1);
            } else {
                return dp[i][j] = false;
            }
        } else {
            if (s3.charAt(k) == s1.charAt(i)) {
                if (dp[i][j] = fun(s1, s2, s3, i + 1, j, k + 1))
                    return true;
                else if (dp[i][j] = fun(s1, s2, s3, i, j + 1, k + 1))
                    return true;
                else
                    return dp[i][j] = false;
            } else {
                return dp[i][j] = false;
            }
        }
    }
}
//Shorter One
class Solution {
    Boolean[][] dp;

    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        if (s1.length() == 0)
            return s2.equals(s3);
        if (s2.length() == 0)
            return s1.equals(s3);
        dp = new Boolean[s1.length()][s2.length()];
        return fun(s1, s2, s3, 0, 0);
    }

    boolean fun(String s1, String s2, String s3, int i, int j) {
        if (i == s1.length() && j == s2.length())
            return true;
        if (j == s2.length()) {
            return s1.substring(i, s1.length()).equals(s3.substring(i + j, s3.length()));
        }
        if (i == s1.length()) {
            return s2.substring(j, s2.length()).equals(s3.substring(i + j, s3.length()));
        }
        if (dp[i][j] != null)
            return dp[i][j];
        if (i < s1.length() && s1.charAt(i) == s3.charAt(j + i)) {
            dp[i][j] = fun(s1, s2, s3, i + 1, j);
            if (dp[i][j])
                return true;
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(j + i)) {
            dp[i][j] = fun(s1, s2, s3, i, j + 1);
            if (dp[i][j])
                return true;

        }
        return dp[i][j] = false;
    }
}
