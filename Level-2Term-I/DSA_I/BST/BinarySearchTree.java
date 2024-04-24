public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public void insertItem(int value){
        root=insert(root,value);
    }

    private Node insert(Node current, int value) {
        if(current==null){
            current=new Node(value);
        }
        else {
            if(value<current.getValue()){
                current.setLeft_child(insert(current.getLeft_child(),value));
            }
            else if(value>current.getValue()){
                current.setRight_child((insert(current.getRight_child(),value)));
            }
        }
        return current;
    }
    public void searchItem(Node current,int value){
        if(current==null){
            System.out.println(value+ " has not been found");;
        }
        else if(current.getValue()==value){
            System.out.println(value+" has been found");
        }
        else if(value<current.getValue()){
            searchItem(current.getLeft_child(),value);
        }
        else {
            searchItem(current.getRight_child(),value);
        }
    }
    public int getInOrderSuccessor(int value){
        Node current=root;
        Node parent=null;
        boolean tingg=false;
       while (current!=null){
      if(current.getValue()==value){
            tingg=true;
            break;
        }
        else if(value<current.getValue()){
            parent=current;
            current=current.getLeft_child();
        }
        else if(value>current.getValue()) {
            current=current.getRight_child();
        }
       }
        if(tingg){
            if(current.getRight_child()!=null){
                return getMinItem(current.getRight_child()).getValue();
            }
            else{
                if(parent!=null){
                    return parent.getValue();
                }
                else return -1;
            }
        }
        else return -1;
    }
    public int getInOrderPredecessor(int value){
        Node current=root;
        Node parent=null;
        boolean tingg= false;
        while (current!=null){
            if(current.getValue()==value){
                tingg=true;
                break;
            }
            else if(value<current.getValue()){
                current=current.getLeft_child();
            }
            else if(value>current.getValue()) {
                parent= current;
                current=current.getRight_child();
            }
        }
        if (tingg){
            if (current.getLeft_child()!=null){
                return getMaxItem(current.getLeft_child()); }
            else{
                if (parent!=null){
                    return parent.getValue();
                }
                else return -1;
            }
        }
return -1;
    }
    public Node deleteItem(Node current,int value){
        if(current==null){
            System.out.println("not found");
           return null;
        }
        else if (value<current.getValue()){
               current.setLeft_child(deleteItem(current.getLeft_child(),value));
           }
           else if(value> current.getValue()){
               current.setRight_child(deleteItem(current.getRight_child(),value));
        }
           else {
               if(current.getRight_child()==null){
                   return current.getLeft_child();
               }
            else if(current.getLeft_child()==null){
                return current.getRight_child();
            }

                current.setValue(getMinItem(current.getRight_child()).getValue());
                current.setRight_child(deleteItem(current.getRight_child(),current.getValue()));


        }
return  current;
    }
    public int getItemDepth(Node current,int value){
        boolean tingg= false;
        while (current!=null){
            if(current.getValue()==value){
                tingg=true;
                break;
            }
            else if(value<current.getValue()){
                current=current.getLeft_child();
            }
            else if(value>current.getValue()) {
                current=current.getRight_child();
            }
        }
        if (tingg){
            return getHeight(root)-getHeight(current);
        }
        else return -1;
    }
    public Node getMinItem(Node current){
        while (current.getLeft_child()!=null){
            current=current.getLeft_child();
        }
        return current;
    }

    public int getMaxItem(Node current){
        while (current.getRight_child()!=null){
            current=current.getRight_child();
        }
        return current.getValue();
    }
    public int getHeight(Node current){
        if(current==null){
            return -1;
        }
        else {
            int left_max=getHeight(current.getLeft_child());
            int right_max= getHeight(current.getRight_child());
            if (left_max>right_max){
                return left_max+1;
            }
            else return right_max+1;
        }
    }
    public int getSize(Node current){
        if(current==null){
            return 0;
        }
        else {
            return getSize(current.getLeft_child())+ getSize(current.getRight_child())+1;
        }
    }
    public void printInOrder(Node current){
        if(current==null)
        {
        }
        else {
            printInOrder(current.getLeft_child());
            System.out.println(current.getValue());
            printInOrder(current.getRight_child());
        }
    }
    public void printPreOrder(Node current){
        if (current==null){

        }
        else {
            System.out.println(current.getValue());
            printPreOrder(current.getLeft_child());
            printPreOrder(current.getRight_child());
        }
    }
    public void printPostOrder(Node current){
        if(current==null){

        }
        else {
            printPostOrder(current.getLeft_child());
            printPostOrder(current.getRight_child());
            System.out.println(current.getValue());
        }
    }
}
class Node{
    private int value;
    private Node left_child;
    private Node right_child;

    public Node(int value) {
        this.value = value;
        this.left_child = null;
        this.right_child = null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft_child() {
        return left_child;
    }

    public void setLeft_child(Node left_child) {
        this.left_child = left_child;
    }

    public Node getRight_child() {
        return right_child;
    }

    public void setRight_child(Node right_child) {
        this.right_child = right_child;
    }
}