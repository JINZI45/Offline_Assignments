import java.io.BufferedReader;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        String IN = "input.txt";
        try {
            BufferedReader br = new BufferedReader(new FileReader(IN));
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int s = Integer.parseInt(input[1]);
            input = br.readLine().split(" ");
            int[] dice_face = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dice_face[i] = Integer.parseInt(input[i - 1]);
            }
            Dice dice = new Dice(n, s, dice_face);
            System.out.println(dice.ways());
            br.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
