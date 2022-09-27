class Solution {
    public double angleClock(int hour, int minutes) {
        double minAngle = minutes * 6;
        double hourAngle = (hour % 12) * 30;
        double diff = minAngle / 360.0;
        hourAngle = hourAngle + diff * 30;

        double x = Math.abs(hourAngle - minAngle);

        return Math.min(x, 360 - x);
    }
}
