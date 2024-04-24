public class AVL {
    private Node root;

    public AVL() {
        this.root = null;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    private Node roratateRight(Node current) {
        Node newRoot = current.getLeft_child();
        Node temp = newRoot.getRight_child();

        newRoot.setRight_child(current);

        current.setLeft_child(temp);
        return newRoot;
    }

    private Node roratateLeft(Node current) {

        Node newRoot = current.getRight_child();
        Node temp = newRoot.getLeft_child();


        newRoot.setLeft_child(current);
        current.setRight_child(temp);

        return newRoot;
    }

    public int getBalance(Node current) {
        if (current == null)
            return 0;

        return getHeight(current.getLeft_child()) - getHeight(current.getRight_child());
    }

    public void insertItem(int value) {
        root = insert(root, value);
    }

    public Node insert(Node current, int value) {
        if (current == null) {
            current = new Node(value);
        } else {
            if (value < current.getValue()) {
                current.setLeft_child(insert(current.getLeft_child(), value));
            } else if (value > current.getValue()) {
                current.setRight_child((insert(current.getRight_child(), value)));
            }

        }
        int balance=getBalance(current);
        if (balance > 1 && value < current.getLeft_child().getValue()) {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            current=roratateRight(current);
        }
        else if (balance < -1 && value > current.getRight_child().getValue()) {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            current=roratateLeft(current);
        }
        else if (balance > 1 && value> current.getLeft_child().getValue()) {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            current.setLeft_child(roratateLeft(current.getLeft_child()));
            current=roratateRight(current);
        }
        else if (balance < -1 && value < current.getRight_child().getValue()) {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
           // System.out.println("llc"+current.getRight_child().getValue());
            current.setRight_child(roratateRight(current.getRight_child()));
            current=roratateLeft(current);
        }
        //rebalance(getBalance(current), current);

        return current;
    }

    public void rebalance(int balance, Node current) {
        if (balance > 1 && current.getValue() < current.getLeft_child().getValue()) {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            roratateRight(current);
        } else if (balance < -1 && current.getValue() > current.getRight_child().getValue()) {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            roratateLeft(current);
        } else if (balance > 1 && current.getValue() > current.getLeft_child().getValue()) {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            current.setLeft_child(roratateLeft(current.getLeft_child()));
            roratateRight(current);
        } else if (balance < -1 && current.getValue() < current.getLeft_child().getValue()) {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            current.setRight_child(roratateRight(current.getRight_child()));
            roratateLeft(current);
        }
    }

    public boolean searchItem(Node current, int value) {
        boolean found = false;
        if (current == null) {
            //System.out.println(value + " has not been found");
            found = false;
        } else if (current.getValue() == value) {
            //System.out.println(value + " has been found");
            found = true;
        } else if (value < current.getValue()) {
            searchItem(current.getLeft_child(), value);
        } else {
            searchItem(current.getRight_child(), value);
        }
        return found;
    }

    public void print(Node current) {
        if (current == null) {

        } else {
            System.out.print(current.getValue());
            if (current.getLeft_child() != null || current.getRight_child() != null) {
                System.out.print('(');
                print(current.getLeft_child());
                System.out.print(')');
                System.out.print('(');
                print(current.getRight_child());
                System.out.print(')');
            }
        }
    }


    public Node deleteItem(Node current,int value) {

        if (current == null) {
            System.out.println("not found");
            return null;
        } else if (value < current.getValue()) {
            current.setLeft_child(deleteItem(current.getLeft_child(), value));
        } else if (value > current.getValue()) {
            current.setRight_child(deleteItem(current.getRight_child(), value));
        } else {
            if (current.getRight_child() == null) {
                return current.getLeft_child();
            } else if (current.getLeft_child() == null) {
                return current.getRight_child();
            }

            current.setValue(getMinItem(current.getRight_child()).getValue());
            current.setRight_child(deleteItem(current.getRight_child(), current.getValue()));

        }
        int balance=getBalance(current);
        if(balance>1 && getBalance(current.getLeft_child())>=0)
        {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            return roratateRight(current);
        }
        else if(balance<-1 && getBalance(current.getRight_child())<=0)
        {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            return roratateLeft(current);
        }
        else if(balance>1 && getBalance(current.getLeft_child())<0)
        {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            current.setLeft_child(roratateLeft(current.getLeft_child()));
            return roratateRight(current);
        }
        else if(balance<-1 &&  getBalance(current.getRight_child())>0)
        {
            System.out.print("Height invariant violated.\n" +
                    "After rebalancing:");
            current.setRight_child(roratateRight(current.getRight_child()));
            return roratateLeft(current);
        }


        return  current;
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
