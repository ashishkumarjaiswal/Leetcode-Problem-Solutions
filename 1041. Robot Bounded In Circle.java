class Solution {
    public boolean isRobotBounded(String instructions) {
        HashMap<Character, String> direction = new HashMap<>();
        direction.put('N', "WE");
        direction.put('E', "NS");
        direction.put('S', "EW");
        direction.put('W', "SN");
        int x = 0, y = 0;
        Character newDirection = 'N';
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) == 'L') {
                newDirection = direction.get(newDirection).charAt(0);
            }
            if (instructions.charAt(i) == 'R') {
                newDirection = direction.get(newDirection).charAt(1);
            }
            if (instructions.charAt(i) == 'G') {
                if (newDirection == 'N')
                    y = y + 1;
                else if (newDirection == 'S')
                    y = y - 1;
                else if (newDirection == 'E')
                    x = x + 1;
                else
                    x = x - 1;
            }
        }
        if (x == 0 && y == 0)
            return true;
        return newDirection != 'N';

    }
}
