import java.util.ArrayList;
import java.util.List;

public class hard685 {
    int[] father = new int[1001];
    public void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            return father[u] = find(father[u]);
        }
    }

    public boolean isSame(int u ,int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    public void join(int u, int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }

    public boolean isTreeAfterRemoveEdge(int[][] edges, int delEdge) {
        //情况一和二， 删除入度为2的节点的那条边
        init();
        for (int i = 0; i < edges.length; i++) {
            if (i == delEdge) continue;
            if (isSame(edges[i][0],edges[i][1])) {
                return false;
            }
            join(edges[i][0], edges[i][1]);
        }
        return true;
    }

    public int[] getRemoveEdge(int[][] edges) {
        //情况三 删除成环的那条边
        init();
        for (int i = 0; i < edges.length; i++) {
            if (isSame(edges[i][0],edges[i][1])) {
                return edges[i];
            }
            join(edges[i][0],edges[i][1]);
        }
        return null;
    }
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int[] Degree = new int[1001];
        for (int i = 0; i < edges.length; i++) {
            //统计入度
            Degree[edges[i][1]]++;
        }
        //找出入度为2的边
        List<Integer> DegreeTwo = new ArrayList<>();
        for (int i = edges.length-1; i>= 0; i--) {
            if (Degree[edges[i][1]] == 2) {
                DegreeTwo.add(i);
            }
        }
        if (!DegreeTwo.isEmpty()) {
            //有两条边，看删除哪个之后是树
            if (isTreeAfterRemoveEdge(edges,DegreeTwo.get(0))) {
                return edges[DegreeTwo.get(0)];
            } else {
                return edges[DegreeTwo.get(1)];
            }
        }

        return getRemoveEdge(edges);

    }
}
