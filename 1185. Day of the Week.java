import java.time.LocalDate;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        String ans = LocalDate.of(year, month, day).getDayOfWeek().toString();
        return ans.substring(0, 1).toUpperCase() + ans.substring(1).toLowerCase();
    }
}
