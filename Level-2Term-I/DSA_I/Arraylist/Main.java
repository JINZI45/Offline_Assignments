import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Array a ;
        Array b= new Array(10);
        System.out.println(b.getArray());
        String[] h= {"mary","john","godric" ,"harry", "mary","fox","sheng","mary",};
        Array c= new Array(h);
        System.out.println(Arrays.toString(c.getArray()));
        System.out.println(c.length());
        System.out.println(Arrays.toString(c.findIndex("mary")));
        System.out.println(c.getAnElement(7));
        c.add("jinzi");
        c.add(4,"luozhi");
        System.out.println(Arrays.toString(c.getArray()));
        c.remove("mary");
        System.out.println(Arrays.toString(c.getArray()));
        String[] n= {"a","b","d","g", "j","k","m"};
        String[]m={"c","e","f","h","l","m","n","o"};
        b.merge(m, n);
        System.out.println(Arrays.toString(b.getArray()));
        System.out.println(b.isEmpty());

        System.out.println(Arrays.toString(c.subArray(2, 5)));

    }
}
