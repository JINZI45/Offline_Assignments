import java.util.ArrayList;

public class customHashing {
    private HashNode[] hash;
    private int collisions;
    private int probes;
    private int N,c1,c2;
    private hashFunction h;

    public customHashing(int n) {

        N = n;
        this.hash = new HashNode[n] ;
        this.collisions = 0;
        this.probes = 0;
        this.h=new hashFunction(n);
        for (int i = 0; i < n; i++) {
            hash[i]=null;
        }
    }

    public int getCollisions() {
        return collisions;
    }

    public int getProbes() {
        return probes;
    }

    public int getHashval(int k, int i, String aux){
        int hashval=(k+c1*i*h.auxhash1(aux)+ c2*i*i)% (N);
        return hashval;
    }

    public void insert(HashNode<String,Integer> hashNode, int k){
        int i=0;
        while (i<N) {
            if (hash[getHashval(k,i,hashNode.getKey())] == null) {
                hash[getHashval(k,i,hashNode.getKey())]= hashNode;
                return;
            } else {
                i++;collisions++;
            }
        }
    }

    public boolean search(HashNode<String,Integer> hashNode, int k) {

        int i = 0;
        while (i < N) {
            if (hash[getHashval(k, i, hashNode.getKey())].getKey() == hashNode.getKey()) {
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
