package graph;

import java.util.*;

/**
 *
 * There are a total of n courses you have to take, labeled from 0 to n - 1.

 Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

 Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

 For example:

 2, [[1,0]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.

 2, [[1,0],[0,1]]
 There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

 Note:
 The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.


 * Created by xingyun on 15/8/9.
 */
public class LC_207_PrerequisiteCourses {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // ingree array
        int[] ingree = new int[numCourses];
        // zeroDegree queue
        Queue<Integer> zeroDegree = new LinkedList<Integer>();
        // edge map ( node -> its related nodes )
        Map<Integer, List<Integer>> prerequisiteMap = new HashMap<Integer, List<Integer>>();
        for(int i=0;i<prerequisites.length; ++i) {
            int to = prerequisites[i][0];
            int from = prerequisites[i][1];
            ingree[to]++;
            if(prerequisiteMap.containsKey(from)) {
                prerequisiteMap.get(from).add(to);
            } else {
                List<Integer> l = new ArrayList<Integer>();
                l.add(to);
                prerequisiteMap.put(from, l);
            }
        }
        // get zero ingree courses
        for(int i=0;i<numCourses; ++i) {
            if(ingree[i] == 0) {
                zeroDegree.add(i);
            }
        }
        // topology travel graph
        while(!zeroDegree.isEmpty()) {
            int i = zeroDegree.poll();
            List<Integer> l = prerequisiteMap.get(i);
            if(l == null) continue;
            for(int j:l) {
                ingree[j]--;
                if(ingree[j] == 0) zeroDegree.offer(j);
            }
        }
        // if all course ingree is zero, return true
        // else return false
        for(int i=0; i<numCourses; ++i) {
            if(ingree[i] != 0) return false;
        }
        return true;

    }

    public static void main(String[] args) {
        LC_207_PrerequisiteCourses inst = new LC_207_PrerequisiteCourses();
        int[][] edges = new int[3][];
        edges[0] = new int[]{1,0};
        edges[1] = new int[]{0,1};
        edges[2] = new int[]{0,2};
        System.out.println(inst.canFinish(3, edges));
    }
}
