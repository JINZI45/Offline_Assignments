public class GameController {
    private Node first;
    private Node last;
    private static boolean forward=true;
    public static int time = 0;
    private Node curr_holder;

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }
    public Node getCurr_holder() {
        return curr_holder;
    }

    public void setCurr_holder(Node curr_holder) {
        this.curr_holder = curr_holder;
    }

    public  boolean isForward() {
        return forward;
    }

    public void setForward(boolean forward) {
        GameController.forward = forward;
    }

    public GameController() {
        this.first = null;
        this.last = null;
    }

    public void addPlayer(Player player) {
        Node new_node = new Node(player, null, null);
        if (first == null) {
            new_node.setNext_node(new_node);
            new_node.setPrev_node(new_node);
            first = new_node;
            last = first;
            time= first.getPillow_passer().getReflex_time();
            setCurr_holder(first);
        } else {
            new_node.setNext_node( first);
            new_node.setPrev_node(last);
            first.setPrev_node(new_node);
            last.setNext_node(new_node);
            last = new_node;
        }
    }

    public void Insert(Node curr_node, Node node) {

        if (forward) {
            if (curr_node==first&&curr_node==last){
            }else {
            Node temp = curr_node.getPrev_node();
            node.setNext_node(curr_node);
            node.setPrev_node(temp);
            temp.setNext_node(node);
            curr_node.setPrev_node(node);
                       if (curr_node == first) {
                first = node;
            }
        }} else {
            if (curr_node==first&&curr_node==last){
            }else {
            Node temp = curr_node.getNext_node();
            node.setNext_node(temp);
            node.setPrev_node(curr_node);
            curr_node.setNext_node(node);
            temp.setPrev_node(node);
            if (curr_node == last) {
                last = node;
            }
        }}
    }

    public void remove(Node curr_holder) {
        if (curr_holder==first&&curr_holder==last){
        }else {
        Node temp1 = curr_holder.getNext_node();
        Node temp2 = curr_holder.getPrev_node();
        temp2.setNext_node(temp1);
        temp1.setPrev_node(temp2);
        if(curr_holder==first){
            first=temp1;
        }
        else if (curr_holder==last){
            last=temp2;
        }}
    }

    public void traverse(int command_time) {
        if(command_time<0) {
            System.out.println("time can't be negative");}
        else {
        if (forward) {
            if(time==command_time)
                curr_holder=curr_holder;
            while (time <command_time) {
                curr_holder = curr_holder.getNext_node();
                time = time + curr_holder.getPillow_passer().getReflex_time();
                }
        } else {
            if(time==command_time)
                curr_holder=curr_holder;
            while (time <command_time) {
                if (time == 0) {
                    curr_holder = last;
                    time = last.getPillow_passer().getReflex_time();
                } else {curr_holder = curr_holder.getPrev_node();
                    time = time + curr_holder.getPillow_passer().getReflex_time();

                }
            }
        }}

    }

    public void sequence(Node node) {
        if (forward) {
            Node temp = node;
            while (node.getNext_node() != temp) {
                System.out.println(node.getPillow_passer().getPlayer_Id());
                node = node.getNext_node();
            }
            System.out.println(node.getPillow_passer().getPlayer_Id());
        }
            else{
            Node temp= node;
            while (node.getPrev_node() != temp) {
                System.out.println(node.getPillow_passer().getPlayer_Id());
                node = node.getPrev_node();

            }
            System.out.println(node.getPillow_passer().getPlayer_Id());


    }}
}
class Node{
    private Player pillow_passer;
    private Node next_node;
    private Node prev_node;

    public Node(Player pillow_passer, Node next_node, Node prev_node) {
        this.pillow_passer = pillow_passer;
        this.next_node = next_node;
        this.prev_node = prev_node;
    }

    public Player getPillow_passer() {
        return pillow_passer;
    }

    public void setPillow_passer(Player pillow_passer) {
        this.pillow_passer = pillow_passer;
    }

    public Node getNext_node() {
        return next_node;
    }

    public void setNext_node(Node next_node) {
        this.next_node = next_node;
    }

    public Node getPrev_node() {
        return prev_node;
    }

    public void setPrev_node(Node prev_node) {
        this.prev_node = prev_node;
    }
}
class Player{
    private int player_Id;
    private int reflex_time;

    public Player(int player_Id, int reflex_time) {
        if(player_Id>0&& reflex_time>0 ){
            this.player_Id = player_Id;
            this.reflex_time = reflex_time;
        }
        else {
            System.out.println("id and reflex time should be positive");
        }
    }

    public int getPlayer_Id() {
        return player_Id;
    }

    public void setPlayer_Id(int player_Id) {
        this.player_Id = player_Id;
    }

    public int getReflex_time() {
        return reflex_time;
    }

    public void setReflex_time(int reflex_time) {
        this.reflex_time = reflex_time;
    }
}
