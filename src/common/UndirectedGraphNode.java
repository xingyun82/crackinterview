package common;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xingyun on 15/8/19.
 */

public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
}
