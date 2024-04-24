import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
while(true) {
    Sort s1;
    Sort s2;
    Scanner sc = new Scanner(System.in);
    System.out.println("1. Ascending " +
            "2.Descending " +
            "3.Random " +"\n"+
            "press 0 to exit" + "\n");
    int option = sc.nextInt();
    Random random = new Random();
    if (option == 1) {

            int[] arr;
            System.out.println("length of the array:");
            int n = sc.nextInt();
            arr = new int[n];
            int r1 = random.nextInt(10000);
            int r2 = random.nextInt(10);
            arr[0] = r2;
            for (int i = 1; i < n; i++) {
                arr[i] = arr[i - 1] + r2;
            }
            s1 = new Sort(arr);
            s2 = new Sort(arr);
            long startTime1 = System.nanoTime();
            s1.quicksort(s1.getLower_bound(), s1.getUpper_bound());
            s1.printArr();
            long endTime1 = System.nanoTime();
            long totalTime1 = endTime1 - startTime1;
            System.out.println("for quicksort " + totalTime1/1000);
            System.out.println("\n");
            long startTime2 = System.nanoTime();
            s2.mergesort(s2.getLower_bound(), s2.getUpper_bound());
            s2.printArr();
            long endTime2 = System.nanoTime();
            long totalTime2 = endTime2 - startTime2;
            System.out.println("for mergesort " + totalTime2/1000);
            System.out.println("\n");
    }
    else if (option == 2) {

        int[] arr;
        System.out.println("length of the array:");
        int n = sc.nextInt();
        arr = new int[n];
            int r1 = random.nextInt(10000);
            int r2 = random.nextInt(10);
            arr[0] = r1;
            for (int i = 1; i < n; i++) {
                arr[i] = arr[i - 1] - r2;
            }
            s1 = new Sort(arr);
            s2 = new Sort(arr);
            long startTime1 = System.nanoTime();
            s1.quicksort(s1.getLower_bound(), s1.getUpper_bound());
            s1.printArr();
            long endTime1 = System.nanoTime();
            long totalTime1 = endTime1 - startTime1;
            System.out.println("for quicksort " + totalTime1/1000);
            System.out.println("\n");
            long startTime2 = System.nanoTime();
            s2.mergesort(s2.getLower_bound(), s2.getUpper_bound());
            s2.printArr();
            long endTime2 = System.nanoTime();
            long totalTime2 = endTime2 - startTime2;
            System.out.println("for mergesort " + totalTime2/1000);
            System.out.println("\n");

    }
    else if (option == 3) {
        int[] arr;
        System.out.println("length of the array:");
        int n = sc.nextInt();
        arr = new int[n];
            for (int i = 1; i < n; i++) {
                arr[i] = random.nextInt(10000);
            }
            s1 = new Sort(arr);
            s2 = new Sort(arr);
            long startTime1 = System.nanoTime();
            s1.quicksort(s1.getLower_bound(), s1.getUpper_bound());
            s1.printArr();
            long endTime1 = System.nanoTime();
            long totalTime1=endTime1 - startTime1;
            System.out.println("for quicksort " + totalTime1/1000);
            System.out.println("\n");
            long startTime2 = System.nanoTime();
            s2.mergesort(s2.getLower_bound(), s2.getUpper_bound());
            s2.printArr();
            long endTime2 = System.nanoTime();
            long totalTime2 = endTime2 - startTime2;
            System.out.println("for mergesort " + totalTime2/1000);
            System.out.println("\n");

    }
    else if (option==0){
        return;
    }
}
    }

}
