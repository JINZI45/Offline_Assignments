public class shortestPath {
    private int[][] distance;
    private int v;

    public shortestPath(int[][] distance, int v) {
        this.distance = distance;
        this.v = v;
    }
    public void floydWarshall(){

        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {

                        distance[j][k]= Math.min(distance[j][k],distance[j][i]+distance[i][k]);

                }
            }


        }System.out.println("Shortest distance matrix\n");
        for (int i = 1; i <=v ; i++) {
            for (int j =1; j <=v ; j++) {
                if(distance[i][j]==100001)
                    System.out.print("INF  ");
                else
                System.out.print( distance[i][j]+"    ");
            }
            System.out.println();

        }
    }
}
