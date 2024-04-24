import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while (true) {
            Scanner sc= new Scanner(System.in);
            System.out.println("1. for dikjstra"
            +"\n"+"2.for bellman ford");
            int opt= sc.nextInt();


            String IN = "C:\\Users\\ECC\\IdeaProjects\\ShortestPath\\src\\input.txt";
            try {
                BufferedReader br = new BufferedReader(new FileReader(IN));
                String[] input = br.readLine().split(" ");
                int v = Integer.parseInt(input[0]);
                int e = Integer.parseInt(input[1]);
                if(opt==1){
                    boolean correct=true;
                    ShortesPath shortesPath = new ShortesPath(v, e);
                for (int i = 0; i < e; i++) {
                    input = br.readLine().split(" ");
                    if(Integer.parseInt(input[2])>0 && opt==1)
                        shortesPath.addEdge(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                    else {correct=false;
                    break;}
                }
                    input=br.readLine().split(" ");
                if (correct)
                    shortesPath.dikjstra(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
                else System.out.println("wrongggggggg");
                }

                else if (opt==2){
                    ArrayList<vertex> Edges = new ArrayList<>(e);
                    for (int i = 0; i < e; i++) {
                        input = br.readLine().split(" ");
                        Edges.add(new vertex(Integer.parseInt(input[0]), Integer.parseInt(input[1]), Integer.parseInt(input[2])));
                        }
                    bellmanford bellmanford = new bellmanford(v, e, Edges);
                    input=br.readLine().split(" ");
                bellmanford.shortest(Integer.parseInt(input[0]), Integer.parseInt(input[1]));}
                else break;

            } catch(Exception e){
            e.printStackTrace();
        }
    }
    }
}
