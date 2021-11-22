class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ashish = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ashish.add(temp);
        if (numRows == 1)
            return ashish;

        temp = new ArrayList<>();
        temp.add(1);
        temp.add(1);
        ashish.add(temp);
        if (numRows == 2)
            return ashish;
        for (int i = 2; i < numRows; i++) {
            temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < i - 1; j++) {
                temp.add(ashish.get(i - 1).get(j) + ashish.get(i - 1).get(j + 1));
            }
            temp.add(1);
            ashish.add(temp);
        }
        return ashish;
    }
}
//Another One
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        temp.add(1);
        ans.add(temp);
        if (numRows == 1)
            return ans;
        temp=new ArrayList<>();
        temp.add(1);
        temp.add(1);
        ans.add(temp);
        for (int i = 2; i < numRows; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < i; j++) {
                list.add(temp.get(j - 1) + temp.get(j));
            }
            list.add(1);
            temp = new ArrayList<>(list);
            ans.add(temp);
        }
        return ans;
    }
}
