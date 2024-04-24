import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String IN = "C:\\Users\\ECC\\IdeaProjects\\BinomialMaxheap\\src\\input.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(IN));
            BinoMialHeap b = new BinoMialHeap(null);
            while (true) {
                String[] input = br.readLine().split(" ");
                if (input[0].equalsIgnoreCase("INS")) {
                    if (b.getHead() == null) {

                        b.setHead(new heapNode(Integer.parseInt(input[1])));
                    } else {

                        b.Insert(Integer.parseInt(input[1]));
                    }
                } else if (input[0].equalsIgnoreCase("INC")) {
                    b.increaseKey(Integer.parseInt(input[1]), Integer.parseInt(input[2]));
                } else if (input[0].equalsIgnoreCase("EXT")) {
                    b.ExtractMax();
                } else if (input[0].equalsIgnoreCase("FIN")) {
                    System.out.println("FIND MAX RETURNED " + b.FindMax().getKey());
                } else if (input[0].equalsIgnoreCase("PRI")) {
                    System.out.println("Printing Binomial Heap....");
                    System.out.println("-------------------------------------------");
                    b.print();
                }
                if (input[0].equalsIgnoreCase("end"))
                    break;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
