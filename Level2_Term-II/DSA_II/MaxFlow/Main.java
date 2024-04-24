import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= Integer.parseInt(sc.nextLine());
         int[] w=new int[n];
        int[] l=new int[n];
        int[] r=new int[n];
         String[] teams=new  String[n];
         int[][] g=new  int[n][n];
        for (int i = 0; i < n; i++) {
           String[] input= sc.nextLine().split(" ") ;
           teams[i]=input[0];
           w[i]= Integer.parseInt(input[1]);
           l[i]= Integer.parseInt(input[2]);
           r[i]= Integer.parseInt(input[3]);
            for (int j = 0; j < n; j++) {
                g[i][j]= Integer.parseInt(input[j+4]);
            }
        }

       GameDescriber des= new GameDescriber(w,l,r,teams,g,n);
    }
}
