import numpy as np
def f(t):
    return 2000*np.log(140000/(140000-2100*t))-9.8*t

def integration(n,a,b):
    result=0
    if(n%2==0):

        h=(b-a)/n
        A=a
        for i in range(0,int(n/2)):

            B= A+2*h
            h_each=(B-A)/2
            result+=(h_each/3)*(f(A)+4*f((A+B)/2)+f(B))
            A=B
            i=i+1

    return result

def error(x,y):
    e=abs((x-y)/x)*100
    return e

if __name__ == '__main__':

    N=int(input("Enter the number of interval:"))
    t1=8
    t2=30
    print("the result is:", integration(2*N,t1,t2))
    value_old=0
    print("Calculated values","\t\t\t\t\t","Absolute approximate relative errors")
    print("===============================================================================================")
    for j in range(1,6):
        if(j==1):
            value_old=integration(2*j,t1,t2)
            print(value_old, "\t\t\t\t\t","---------")
            j+=1

        else:
            value_new= integration(2*j,t1,t2)
            print(value_new,"\t\t\t\t\t", error(value_new,value_old))
            value_old=value_new
            j += 1