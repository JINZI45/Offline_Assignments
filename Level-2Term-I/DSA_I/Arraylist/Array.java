public class Array {
    private int length;
    private String[] arr;

    public Array() {
        length=0;
        arr= new String[length];
        arr= null;
    }

    public Array(int length) {
        if(length<0)
            System.out.println("invalid length");
        else{
        this.length = length;
        arr= new String[length];
        arr= null;}
    }

    public Array(String[] array) {
        if(array==null)
            System.out.println("invalid");
else{
        length= array.length;
        arr= new String[length];
        this.arr=array;}

    }


    public String[] getArray() {
        return arr;
    }
    public String getAnElement(int i)
    {if(i<0)
        System.out.println("invalid input");
    else {
       return (arr[i]);}
    return null;
    }
    public void add(String s)
    {
        if(s== null)
            System.out.println("invalid input");
        else{
        int j= arr.length +1;
        String[] new_arr= new String[j];
        for (int i=0; i<j-1;i++){
            new_arr[i]= arr[i];
        }
        new_arr[j-1]=s;
        this.arr=new_arr;}
    }
    public void add(int i, String s){
        if(i<0 || s==null)
            System.out.println("invalid input");
        else{
        int j= arr.length +1;
        String[] new_arr= new String[j];
        for (int k=0; k<i;k++){
            new_arr[k]= arr[k];
        }
        new_arr[i]=s;
        for (int k=i+1; k<j;k++){
            new_arr[k]= arr[k-1];
        }

        this.arr=new_arr;}

    }
    public void remove(String s)
    {if(s==null)
        System.out.println("invalid input");
    else{
        int count=0;
        for (int i=0; i<arr.length;i++){
            if(arr[i].equalsIgnoreCase(s))
            {
               count++;
            }
        }
        int j= arr.length -count;
        String[] new_arr= new String[j];
        int k=0;
        for (int i=0; i<arr.length;i++,k++){
            if(!arr[i].equalsIgnoreCase(s)){
                new_arr[k]= arr[i];
            }
            else {
                k--;
            }
        }
        this.arr= new_arr;}
    }
    public int[] findIndex(String s){
        if (s== null)
            System.out.println("invalid input");
        else {
        int[] count=new int[arr.length];
        int k=0;
        for (int i=0; i<arr.length;i++){
            if(arr[i].equalsIgnoreCase(s))
            {
                count[k]=i;
                k++;
            }
        }
        int[] count1= new int[k];
        for (int i=0;i<k;i++){
            count1[i]=count[i];
        }
        return count1;}
        return null;
    }
    public String[] subArray(int start, int end){
        if(start<0 || (end-start)<0)
            System.out.println("invalid input");
        else {
        String[] subarr= new String[end-start+1];
        for (int i=start, k=0; i<= end;i++,k++){
            subarr[k]= arr[i];
        }
        return subarr;}
        return null;
    }
    public void merge(String A1[], String A2[]){
        if (A1==null || A2==null)
            System.out.println("invalid input");
        else {
        int j= A1.length+ A2.length;
        String[] new_arr= new  String[j];
        int count =0;
        if(A1.length< A2.length){
        for(int i=0,l=0,k=0;i< A1.length;){
            if(A1[i].compareTo(A2[l])<0){
                new_arr[k]= A1[i];
                i++; k++;
            }
            else{
                new_arr[k]=A2[l];
                l++; k++;

            }
            count++;}
        for(int i=A2.length-j+count,l=0;i< A2.length; i++){
            new_arr[count+l]= A2[i];
            l++;
        }}

        else{
            for(int i=0,l=0,k=0;i< A2.length;){
                if(A2[i].compareTo(A1[l])<0){
                    new_arr[k]= A2[i];
                    i++; k++;
                }
                else{
                    new_arr[k]=A1[l];
                    l++; k++;
                }
                count++;
            }
            for(int i=A1.length-j+count,l=0;i< A1.length; i++){
                new_arr[count+l]= A1[i];
                l++;
            }
        }
        this.arr=new_arr;}
    }

    public int length(){
        return arr.length;
    }
    public boolean isEmpty(){
        if(arr == null)
            return true;
      return false;
    }
}
