class Solution {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i] + "";
        }
        Arrays.sort(arr, (a, b) -> {
            long n1 = Long.parseLong(a + b);
            long n2 = Long.parseLong(b + a);
            if (n1 > n2)
                return 1;
            else if (n1 < n2)
                return -1;
            else
                return 0;
        });
        String s = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            s = s + arr[i];
        }
        if(s.charAt(0)=='0')
            return "0";
        return s;
    }
}
