#include<iostream>
using namespace std;

class Heap{
    int Max_size;
    int *numbers;
    int index;
private:
    void swaps(int a, int b){
    int t=numbers[a];
    numbers[a]=numbers[b];
    numbers[b]=t;

    }
public:
    Heap(int Max_size){
        this->numbers= new int[Max_size];
        this->Max_size=Max_size;
        index=0;
    }
    void insert(int number){
        if(index==0){
            numbers[index]=number;
        }
        else{
            int i =index;
            numbers[i]=number;
            while(i!=0){
                int n=(i-1)/2;
                if(numbers[n]< numbers[i]){
                    swaps(n,i);
                    i=n;
                }
                else{
                    break;
                }
            }
        }
        index++;
    }
    void deleteKey(){
        numbers[0]=numbers[--index];
        int i=0;
        while(i<index/2){
            if(numbers[2*i+1]>numbers[2*i+2]&& numbers[i]<numbers[2*i+1]){
                swaps(2*i+1,i);
                i=2*i+1;
            }
            else if(numbers[2*i+2]>numbers[2*i+1]&& numbers[i]<numbers[2*i+2]){
                swaps(2*i+2,i);
                i=2*i+2;
            }
            else if(numbers[i]<numbers[2*i+1]){
                swaps(2*i+1,i);
                i=2*i+1;
            }
            else
                break;
        }
    }
    int getMax(){
        if(index==0)
            return-1;
        return numbers[0];
    }
    int size(){
        return index;
    }
    ~Heap(){
        delete[] numbers;
    }
};
void heapsort(vector<int>&v){
    int n=v.size();
    Heap h(n);
    for(int i=0;i<n;i++){
        h.insert(v[i]);
    }
      for(int i=0;i<n;i++){
        v[i]=h.getMax();
        h.deleteKey();
    }
}
