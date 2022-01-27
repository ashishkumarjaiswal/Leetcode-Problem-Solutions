class Solution {
    public static class Trie {
        public class Node {
            Node left;
            Node right;
        }

        Node root;

        Trie() {
            root = new Node();
        }

        public int search(int num) {
            int bit = 30;
            Node curr = root;
            int ans = 0;
            while (bit >= 0) {
                int mask = 1 << bit;
                int find = (num & mask) > 0 ? 1 : 0;
                if (find == 0) {
                    if (curr.left != null) {
                        curr = curr.left;
                    } else {
                        curr = curr.right;
                        ans = ans | mask;
                    }
                } else {

                    if (curr.right != null) {
                        curr = curr.right;
                        ans = ans | mask;
                    } else {
                        curr = curr.left;
                    }

                }
                bit--;
            }
            return ans;
        }

        public void insert(int num) {

            int bit = 30;
            Node curr = root;

            while (bit >= 0) {
                int mask = 1 << bit;
                int val = (mask & num) > 0 ? 1 : 0;
                if (val == 0) {
                    if (curr.left == null) {
                        curr.left = new Node();
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new Node();
                    }
                    curr = curr.right;
                }
                bit--;
            }
        }
    }

    public int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        for (int i : nums) {
            trie.insert(i);
        }
        int ans = 0;
        for (int i : nums) {
            int find = Integer.MAX_VALUE ^ i;
            int res = trie.search(find);
            ans = Math.max(ans, res ^ i);
        }
        return ans;
    }
}
