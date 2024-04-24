public class LinkedList<T> {
    private Node<T> first;
    private Node<T> last;

    public Node<T> getFirst() {
        return first;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    public Node<T> getLast() {
        return last;
    }

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public LinkedList() {
        this.first = null;
        this.last = null;
    }

    public void add(T value){
        Node<T> new_node = new Node<T>(value);
        if (first == null) {
            new_node.setNext_node(new_node);
            first = new_node;
            last=first;
            last.setNext_node(null);

        } else {
            last.setNext_node(new_node);
            last = new_node;
        }
    }
    public void addFirst(T value){
        Node<T> new_node = new Node<T>(value);
        if (first == null) {
            new_node.setNext_node(new_node);
            first = new_node;
            last=first;
            last.setNext_node(null);

        } else {
            new_node.setNext_node(first);
            first = new_node;
        }
    }
    public T removeFirst(){
        T value = null;
        if(first!=null){
            value= (T) first.getValue();
            first=first.getNext_node();
        }
        return value;
    }
}
class Node<T>{
    private T value;
    private Node<T> next_node;

    public Node(T value) {
        this.value = value;
        this.next_node = null;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Node<T> getNext_node() {
        return next_node;
    }

    public void setNext_node(Node<T> next_node) {
        this.next_node = next_node;
    }
}
