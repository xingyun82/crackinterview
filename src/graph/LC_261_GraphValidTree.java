package graph;

import java.util.*;
/**
 Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 write a function to check whether these edges make up a valid tree.

 For example:

 Given n = 5 and edges = [[0, 1], [0, 2], [0, 3], [1, 4]], return true.

 Given n = 5 and edges = [[0, 1], [1, 2], [2, 3], [1, 3], [1, 4]], return false.

 Hint:

 Given n = 5 and edges = [[0, 1], [1, 2], [3, 4]], what should your return? Is this case a valid tree?

 According to the definition of tree on Wikipedia: “a tree is an undirected graph in which any two
 vertices are connected by exactly one path. In other words, any connected graph without simple cycles is a tree.”

 Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 [0, 1] is the same as [1, 0] and thus will not appear together inedges.

 * Created by xingyun on 10/13/15.
 */
public class LC_261_GraphValidTree {

    // main idea:
    // 1. DFS travel the graph start from one node
    // 2. if a node has been traveled before, then there should exits a circle
    // 3. if the traveled node set size is less than node set size, then the graph is not all-connected.
    public boolean TreeOrNot(int[][] edges) {
        if(edges == null || edges.length == 0) return false;
        Map<Integer, List<Integer>> neighborMap  = new HashMap<Integer, List<Integer>>();
        Set<Integer> vSet = new HashSet<Integer>();
        int v0 = edges[0][0];
        for(int i=0; i<edges.length; ++i) {
            int v1 = edges[i][0];
            int v2 = edges[i][1];
            vSet.add(v1);
            vSet.add(v2);
            if(!neighborMap.containsKey(v1)) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(v2);
                neighborMap.put(v1, l);
            } else {
                neighborMap.get(v1).add(v2);
            }
            if(!neighborMap.containsKey(v2)) {
                List<Integer> l = new ArrayList<Integer>();
                l.add(v1);
                neighborMap.put(v2, l);
            } else {
                neighborMap.get(v2).add(v1);
            }
        }
        // start travel the graph
        Set<Integer> visited = new HashSet<Integer>();
        if(!traversal(visited, neighborMap, v0, -1)) return false;
        return visited.size() == vSet.size();
    }

    public boolean traversal(Set<Integer> visited, Map<Integer, List<Integer>> neighborMap, int v, int prev) {
        if(!visited.contains(v)) {
            visited.add(v);
        }
        List<Integer> neighbors = neighborMap.get(v);
        for(int neighbor: neighbors) {
            if(neighbor != prev) {
                if(visited.contains(neighbor)) return false;
                if(!traversal(visited, neighborMap, neighbor, v)) return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        LC_261_GraphValidTree inst = new LC_261_GraphValidTree();
        int[][] edges = {
                {0,1},
                {0,2},
                {0,3},
                {1,4}

        };
        System.out.println(inst.TreeOrNot(edges));
    }



}
