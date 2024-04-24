import java.io.BufferedReader;
import java.io.FileReader;


public class Main {
    public static void main(String[] args) {

            String IN = "C:\\Users\\ECC\\IdeaProjects\\AllpairShortest\\src\\input.txt";
            try {
                BufferedReader br = new BufferedReader(new FileReader(IN));
                String[] input = br.readLine().split(" ");
                int v = Integer.parseInt(input[0]);
                int e = Integer.parseInt(input[1]);
                int[][] adjmatrix= new int[v+1][v+1];
                for (int i = 0; i <= v; i++) {
                    for (int j = 0; j <= v; j++) {
                        if(i==j){
                            adjmatrix[i][j]= 0;
                        }
                        else
                        adjmatrix[i][j]= 100001;
                    }

                }
                 for (int i = 0; i < e; i++) {
                        input = br.readLine().split(" ");
                        adjmatrix[Integer.parseInt(input[0])][Integer.parseInt(input[1])]= Integer.parseInt(input[2]);
                    }
                    shortestPath shortestPath= new shortestPath(adjmatrix,v);
                 shortestPath.floydWarshall();
                }



            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
