import static java.lang.Math.abs;
public class hashFunction {
    private int n;

    public hashFunction(int n) {
        this.n = n;
    }


    public int auxhash1(String s){
        int hash=0;
        for (int i = 0; i < s.length(); i++) {
            hash+=(s.charAt(i))%n;
        }
        return hash;
    }


    public int hash2(String s){
        int hash=1;
        for (int i = 0; i < s.length(); i++) {
            hash=abs(hash*33+s.charAt(i))%n;
        }

        return hash;
    }


    public int hash1(String s){
        int hash=0;
        for (int i = 0; i < s.length(); i++) {
            hash=(s.charAt(i)+abs(hash*655))%n;
        }
        return hash;
    }
}
