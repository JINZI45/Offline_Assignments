import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree t=new BinarySearchTree();
        BinarySearchTree tree = new BinarySearchTree();
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Insert Item" + "\n" +
                "2. Search Item" + "\n" +
                "3. Get In Order Successor" + "\n" +
                "4. Get In Order Predecessor" + "\n" +
                "5. Delete Item" + "\n" +
                "6. Get Item Depth" + "\n" +
                "7. Get Max Item" + "\n" +
                "8. Get Min Item" + "\n" +
                "9. Get Height" + "\n" +
                "10. Print In Order" + "\n" +
                "11. Print Pre Order" + "\n" +
                "12. Print Post order" + "\n" +
                "13. Get Size" + "\n" +
                "0 to Exit " + "\n");

        try {
        while (true) {

                System.out.println("Enter menu options");
                int opt = sc.nextInt();
                Scanner sc1 = new Scanner(System.in);
                if (opt == 1) {
                    System.out.println("enter numbers:");
                    String num = sc1.nextLine();
                    String[] numbers = num.split(" ");
                    for (int i = 0; i < numbers.length; i++) {
                        int nums=Integer.parseInt(numbers[i]);
                        if(nums<0){
                            System.out.println("please enter positive number");
                        }
                        else {
                        tree.insertItem(nums);}
                    }
                }
                else if (opt == 2) {
                    System.out.println("enter value:");
                    int value = sc1.nextInt();
                    tree.searchItem(tree.getRoot(), value);
                }
                else if (opt == 3) {
                    System.out.println("enter value:");
                    int value = sc1.nextInt();
                    if(tree.getInOrderSuccessor(value)==-1){
                        System.out.println("not found");
                    }
                    else
                    System.out.println(tree.getInOrderSuccessor(value));
                }
                else if (opt == 4) {
                    System.out.println("enter value:");
                    int value = sc1.nextInt();
                    if(tree.getInOrderPredecessor(value)==-1){
                        System.out.println("not found");
                    }
                    else
                    System.out.println(tree.getInOrderPredecessor(value));
                }
                else if (opt == 5) {
                    System.out.println("enter value:");
                    int value = sc1.nextInt();
                    tree.deleteItem(tree.getRoot(), value);
                    System.out.println();
                }
                else if (opt == 6) {
                    System.out.println("enter value:");
                    int value = sc1.nextInt();
                    if (tree.getItemDepth(tree.getRoot(), value)==-1){
                        System.out.println("Item not found");
                    }
                    System.out.println(tree.getItemDepth(tree.getRoot(), value));
                }
                else if (opt == 7) {
                    System.out.println(tree.getMaxItem(tree.getRoot()));
                }
                else if (opt == 8) {
                    System.out.println(tree.getMinItem(tree.getRoot()).getValue());
                }
                else if (opt == 9) {
                    System.out.println(tree.getHeight(tree.getRoot()));
                }
                else if (opt == 10) {
                   tree.printInOrder(tree.getRoot());
                }
                else if (opt == 11) {
                    tree.printPreOrder(tree.getRoot());
                }
                else if (opt == 12) {
                    tree.printPostOrder(tree.getRoot());
                }
                else if (opt == 13) {
                    System.out.println(tree.getSize(tree.getRoot()));
                }
                else if (opt == 0) {
                    return;
                }

            }
        } catch (Exception e) {
            System.out.println("invalid input format");
        }

    }
}

