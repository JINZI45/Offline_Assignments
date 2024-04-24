import java.util.ArrayList;
import java.util.LinkedList;

public class Chaining {

    private ArrayList<LinkedList<HashNode<String,Integer>>> hash;
    private int collisions;
    private int probes;
    private int N;

    public Chaining(int n) {
        this.N = n;
        this.hash = new ArrayList<>(n);
        this.collisions = 0;
        this.probes = 0;
        for (int i = 0; i < n; i++) {
            hash.add(new LinkedList<HashNode<String, Integer>>());
        }
    }

    public int getCollisions() {
        return collisions;
    }

    public int getProbes() {
        return probes;
    }

    public void insert(HashNode<String,Integer> hashNode, int hashVal){

        if(!hash.get(hashVal%(N)).isEmpty()){
            collisions++;
        }
        hash.get(hashVal).add(hashNode);
    }


    public boolean search(HashNode<String,Integer> hashNode,int hashVal){
        if(hash.get(hashVal%(N)).isEmpty())
            return false;
        else {
            for (HashNode<String,Integer> h:hash.get(hashVal%(N))) {
                if(h.getKey().equals(hashNode.getKey()))
                    return true;
                probes++;
            }
        }
        return false;
    }
    public void delete(HashNode<String,Integer> hashNode,int hashVal){
        if(hash.get(hashVal%(N)).isEmpty())
            System.out.println("not inserted yet");
        else {
            for (HashNode<String,Integer> h:hash.get(hashVal%(N))) {
                if(h.getKey().equals(hashNode.getKey())){
                    hash.remove(h);
                    return;
                }

            }
            System.out.println("not inserted yet");
        }
    }
}
class HashNode<K,V>{
    private K key;
    private  V value;

    public HashNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
