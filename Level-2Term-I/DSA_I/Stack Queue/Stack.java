public class Stack<T> {
    private LinkedList<T>list;

    public Stack(LinkedList<T> list) {
        this.list = list;
    }

    public void push(T value){
        list.addFirst(value);
        //System.out.println(list.getFirst().getValue());
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
