import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        Player p;
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N > 0) {
            for (int i = 1; i <= N; i++) {
                if (sc.hasNextInt()) {
                    p = new Player(i, sc.nextInt());
                    gameController.addPlayer(p);
                } else {
                    System.out.println("invalid");
                }
            }
            while (true) {
                Scanner sc1 = new Scanner(System.in);
                String commands = sc1.nextLine();
                String[] Commands = new String[3];
                Commands = commands.split(" ");
                try {
                    int Timing = Integer.parseInt(Commands[0]);
                    gameController.traverse(Timing);
                    if (Commands[1].equalsIgnoreCase("p")) {
                        System.out.println("Player " + gameController.getCurr_holder().getPillow_passer().getPlayer_Id()+ " is holding the pillow at t= " + Timing);
                    }
                    else if ((Commands[1].equalsIgnoreCase("m"))) {
                        if(gameController.getCurr_holder()== gameController.getFirst()&& gameController.getCurr_holder()==gameController.getLast())
                        {
                        }
                        else{
                        gameController.remove(gameController.getCurr_holder());
                        System.out.println("Player " + gameController.getCurr_holder().getPillow_passer().getPlayer_Id() + " has been eliminated at t= " + Timing);
                      if(gameController.isForward()){
                        gameController.setCurr_holder(gameController.getCurr_holder().getNext_node());}
                      else {
                          gameController.setCurr_holder(gameController.getCurr_holder().getPrev_node());}

                          GameController.time=Timing+gameController.getCurr_holder().getPillow_passer().getReflex_time();}
                    }
                    else if (Commands[1].equalsIgnoreCase("r")) {
                        gameController.setForward(!gameController.isForward());
                    }
                    else if (Commands[1].equalsIgnoreCase("i")) {
                        int reflex = Integer.parseInt(Commands[2]);
                        N = N + 1;
                        p = new Player(N, reflex);
                        Node node = new Node(p, null, null);
                        gameController.Insert(gameController.getCurr_holder(), node);
                    } else if (Commands[1].equalsIgnoreCase("f")) {
                        if(gameController.getCurr_holder()== gameController.getFirst()&& gameController.getCurr_holder()==gameController.getLast())
                        {
                            System.out.println("player " + gameController.getCurr_holder().getPillow_passer().getPlayer_Id()+ " wins!");
                        }
                        else{
                        System.out.println("Game over : Player " + gameController.getCurr_holder().getPillow_passer().getPlayer_Id() + " is holding the pillow at t=" + Timing +
                                ", pillow passing sequence = "+"\n"+"Player ");
                        gameController.sequence(gameController.getCurr_holder());}
                        break;
                    } else {
                        System.out.println("invalid command");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("invalid format");
                }
            }
        } else {
            System.out.println("N should be positive");
        }
    }
}
