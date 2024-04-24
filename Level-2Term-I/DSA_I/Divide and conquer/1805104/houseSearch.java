import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;

public class houseSearch {
    private static int[] houses= new  int[4];

    public double distance(house h1, house h2){
        return Math.sqrt((Math.pow((h1.getX()- h2.getX()),2)+ Math.pow((h1.getY()-h2.getY()),2)));
    }

    public double[] strip(house[] h_x, house[] h_y, int n,int mid_prev){

        if(n<=3){
           return bruteforce(h_x,n);
        }

        int mid= n/2;
        int s= mid+ mid_prev;
        house mid_house= h_x[s];
        house[] h_y_left=new house[mid];
        house[] h_y_right=new house[n-mid];

        for (int r=0,l=0,i=0;i<n;i++){
            if(h_y[i].getX_index()<= mid_house.getX_index()&& l<mid){
                h_y_left[l]=h_y[i];
                l++;
            }

            else {
                h_y_right[r]=h_y[i];
                r++;
            }
        }
        double[] d_l = strip(h_x,h_y_left,mid,mid_prev);
        double[] d_r = strip(h_x, h_y_right,n-mid,s);
        double[] d_min= min(d_l,d_r);
        house[] strips=new house[n];
        int j=0;
        for (int i=0;i<n;i++){
            if(Math.abs(mid_house.getX()-h_y[i].getX())<d_min[1]){
                strips[j]=h_y[i];
                j++;
            }
        }
        return strip_second(strips,j,d_min);

    }

    private double[] bruteforce(house[] h_x, int n) {
        double[] d_min= {100000000,1000000000};
        for (int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                double dist=distance(h_x[i],h_x[j]);
                if(dist<d_min[1]){
                    if(dist<d_min[0]){
                    d_min[1]=d_min[0];
                    d_min[0]=distance(h_x[i],h_x[j]);
                    houses[2]=houses[0];
                    houses[3]=houses[1];
                    houses[0]=h_x[i].getIndex();
                    houses[1]=h_x[j].getIndex();
                    }
                    else if(dist!=d_min[0]){
                        d_min[1]=dist;
                        houses[2]=h_x[i].getIndex();
                        houses[3]=h_x[j].getIndex();
                    }
                }
            }
        }
        return d_min;
    }

    private double[] strip_second(house[] strips, int j, double[] d_min) {

        for(int i=0;i<j;i++){
            for (int k=i+1;k<j && (strips[k].getY()-strips[i].getY())<d_min[1]; k++){
                double dist=distance(strips[i],strips[k]);
                if ( dist< d_min[1]){
                    if (dist<d_min[0]){
                    d_min[1]=d_min[0];
                    d_min[0]=distance(strips[i],strips[k]);
                        houses[2]=houses[0];
                        houses[3]=houses[1];
                        houses[0]=strips[i].getIndex();
                        houses[1]=strips[k].getIndex();
                    }
                    else if (dist!=d_min[0]) {
                        d_min[1]=dist;
                        houses[2]=strips[i].getIndex();
                        houses[3]=strips[k].getIndex();
                    }
            }
        }
    }
        return d_min;
    }

    private double[] min(double[] d_l, double[] d_r) {

       double  min[]= d_l;
        if(min[0]>d_r[0]){
            min[1]=min[0];
            min[0]=d_r[0];
            if(min[1]>d_r[1])
                min[1]=d_r[1];
        }
        else {
            if(min[1]>d_r[0]){
                min[1]=d_r[0];
            }
        }
        return min;
    }

    public void sec_closestHouse(house[] h, int n){

        house[] h_x= new house[n];
        house[] h_y=new  house[n];
        for (int i = 0; i < n; i++)
        {
            h_x[i] = h[i];
            h_y[i] = h[i];
        }
        Arrays.sort(h_x,new SortbyX());
        Arrays.sort(h_y, new SortbyY());

        for (int i=0;i<n;i++){
            h_x[i].setX_index(i);
        }

         double[] house_dist=strip(h_x,h_y,n,0);
        DecimalFormat df = new DecimalFormat("#.0000");
        df.setRoundingMode(RoundingMode.CEILING);
        if(houses[2]<houses[3])
        System.out.println(houses[2] +"  "+houses[3]);

        else System.out.println(houses[3] +"  "+houses[2]);
        System.out.println(df.format(house_dist[1]));
    }


}
class SortbyX implements Comparator<house> {
    public int compare(house h1, house h2)
    {
        return (int) (h1.getX() - h2.getX());
    }}

    class SortbyY implements Comparator<house> {
        public int compare(house h1, house h2)
        {
            return (int) (h1.getY() - h2.getY());
        }
}

class house{
     private int index;
    private double x;
    private double y;
    private int x_index;

    public  house(){
        index=0;
        x=0;
        y=0;
        x_index=0;

    }

    public house(int index, double x, double y) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.x_index=0;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public int getX_index() {
        return x_index;
    }

    public void setX_index(int x_index) {
        this.x_index = x_index;
    }
}
