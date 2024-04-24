public class Queue<T> {
    private LinkedList<T> list;

    public Queue() {
        list = new LinkedList<>();
    }

    public void enque(T value) {

        list.add(value);
    }

    public void deque() {
        list.removeFirst();
    }

    public T peek(){
        return list.getFirst().getValue();
    }

    public boolean isEmpty(){
        if(list.getFirst()==null){
            return true;
        }
        return false;
    }
}