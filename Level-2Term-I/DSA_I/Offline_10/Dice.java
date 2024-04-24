public class Dice {
    private int n;
    private int s;
    private int[] faces;
    private long[][] cum_sums;

    public Dice(int n, int s, int[] faces) {
        this.n = n;
        this.s = s;
        this.faces = faces;
        this.cum_sums = new long[n+1][s+1];
    }

    public long ways(){
        int M=1000000007;
        cum_sums[0][0]=1;
        for (int i=1;i<=faces[1]&& i<=s;i++){
            cum_sums[1][i]=1;
        }
        for (int i=2; i<=n;i++)
        {
            for (int j=i;j<=s;j++){
                if((j-faces[i]-1)>=0){
                    cum_sums[i][j]=((cum_sums[i][j-1]+cum_sums[i-1][j-1])%M-(cum_sums[i-1][j-faces[i]-1])%M+M)%M;
                }

                else cum_sums[i][j]=(cum_sums[i][j-1]+cum_sums[i-1][j-1])%M;

            }
        }
        return cum_sums[n][s];
    }
}
