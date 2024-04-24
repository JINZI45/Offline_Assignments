import java.util.*;

public class maxFlow {
    private int[][] graph;
    private int vertices;
    private int[][] res_graph;
    int parent[];

    public maxFlow(int vertices) {
        this.vertices = vertices;
        this.graph=new int[vertices][vertices];
        this.res_graph = new int[vertices][vertices];
        this.parent=new int[vertices];
    }
    public void addEdges(int u, int v, int c){
        graph[u][v]=c;
        res_graph[u][v]=c;
    }
    private int[] bfs(int source, int sink){
        int[] result=new int[2];
        result[1]=Integer.MAX_VALUE;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(source);
        parent[source]=-1;
        boolean[] visited= new boolean[vertices];
        visited[source]= true;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int i = 0; i < vertices; i++) {
                if (!visited[i] && res_graph[u][i] > 0) {
                    parent[i] = u;

                    if (i == sink) {

                        for (int v = sink; v != source; v = parent[v]) {
                            u = parent[v];
                            result[1] = Math.min(result[1], res_graph[u][v]);
                        }
                        result[0] = 1;
                        return result;
                    }
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }

        return result;
    }
    public int ford_fulkerson(int source, int sink){
        int max=0;
        int[] result=bfs(source, sink);
        while (result[0]==1) {
            for (int v = sink; v != source; v = parent[v]) {
                int u = parent[v];
                res_graph[u][v] = res_graph[u][v] - result[1];
                res_graph[v][u] = res_graph[v][u] + result[1];
            }
            max+= result[1];
            result= bfs(source,sink);
        }
        return max;
    }


}
