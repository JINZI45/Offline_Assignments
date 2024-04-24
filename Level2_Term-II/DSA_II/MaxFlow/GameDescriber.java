import java.util.ArrayList;
import java.util.LinkedList;

public class GameDescriber {
    private int[] winner;
    private int[] losses;
    private int[] left;
    private String[] teams;
    private int[][] g;
    private int n;

    public GameDescriber(int[] winner, int[] losses, int[] left, String[] teams, int[][] g, int n) {
        this.winner = winner;
        this.losses = losses;
        this.left = left;
        this.teams = teams;
        this.g = g;
        this.n = n;
    }

    public void createGraph(int k){
       int newV= 2+(n*(n-1)/2);
       int total_match=(n-1)*(n-2)/2;
       int team=n-1;
       int source=0;
       int sink=newV-1;
       maxFlow m=new maxFlow(newV);
       int t=1;
       int total_cap=0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(i==k&& j==k)
                    continue;
                m.addEdges(source,t,g[i][j]);
                total_cap+=g[i][j];
                if (i<k)
                    m.addEdges(t,i+total_match+1,Integer.MAX_VALUE);
                else m.addEdges(t,i+total_match,Integer.MAX_VALUE);
                if (j<k)
                    m.addEdges(t,j+total_match+1,Integer.MAX_VALUE);
                else m.addEdges(t,j+total_match,Integer.MAX_VALUE);
                t++;
            }
            for (int j = 0; j < n; j++) {
                if (j==i)
                    continue;
                else m.addEdges(t,sink,winner[i]+left[i]-winner[j]);
                t++;
            }

        }

        int max= m.ford_fulkerson(source,sink);
        if(total_cap<max)
            System.out.println(teams[k] +" is eliminated");
        }
        public void eliminationChecker(int i){
        boolean b=true;
            for (int j = 0; j < n; j++) {
                if (winner[i]+left[i]< winner[j]){
                    System.out.println(teams[i] +" is eliminated");
                }
                else b=false;
            }
            if (!b)
                createGraph(i);
        }

}
