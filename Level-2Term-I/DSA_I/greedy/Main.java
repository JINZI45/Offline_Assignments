import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String[] input= sc.nextLine().split(" ",2);
        int n= Integer.parseInt(input[0]);
        int k=Integer.parseInt(input[1]);
        String[] plant= sc.nextLine().split(" ",n);
        int plant_price[]= new int[n];
        for (int i=0;i<n;i++){
            plant_price[i]= Integer.parseInt(plant[i]);
        }
        Plants plants=new Plants(n,plant_price,k);
        System.out.println(plants.minimumCost());
    }
}
