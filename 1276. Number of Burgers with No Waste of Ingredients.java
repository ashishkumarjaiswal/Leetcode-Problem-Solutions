class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> ans = new LinkedList<>();

        if ((tomatoSlices & 1) == 1)
            return ans;

        int x = (tomatoSlices - (2 * cheeseSlices));
        if ((x & 1) == 1)
            return ans;

        x = x / 2;
        int y = cheeseSlices - x;

        if (x < 0 || y < 0)
            return ans;
            
        ans.add(x);
        ans.add(y);

        return ans;
    }
}
