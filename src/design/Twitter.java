package design;

import java.util.*;

/**
 * Created by yunxing on 6/12/16.
 */
class Tweet {
    int tweetId;
    Date postTime;

    public Tweet(int tweeId, Date postTime) {
        this.tweetId = tweeId;
        this.postTime = postTime;
    }
}


public class Twitter {

    // userid -> followee ids
    Map<Integer, Set<Integer>> followeeMap = new HashMap<>();
    // userid -> user's tweets
    Map<Integer, List<Tweet>> userTweetsMap = new HashMap<>();

    /** Initialize your data structure here. */
    public Twitter() {

    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userTweetsMap.containsKey(userId)) {
            userTweetsMap.put(userId, new ArrayList<>());
        }
        userTweetsMap.get(userId).add(new Tweet(tweetId, new Date()));

    }

    private void filter(Queue<Tweet> queue, List<Tweet> tweets, int limit) {
        for(Tweet tweet:tweets) {
            if(queue.isEmpty() || queue.size() < limit) {
                queue.offer(tweet);
            } else {
                if(tweet.postTime.compareTo(queue.peek().postTime) > 0) {
                    queue.poll();
                    queue.offer(tweet);
                }
            }
        }
    }

    private List<Integer> reverse(Queue<Tweet> queue) {
        List<Integer> res = new ArrayList<>();
        while(!queue.isEmpty()) {
            res.add(queue.poll().tweetId);
        }
        Collections.reverse(res);
        return res;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> queue = new PriorityQueue<>(new Comparator<Tweet>() {
            @Override
            public int compare(Tweet o1, Tweet o2) {
                return o1.postTime.compareTo(o2.postTime);
            }
        });
        if(userTweetsMap.containsKey(userId)) {
            int start = userTweetsMap.get(userId).size() - 10;
            start = start >= 0 ? start : 0;
            filter(queue, userTweetsMap.get(userId).subList(start, userTweetsMap.get(userId).size()), 10);
        }
        if(followeeMap.containsKey(userId)) {
            Set<Integer> followeeIds = followeeMap.get(userId);
            for (int followeeId : followeeIds) {
                if (!userTweetsMap.containsKey(followeeId)) continue;
                List<Tweet> tweets = userTweetsMap.get(followeeId);
                int start = tweets.size() - 10;
                start = start >= 0 ? start : 0;
                filter(queue, tweets.subList(start, tweets.size()), 10);
            }
        }
        return reverse(queue);
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!followeeMap.containsKey(followerId)) {
            followeeMap.put(followerId, new HashSet<>());
        }
        followeeMap.get(followerId).add(followeeId);

    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {

        if(followeeMap.containsKey(followerId)) {
            followeeMap.get(followerId).remove(followeeId);
        }
    }
}