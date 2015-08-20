package graph;


import java.util.*;
/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.

 There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]

 4, [[1,0],[2,0],[3,1],[3,2]]
 There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
 * Created by xingyun on 15/8/12.
 */
public class LC_210_PrerequisiteCoursesII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        // if no edge, just return all the nodes
        if(prerequisites == null || prerequisites.length == 0) {
            for(int i=0; i<numCourses; ++i) {
                res[i] = i;
            }
        }
        // else construct graph
        Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        int[] indegrees = new int[numCourses];
        for(int i=0; i<prerequisites.length; ++i) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            indegrees[to]++;
            if(!graph.containsKey(from)) {
                List<Integer> relatedNodes = new ArrayList<Integer>();
                relatedNodes.add(to);
                graph.put(from, relatedNodes);
            } else {
                List<Integer> relatedNodes = graph.get(from);
                relatedNodes.add(to);
            }
        }
        // find all nodes which indegree is 0
        Queue<Integer> indegreeQueue = new LinkedList<Integer>();
        for(int i=0; i<indegrees.length; ++i) {
            if(indegrees[i] == 0) {
                indegreeQueue.offer(i);
            }
        }
        int idx = 0;
        // topology sorting
        while(!indegreeQueue.isEmpty()) {
            int node = indegreeQueue.poll();
            res[idx++] = node;
            if(graph.containsKey(node)) {
                for(int relatedNode:graph.get(node)) {
                    indegrees[relatedNode]--;
                    if(indegrees[relatedNode] == 0) {
                        indegreeQueue.offer(relatedNode);
                    }
                }
            }
        }

        return res;
    }
}
