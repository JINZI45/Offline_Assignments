import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
         String OUTPUT = "output.txt";
     int opt;
        while (true){
            System.out.println("1. BFS" +"\n"+
                    "2.DFS"+"\n"+
                    "Press 3 to exit"+"\n");
            Scanner sc1= new Scanner(System.in);
             opt= sc1.nextInt();
             if (opt==3)
                 break;
        Scanner sc= new Scanner(System.in);
        String inputs[]= sc.nextLine().split(" ");
        int C=Integer.parseInt(inputs[0]);
        int R=Integer.parseInt(inputs[1]);
        int L=Integer.parseInt(inputs[2]);
        int F=Integer.parseInt(inputs[3]);
        int total_pieces=0;
        int collected=0;
        int start[]=new int[F];
        int treasure[]=new int[F];
        Graph graph= new Graph(C);
        for (int i=0;i<R;i++){
            String road[]=sc.nextLine().split(" ");
            graph.addEdges(Integer.parseInt(road[0]),Integer.parseInt(road[1]));
        }
        for (int i=0; i<L;i++){
            String treasures[]=sc.nextLine().split(" ");
            graph.find(Integer.parseInt(treasures[0])).setPieces(Integer.parseInt(treasures[1]));
            total_pieces+=Integer.parseInt(treasures[1]);
        }

        for (int i=0;i<F;i++){
            String friends[]=sc.nextLine().split(" ");
            start[Integer.parseInt(friends[1])]=Integer.parseInt(friends[0]);
        }
        if(opt==1){
        for (int i=0;i<F;i++) {
            treasure[i] = graph.bfs(start[i]);
            collected += treasure[i];
        }
        }
        else if(opt==2){
            for (int i=0;i<F;i++) {
                treasure[i] = graph.dfs(start[i]);
                collected += treasure[i];
            }

        }
        try {
                BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT));

        if(collected==total_pieces){
            bw.write("Mission accomplished");
            bw.write("\n");
        }
        else {
            bw.write("Mission impossible");
            bw.write("\n");
        }
        bw.write(collected+" out of "+total_pieces+" pieces are collected");
            bw.write("\n");
        for(int i=0;i<F;i++){
            bw.write(i+" collected "+ treasure[i] +" pieces");
            bw.write("\n");
        }
        bw.close();
         }
         catch (Exception e){
e.printStackTrace();
         }
    }
    }
}
