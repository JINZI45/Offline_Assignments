import numpy as np
def GaussianElimination(A,B,d):
    i=0
    N=A.shape[0]
    arr=np.zeros([N,1],float)
    if(np.linalg.det(A)):

        # elimination
        while (i < N):

            for j in range(i+1, N):
                B[j] = (A[j][i] / A[i][i]) * B[i] - B[j]
                A[j] = (A[j][i] / A[i][i]) * A[i] - A[j]
                j = j + 1
                if (d):
                    print(np.around(A,4))
                    print()
                    print(np.around(B,4))
                    print()
            i = i + 1
        # back
        i = N - 1
        arr[i][0] = B[i][0] / A[i][i]

        while (i - 1 >= 0):
            j = i - 1
            arr[j][0] = B[j][0]
            k = 0
            while (N - k - 1 > j):
                arr[j][0] = (arr[j][0] - A[j][N - 1 - k] * arr[N - 1 - k][0])
                k = k + 1
            arr[j][0] = arr[j][0] / A[j][j]
            i = i - 1
        return arr
    else:
        print("Cannot be solved")


if __name__ == '__main__':
    N=int(input("enter the number of variables:"))
    co_eff=[]
    print("enter co_efficients:")
    try:
        for i in range(N):
            co_eff.append(list(map(float, input().split())))
        co_eff_arr = np.array(co_eff, dtype=np.float64)
        # constant
        const = []
        print("enter constants:")
        for i in range(N):
            element = [input()]
            const.append(element)

        const_arr = np.array(const, dtype=np.float64)
        print(np.around(GaussianElimination(co_eff_arr, const_arr, True),4))

    except:
        print("invalid input")