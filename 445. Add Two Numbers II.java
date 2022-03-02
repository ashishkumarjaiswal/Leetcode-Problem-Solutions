//using biginteger

import java.math.BigInteger;
import java.util.*;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode();
        ListNode ret = ans;

        BigInteger x = fun(l1);
        BigInteger y = fun(l2);
        BigInteger z = x.add(y);
        String s = z.toString();

        for (int i = 0; i < s.length(); i++) {
            ans.next = new ListNode(Integer.parseInt(s.charAt(i) + ""));
            ans=ans.next;
        }
        return ret.next;
    }

    BigInteger fun(ListNode node) {
        BigInteger sum = new BigInteger("0");
        BigInteger m = new BigInteger("10");

        while (node != null) {
            sum = sum.multiply(m);
            BigInteger x = new BigInteger(String.valueOf(node.val));
            sum = sum.add(x);
            node = node.next;
        }
        return sum;
    }
}
