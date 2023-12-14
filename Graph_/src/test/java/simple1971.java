public class simple1971 {
    private static int[] father;
    public static boolean validPath(int n, int[][] edges, int source, int destination) {
        father = new int[n];
        init();
        for (int i = 0; i < edges.length; i++) {
            join(edges[i][0],edges[i][1]);
        }
        return isSame(source,destination);
    }

    public static void init() {
        for (int i = 0; i < father.length; i++) {
            father[i] = i;
        }
    }

    public static int find(int u) {
        if (u == father[u]) {
            return u;
        } else {
            father[u] = find(father[u]);
            return father[u];
        }
    }

    public static boolean isSame(int u, int v) {
        u = find(u);
        v = find(v);
        return u == v;
    }

    public static void join(int u ,int v) {
        u = find(u);
        v = find(v);
        if (u == v) return;
        father[v] = u;
    }

    public static void main(String[] args) {
        int n = 3, source = 0, destination = 2;
        int[][] edges = {{0,1},{1,2},{2,0}};
        validPath(n,edges,source,destination);
    }
}
