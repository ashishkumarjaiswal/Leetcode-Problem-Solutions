import java.util.*;

class Solution {
    public String solveEquation(String equation) {
        int[][] left = new int[1][2];
        int[][] right = new int[1][2];
        boolean sign = true;
        int i = 0;

        for (i = 0; i < equation.length(); i++) {
            char c = equation.charAt(i);

            if (c == '=')
                break;

            if (c == 'x') {
                if (sign) {
                    left[0][0]++;
                } else {
                    left[0][0]--;
                }
                continue;
            }

            if (c == '+') {
                sign = true;
                continue;
            }
            if (c == '-') {
                sign = false;
                continue;
            }

            int digit = 0;

            while (Character.isDigit(equation.charAt(i))) {
                digit = digit * 10 + Character.getNumericValue(equation.charAt(i));
                i++;
            }

            if (equation.charAt(i) == 'x') {
                i++;
                if (sign)
                    left[0][0] += digit;
                else
                    left[0][0] -= digit;
            } else {
                if (sign)
                    left[0][1] += digit;
                else
                    left[0][1] -= digit;
            }

            i--;
        }
        i++;
        sign = true;

        for (; i < equation.length(); i++) {
            char c = equation.charAt(i);

            if (c == 'x') {
                if (sign) {
                    right[0][0]++;
                } else {
                    right[0][0]--;
                }
                continue;
            }

            if (c == '+') {
                sign = true;
                continue;
            }
            if (c == '-') {
                sign = false;
                continue;
            }

            int digit = 0;

            while (i < equation.length() && Character.isDigit(equation.charAt(i))) {
                digit = digit * 10 + Character.getNumericValue(equation.charAt(i));
                i++;
            }

            if (i < equation.length() && equation.charAt(i) == 'x') {
                i++;
                if (sign)
                    right[0][0] += digit;
                else
                    right[0][0] -= digit;
            } else {
                if (sign)
                    right[0][1] += digit;
                else
                    right[0][1] -= digit;
            }
            i--;
        }

        int x = left[0][0] - right[0][0];
        int y = right[0][1] - left[0][1];

        System.out.println(left[0][0] + " " + left[0][1]);
        System.out.println(right[0][0] + " " + right[0][1]);

        if (x == 0) {
            if (y == 0)
                return "Infinite solutions";
            return "No solution";

        }

        if (y == 0)
            return "x=0";

        return String.valueOf("x=" + y / x);
    }
}
