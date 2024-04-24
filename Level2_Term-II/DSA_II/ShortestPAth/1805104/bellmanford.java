import java.util.ArrayList;
import java.util.Comparator;

public class bellmanford {
    private int vertices;
    private  int edges;
    private ArrayList<vertex> edge;

    public bellmanford(int vertices, int edges, ArrayList<vertex> edge) {
        this.vertices = vertices;
        this.edges = edges;
        this.edge = edge;
    }

    public void shortest(int source, int destination){
        int[] distance= new int[vertices];
        int[] path= new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i]= Integer.MAX_VALUE;
        }
        distance[source]=0;

        for (int i = 1; i < vertices; i++) {
            for (int j = 0; j < edges; j++) {
                int u= edge.get(j).getU();
                int v=edge.get(j).getV();
                if (distance[u]!= Integer.MAX_VALUE && distance[u]+edge.get(j).getWeight()<distance[v]){
                    distance[v]=distance[u]+edge.get(j).getWeight();
                    path[v]=u;
                }

            }
        }
        boolean b= false;
        for (int i = 0; i < edges; i++) {
            int u= edge.get(i).getU();
            int v=edge.get(i).getV();
            if (distance[u]!= Integer.MAX_VALUE && distance[u]+edge.get(i).getWeight()<distance[v]){
                b= true;
            }
        }
        if (b){
            System.out.println("The graph contains a negative cycle");
        }
        else{
            System.out.println("The graph does not contain a negative cycle\n" +
                    "Shortest path cost: "+distance[destination]);
            int u= destination;
            int[] paths=new int[vertices];
            int c=0;
            while (u!=source){
                paths[c++]=u;
                u= path[u];
            }
            for (int i = c; i>0; i--) {
                System.out.print(paths[i]+"->");

            }
            System.out.println(paths[0]);
        }
    }

}
class SortbyU implements Comparator<vertex> {

    public int compare( vertex u, vertex v)
    {
        return u.getU() - v.getU();
    }
}

