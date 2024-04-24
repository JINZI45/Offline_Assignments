import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class ShortesPath {
    private ArrayList<ArrayList<vertex>> adjList;
    private int vertices;
    private  int edges;

    public ShortesPath(int vertices, int edges) {
        this.vertices = vertices;
        this.edges = edges;
        this.adjList= new ArrayList<>(vertices);
        for (int i = 0; i < edges; i++) {
            adjList.add(new ArrayList<vertex>());
           }
    }
    public  void addEdge( int v1, int v2,int w){

            vertex p1= new vertex(v1,v2,w);
            adjList.get(v1).add(p1);

    }

    public void dikjstra(int source,int dest){

         PriorityQueue<vertex> pq= new PriorityQueue<vertex>(new Sortbyweight());
        int[] distance= new int[vertices];
        boolean[] visited=new boolean[vertices];
        int[] destination=new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i]= Integer.MAX_VALUE;
            visited[i]=false;
        }

        pq.add(new vertex(source,source,0));
        distance[source]=0;
        while (!pq.isEmpty()){
            vertex curr= pq.poll();
            visited[curr.getV()]= true;
            for (vertex v: adjList.get(curr.getV())) {
                //System.out.println(v.getV());
                if(!visited[v.getV()] && distance[curr.getV()]+v.getWeight()< distance[v.getV()]){
                    int weigh=distance[curr.getV()]+v.getWeight();
                    distance[v.getV()]= weigh;
                    pq.add(v);
                    destination[v.getV()]=v.getU();
                   // System.out.println(pq.peek().getV()+"kk");
                }
            }
        }
        System.out.println("Shortest path cost:"+distance[dest]);
        int u=dest;
        int c=0;
        int path[]=new int[vertices];
        while (u!=source){
            path[c]=u;
            c++;
            u=destination[u];
        }
        for (int i = c; i >0; i--) {
            System.out.print(path[i]+"->");

        }
        System.out.println(path[0]);


    }
}
class Sortbyweight implements Comparator<vertex> {

    public int compare(vertex u, vertex v)
    {
        return u.getWeight() - v.getWeight();
    }
}
class vertex{
    private int u;
    private int v;
    private int weight;

    public vertex(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    public int getU() {
        return u;
    }

    public void setU(int u) {
        this.u = u;
    }

    public int getV() {
        return v;
    }

    public void setV(int v) {
        this.v = v;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}

