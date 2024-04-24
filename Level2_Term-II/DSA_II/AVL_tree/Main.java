import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        AVL avl=new AVL();
        //Scanner sc= new Scanner(System.in);
        String[] input;
        String line;
        BufferedReader br= new BufferedReader(new FileReader("C:\\Users\\ECC\\IdeaProjects\\AVL-offline\\src\\input.txt"));

        while ((line= br.readLine())!=null){
            input = line.split(" ");
            if (input[0].equals("F")) {
                if (!avl.searchItem(avl.getRoot(), Integer.parseInt(input[1]))) {
                    System.out.println("False");
                } else {
                    System.out.println("True");
                }
            } else if (input[0].equals("I")) {

                avl.insertItem(Integer.parseInt(input[1]));

              avl.print(avl.getRoot());
                System.out.println();
            }
            else if (input[0].equals("D")) {

                avl.setRoot(avl.deleteItem(avl.getRoot(),Integer.parseInt(input[1])));
                avl.print(avl.getRoot());
                System.out.println();
            }
        }

}}
