import java.util.ArrayList;

public class Graph {
    private int verticesNo;
    private ArrayList<LinkedList<places> > adjList;

    public Graph(int verticesNo) {
        this.verticesNo = verticesNo;
        adjList = new ArrayList<LinkedList<places>>(verticesNo);

        for (int i=0;i<verticesNo;i++) {
            adjList.add(new LinkedList<places>());
            adjList.get(i).add(new places(i));
        }
    }


    public void addEdges(int v1, int v2){
        places p1= new places(v1);
        places p2= new places(v2);
        adjList.get(v1).add(p2);
        adjList.get(v2).add(p1);
    }
    public int bfs(int root) {
        Queue<Integer> queue= new Queue<>();
        int v;
        queue.enque(root);
        int collectedPieces=0;
        while (!queue.isEmpty()){
            v= queue.peek();
            Node<places> u=adjList.get(v).getFirst();
            while (u!=null){
                if (!u.getValue().isVisited()){
                queue.enque(u.getValue().getLoacation());
                collectedPieces=collectedPieces+u.getValue().getPieces();
                u.getValue().setVisited(true);
                }
                u= u.getNext_node();
            }
            queue.deque();
        }
        return collectedPieces;
    }
    public int dfs(int root) {
        Stack<Integer> stack = new Stack<>();
        int v = root;
        stack.push(v);
        //System.out.println(stack.peek());
        int collectedPieces=0;
        while (!stack.isEmpty()) {
            v=stack.peek();
            Node<places> u = adjList.get(v).getFirst();
            while (u!=null){
                if (!u.getValue().isVisited()){
                    stack.push(u.getValue().getLoacation());
                    //System.out.println(stack.peek());
                    collectedPieces=collectedPieces+u.getValue().getPieces();
                    u.getValue().setVisited(true);
                    break;
                }
                else {
                    u=u.getNext_node();
                }
            }
            if(u==null){
                stack.pop();
            }
        }
        return collectedPieces;
    }
    public places find(int l){
        for(int i=0; i<verticesNo;i++){
            Node<places> u= adjList.get(i).getFirst();
            do {
                if(u.getValue().getLoacation()==l){
                    return u.getValue();
                }
                else{
                    u=u.getNext_node();
                }
            }
        while ((u!=null));
        }
        return null;
    }
   /* public void print(){
        for (int i=0;i<verticesNo;i++){
            adjList.get(i).print();
            System.out.println(i+"j");
        }
    }*/
}
class places{
    private int loacation;
    private int pieces;
    private boolean visited;

    public places(int loacation) {
        this.loacation = loacation;
        pieces = 0;
        visited = false;
    }

    public int getLoacation() {
        return loacation;
    }

    public void setLoacation(int loacation) {
        this.loacation = loacation;
    }

    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
