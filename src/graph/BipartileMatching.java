package graph;

import java.util.Arrays;

/**
 * Created by xingyun on 10/3/15.
 */
public class BipartileMatching {

    public boolean bpm(boolean graph[][], int u, boolean seen[], int match[]) {

        int M = graph.length;
        int N = graph[0].length;

        for(int v=0; v<N; ++v) {
            if(graph[u][v] && !seen[v]) {
                seen[v] = true;
                // if match[v] >=0, rematch match[v]
                if(match[v] < 0 || bpm(graph, match[v], seen, match)) {
                    match[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public int maxBPM(boolean graph[][]) {

        int M = graph.length;
        int N = graph[0].length;
        // match result
        int match[] = new int[N];
        Arrays.fill(match, -1);

        int result = 0;
        for(int u=0; u<M; ++u) {
            boolean seen[] = new boolean[N];
            Arrays.fill(seen, false);

            if(bpm(graph, u, seen, match)) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        boolean[][] graph = new boolean[3][3];
        graph[0] = new boolean[] { false, true, true };
        graph[1] = new boolean[] { true, false, false };
        graph[2] = new boolean[] { false, true, false };


        BipartileMatching inst = new BipartileMatching();
        System.out.println(inst.maxBPM(graph));



    }
}
