import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
      /*  Scanner sc= new Scanner(System.in);
        String[] input =sc.nextLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        Edge edge[]= new Edge[e];
        for (int i = 0; i < e; i++) {
            input=sc.nextLine().split(" ");
            edge[i]=new Edge(Float.parseFloat(input[2]),Integer.parseInt(input[0]),Integer.parseInt(input[1]));
        }
        MST mst= new MST(edge,e,v);
        mst.kruskal();

    }*/
try{

        String IN = "C:\\Users\\ECC\\IdeaProjects\\graphTemplate\\src\\mst.txt";
            BufferedReader br = new BufferedReader(new FileReader(IN));
            String[] input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            Edge edge[]= new Edge[e];
            for (int i = 0; i < e; i++) {
                input=br.readLine().split(" ");
                edge[i]=new Edge(Float.parseFloat(input[2]),Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            }
            MST mst= new MST(edge,e,v);
            mst.kruskal();
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
