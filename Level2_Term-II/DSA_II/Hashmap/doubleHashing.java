import java.util.ArrayList;

public class doubleHashing {
    private HashNode[] hash;
    private int collisions;
    private int probes;
    private int N;
    private hashFunction h;

    public doubleHashing(int n) {

        N = n;
        this.hash = new HashNode[n] ;
        this.collisions = 0;
        this.probes = 0;
        this.h=new hashFunction(n);
        for (int i = 0; i < n; i++) {
            hash[i]= null;

        }
    }

    public int getCollisions() {
        return collisions;
    }


    public int getProbes() {
        return probes;
    }


    public int getHashval(int k, int i, String aux){
        int hashval=(k+i*h.auxhash1(aux))% (N);
        return hashval;
    }

    public void insert(HashNode<String,Integer> hashNode, int k){
        int i=0;
        while (i<N) {
            //System.out.println(getHashval(k,i,hashNode.getKey()));
            if (hash[getHashval(k,i,hashNode.getKey())] == null) {
                hash[getHashval(k,i,hashNode.getKey())]= hashNode;
                return;
            } else {
                i++;collisions++;
            }
        }
    }

    public boolean search(HashNode<String,Integer> hashNode,int k) {

        int i = 0;
        while (i < N) {
            if (hash[getHashval(k, i,hashNode.getKey())].getKey() == hashNode.getKey()) {
                return true;
            } else {
                i++;probes++;
            }
        }
        return false;
    }
    public void delete(HashNode<String,Integer> hashNode,int k){
        int i=0;
        while (i<N){
            if (hash[getHashval(k, i,hashNode.getKey())].getKey() == hashNode.getKey()) {
              return;
            } else {
                i++;
            }
            System.out.println("not inserted yet");
        }
    }

}
