public class Sort {

    private static int[] array;
    private int lower_bound;
    private int upper_bound;
    /*private int[] temp;*/


    public Sort(int[] array) {
        this.array = array;
        this.lower_bound = 0;
        this.upper_bound = array.length-1;
    }
    private int temp[]=new int[1000000];
    public int getLower_bound() {
        return lower_bound;
    }

    public int getUpper_bound() {
        return upper_bound;
    }
    private void swap(int a, int b){
        int temp= array[a];
        array[a]= array[b];
        array[b]=temp;
    }
    private int sub_arr(int lower, int upper) {

        int pivot= array[lower];
        int start= lower;
        int end=upper;
        while (start<end ){
            while (array[start]<=pivot && start<upper)
            { start++;}
            while (array[end]> pivot)
            {end--;}
            if(start<end)
            swap(start,end);
        }
        swap(end,lower);
        return end;
    }
    public void quicksort(int low, int up){
        if(low<up){
            int location= sub_arr(low,up);

            quicksort(low, location-1);
            quicksort(location+1, up);
        }
    }
    private void merge(int low, int up, int mid){
        int left=low;
        int right= mid+1;
        int n=low;
        while (left<=mid &&right<=up ){
            if(array[left]<array[right]){
                temp[n]=array[left];
                left++;
            }
            else {
                temp[n]=array[right];
                right++;
            }
            n++;
        }
        if(left>mid){
            while (right<=up){
                temp[n]=array[right];
                n++;
                right++;
            }
        }
        else {
            while (left<=mid){
                temp[n]=array[left];
                n++;
                left++;
            }
        }
        for (int i=low;i<=up;i++){
            array[i]=temp[i];
        }

    }
    public void mergesort(int lower, int upper){
        if (lower<upper) {
            int mid = (lower + upper) / 2;
            mergesort(lower,mid);
            mergesort(mid+1, upper);
            merge(lower,upper,mid);
        }
    }
    public void printArr(){
        for (int i=0;i<=upper_bound;i++){
            System.out.println(array[i]);
        }
    }
}
