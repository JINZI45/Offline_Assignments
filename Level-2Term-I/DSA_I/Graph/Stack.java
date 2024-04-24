public class Stack<T> {
    private LinkedList<T>list;

    public Stack() {
        list = new LinkedList<>();
    }

    public void push(T value){
        list.addFirst(value);

    }
    public T pop(){
        return list.removeFirst();
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

