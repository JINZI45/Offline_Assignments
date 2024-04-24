import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        houseSearch House = new houseSearch();
        String IN = "input.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(IN));

                int n;
                n = Integer.parseInt(br.readLine());
                house[] h = new house[n];
                for (int i = 0; i < n; i++) {
                    String[] input = br.readLine().split(" ");
                    h[i] = new house(i, Double.parseDouble(input[0]), Double.parseDouble(input[1]));
                }

                House.sec_closestHouse(h, n);
                br.close();
            }

         catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
