import numpy as np
def f(t):
    return 2000*np.log(140000/(140000-2100*t))-9.8*t

def integration(n,a,b):

    h=(b-a)/n
    sum=0
    for i in range(1,n):
        sum= sum+ f(a+i*h)
        i=i+1

    result= (h/2)*(f(a)+f(b)+2*sum)
    return result

def error(x,y):
    e=abs((x-y)/x)*100
    return e

if __name__ == '__main__':

    N=int(input("Enter the number of interval:"))
    t1=8
    t2=30
    value_old=0
    print("the result is:", integration(N, t1, t2))
    print("Calculated values","\t\t\t\t\t","Absolute approximate relative errors")
    print("===============================================================================================")
    for j in range(1,6):
        if(j==1):
            value_old=integration(j,t1,t2)
            print(value_old, "\t\t\t\t\t","---------")
            j+=1

        else:
            value_new= integration(j,t1,t2)
            print(value_new,"\t\t\t\t\t", error(value_new,value_old))
            value_old=value_new
            j += 1

