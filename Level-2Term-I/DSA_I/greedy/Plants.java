import java.util.Arrays;

public class Plants {
    private int n;
    private int[] price;
    private int friends;
    private int[] plant_num;

    public Plants(int n, int[] price, int friends) {
        this.n = n;
        this.price = price;
        this.friends = friends;
        this.plant_num= new int[friends];
        Arrays.sort(price);
    }
    public int minimumCost(){
        int cost=0;
        int i=n-1, j=0;
            while (j<friends && i >=0){
                cost= cost+price[i]*(plant_num[j]+1);
                plant_num[j]+=1;
                i--;
                j++;
                if(j== friends){
                    j=0;
                }
            }
        return cost;
    }
}
