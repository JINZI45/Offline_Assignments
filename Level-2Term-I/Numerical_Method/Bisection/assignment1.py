import matplotlib.pyplot as plt
import numpy as num
def f(x):
    return x ** 3 - 2400 * x ** 2-3 * x+2
def bisection(a,b,approx_error, max_iteration):
    print(" upperlimit", b, "\n", "lower limit", a)
    if(f(a)*f(b)<0):
        midpoint= (a+b)/2
        error=100
        count=0;
        while(approx_error<error and count<max_iteration):
            if(midpoint==0):
                return midpoint
            elif(f(midpoint)*f(b)<0):
                old_midpoint=midpoint
                a=midpoint
                midpoint=(a+b)/2
            elif (f(midpoint) * f(a) < 0):
                old_midpoint = midpoint
                b=midpoint
                midpoint=(a+b)/2
            count=count+1
            error=(abs((midpoint-old_midpoint)/midpoint))*100
        return midpoint
    else:
        print("no valid root")


def bisection_iteration(a,b,max_iteration):
    print(" upperlimit", b, "\n", "lower limit", a)
    print("iteration:", "      absolute relative approx. error:")
    if(f(a)*f(b)<0):
        midpoint= (a+b)/2
        error=100
        count=0
        while(count< max_iteration):
            if(midpoint==0):
                return midpoint
            elif(f(midpoint)*f(b)<0):
                old_midpoint=midpoint
                a=midpoint
                midpoint=(a+b)/2
            elif (f(midpoint) * f(a) < 0):
                old_midpoint = midpoint
                b=midpoint
                midpoint=(a+b)/2
            count=count+1
            error=(abs((midpoint-old_midpoint)/midpoint))*100
            print( "  ",count,"                       ", error)
        return midpoint
    else:
        print("no valid root")

def graph():
    x=num.linspace(0,1,10000)
    y= f(x)
    plt.plot(x,y)
    plt.grid()
    plt.show()

graph()
print("root:", bisection(0,1,.5,12))
print("root:", bisection_iteration(0, 1, 20))


