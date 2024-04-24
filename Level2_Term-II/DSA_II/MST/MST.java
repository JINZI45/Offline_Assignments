import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MST {
    private PriorityQueue<Edge> pq;

    private Edge edges[];
    private subset subsets[];
    private int edge;
    private int vertices;
    private ArrayList<vertex> adjList[];
    private vertex[] v;


    public MST(Edge[] edges, int edge, int vertices) {
        pq=new PriorityQueue<>(new SortbyWeight());
        adjList=new ArrayList[vertices];
        this.edges = edges;
        this.edge = edge;
        this.vertices = vertices;
        v= new vertex[vertices];
        subsets = new subset[vertices];
        for (int i = 0; i < vertices; i++) {
            subsets[i]= new subset(0,i);
            adjList[i]= new ArrayList<>();
            v[i]= new vertex();
            v[i].name=i;
        }
    }


    public int findSource(subset subset[], int i){
        if(subset[i].getParent()!= i){

            subset[i].setParent(findSource(subset,subset[i].getParent()));
        }

        return subset[i].getParent();
    }
    public void union(int u, int v,subset subset[]){
        int parentU= findSource(subset,u);
        int parentV= findSource(subset,v);
        if (subset[parentU].getRank()==subset[parentV].getRank()){
            subset[parentV].setParent(subset[parentU].getParent());
            subset[parentU].setRank(subset[parentU].getRank()+1);
        }
        else  if (subset[parentU].getRank()>subset[parentV].getRank()){
            subset[parentV].setParent(subset[parentU].getParent());

        }
        else  if (subset[parentU].getRank()<subset[parentV].getRank()){
            subset[parentU].setParent(subset[parentV].getParent());

        }
    }
    public void kruskal(){
        Edge mstEdges[]= new Edge[vertices-1];
        Arrays.sort(edges, new SortbyWeight());
        int e = 0,i=0;
        float cost=0;
        while (e<vertices-1){
            Edge next= edges[i];
            int U= findSource(subsets,next.getU());
            int V= findSource(subsets,next.getV());

            if (U!= V){
                mstEdges[e]=next;
                union(U,V,subsets);
                e++;
            }
            i++;
        }
        for( i=0; i<mstEdges.length;i++){
           cost+= mstEdges[i].getWeight() ;
        }
        System.out.println("Cost of the minimum spanning tree :" + cost);
        System.out.println("List of edges selected by Kruskal’s:"+ Arrays.toString(mstEdges));

    }
    private void adjacencylist(){
        for(int i=0;i<edge;i++){
          adjList[edges[i].getU()].add(v[edges[i].getV()]);
            adjList[edges[i].getV()].add(v[edges[i].getU()]);
        }
    }

    public void prim( int root){
        adjacencylist();
        PriorityQueue<vertex> pKey= new PriorityQueue();
        v[root].key=0;
        for (int i=0;i<vertices;i++){
            pKey.add(v[i]);
        }
        while (!pKey.isEmpty()){
            vertex u= pKey.poll();
            for (vertex vert:
                 adjList[u.name]) {

            }
        }



    }
}
class sortByKey implements Comparator<vertex>{

    @Override
    public int compare(vertex v1, vertex v2) {
        if (v1.key<v2.key) return -1;
        else if (v1.key>v2.key) return 1;
        else return 0;
    }
}
class SortbyWeight implements Comparator<Edge> {
    public int compare(Edge a, Edge b)
    {
        return (int) (a.getWeight() - b.getWeight());
    }
}
class Edge{
    private float weight;
    private int u;
    private int v;

    public Edge(float weight, int u, int v) {
        this.weight = weight;
        this.u = u;
        this.v = v;
    }

    @Override
    public String toString() {
        return "("+ u+
                "," + v +
                ')';
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
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
}
class subset{
    private int rank;
    private  int parent;

    public subset(int rank, int parent) {
        this.rank = rank;
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
}
class vertex{
    int parent;
    int name;
    float key;

    public vertex() {
        name=-1;
        this.parent = -1;
        this.key =Float.MAX_VALUE;
    }

}
