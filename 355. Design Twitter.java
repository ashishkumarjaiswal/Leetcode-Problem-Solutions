class Twitter {
    HashMap<Integer, LinkedList<int[]>> user;
    HashMap<Integer, HashSet<Integer>> follow;
    static int timeStamp;

    public Twitter() {
        user = new HashMap<>();
        follow = new HashMap<>();
        timeStamp = 0;
    }

    public void postTweet(int userId, int tweetId) {
        if (!user.containsKey(userId)) {
            user.put(userId, new LinkedList<>());
        }

        user.get(userId).addFirst(new int[] { tweetId, timeStamp });
        timeStamp++;
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> userFollowing = new LinkedList<>();
        userFollowing.add(userId);

        if (follow.get(userId) != null) {
            userFollowing.addAll(follow.get(userId));
        }

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int i = 0; i < userFollowing.size(); i++) {
            int id = userFollowing.get(i);

            if (user.get(id) == null) {
                continue;
            }

            List<int[]> tweets = user.get(id);

            for (int j = 0; j < tweets.size() && j < 10; j++) {
                q.add(tweets.get(j));
            }
        }

        while (q.size() > 10) {
            q.poll();
        }

        LinkedList<Integer> ans = new LinkedList<>();

        for (int i = 0; !q.isEmpty() && i < 10; i++) {
            ans.addFirst(q.poll()[0]);
        }

        return ans;
    }

    public void follow(int followerId, int followeeId) {
        if (!follow.containsKey(followerId)) {
            follow.put(followerId, new HashSet<>());
        }

        follow.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (follow.get(followerId) == null)
            return;

        follow.get(followerId).remove(followeeId);
    }
}
