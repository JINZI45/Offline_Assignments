import java.util.Scanner;

public class Queue {
    private LinkedList<Character> list;

    public Queue(LinkedList<Character> list) {
        this.list = list;
    }

    public  void enque(char value){

        list.add(value);
    }
    public void deque(){
        list.removeFirst();
    }

        public String Find(String s){

            int[] count= new int[26];
            String v=new String("");
            int i=0;
            for( i=0;i<s.length();i++){
                enque(s.charAt(i));
                count[s.charAt(i)-'a']++;
            while (list.getFirst()!=null){
                if(count[list.getFirst().getValue()-'a']>1){
                    deque();
                }
                else {
                    v=v+String.valueOf(list.getFirst().getValue());
                  break;}
            }

            if (list.getFirst()==null){
                v=v+"#";
                }
}
            return v;
    }
        public static void main(String[] args) {
        LinkedList<Character> list=new LinkedList<Character>();
            Queue queue= new Queue(list);
            Scanner sc= new Scanner(System.in);
            String old_string= sc.nextLine();
           String new_string= queue.Find(old_string);
            System.out.println(new_string);
        }
    }
