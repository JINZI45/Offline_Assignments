import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n= sc.nextInt();
        String[] input=new String[n];
        Random random= new Random();

        for (int i = 0; i < n; ) {
            StringBuffer sb= new StringBuffer(7);
            for (int j = 0; j < 7; j++) {
                sb.append((char)(97+random.nextInt(26)));
            }
            String a=sb.toString();
            if(Arrays.asList(input).contains(a))
                continue;
            input[i]=a;
            i++;
        }
        Chaining chaining=new Chaining(n+7);
        hashFunction hashFunction=new hashFunction(n+7);
        doubleHashing doubleHashing=new doubleHashing(n+7);
        customHashing customHashing=new customHashing(n+7);
        // for hash 1
        for (int i = 0; i < n; i++) {
            chaining.insert(new HashNode<String,Integer>(input[i],i),hashFunction.hash1(input[i]));
            doubleHashing.insert(new HashNode<String,Integer>(input[i],i),hashFunction.hash1(input[i]));
            customHashing.insert(new HashNode<String,Integer>(input[i],i),hashFunction.hash1(input[i]));
        }
        //search
        for (int i = 0; i < n/10; i++) {
            int k=random.nextInt(n);
             chaining.search(new HashNode<>(input[k],k),hashFunction.hash1(input[k]));
            doubleHashing.search(new HashNode<>(input[k],k),hashFunction.hash1(input[k]));
            customHashing.search(new HashNode<>(input[k],k),hashFunction.hash1(input[k]));
        }
        System.out.println("coll1 "+ chaining.getCollisions());
        System.out.println("colld1 "+ doubleHashing.getCollisions());
        System.out.println("collc1 "+ customHashing.getCollisions());
        System.out.println("prob1 "+ chaining.getProbes());
        System.out.println("probd1 "+ doubleHashing.getProbes());
        System.out.println("probc1 "+ customHashing.getProbes());
        // for hash 2
        Chaining chaining2=new Chaining(n+7);
        doubleHashing doubleHashing2=new doubleHashing(n+7);
        customHashing customHashing2=new customHashing(n+7);
        for (int i = 0; i < n; i++) {
            chaining2.insert(new HashNode<String,Integer>(input[i],i),hashFunction.hash2(input[i]));
            doubleHashing2.insert(new HashNode<String,Integer>(input[i],i),hashFunction.hash2(input[i]));
            customHashing2.insert(new HashNode<String,Integer>(input[i],i),hashFunction.hash2(input[i]));
        }
        //search
        for (int i = 0; i < n/10; i++) {
            int k=random.nextInt(n);
            chaining2.search(new HashNode<>(input[k],k),hashFunction.hash2(input[k]));
            doubleHashing2.search(new HashNode<>(input[k],k),hashFunction.hash2(input[k]));
            customHashing2.search(new HashNode<>(input[k],k),hashFunction.hash2(input[k]));
        }
        System.out.println("coll2 "+ chaining2.getCollisions());
        System.out.println("colld2 "+ doubleHashing2.getCollisions());
        System.out.println("collc2 "+ customHashing2.getCollisions());
        System.out.println("prob2 "+ chaining2.getProbes());
        System.out.println("probd2 "+ doubleHashing2.getProbes());
        System.out.println("probc2 "+ customHashing2.getProbes());

    }
}
