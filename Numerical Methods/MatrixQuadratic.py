import math
import numpy as np

numx = [1.1,2.7,3.3,4.5,5.9]
numy = [2.3,3.6,10.5,23,37.4]

n = len(numx)
sumx = 0
sumx2 = 0
sumx3 = 0
sumx4 = 0
sumy = 0
sumxy = 0
sumx2y = 0

for i in range (len(numx)):
    sumx += numx[i]
    sumx2 += numx[i]**2
    sumx3 += numx[i]**3
    sumx4 += numx[i]**4
    sumy += numy[i]
    sumxy += numx[i]*numy[i]
    sumx2y += (numx[i]**2)*numy[i]

print("n :",n)
print("sumx : ",sumx)
print("sumx2 : ",sumx2)
print("-----------")
print("sumx : ",sumx)
print("sumx2 : ",sumx2)
print("sumx3 : ",sumx3)
print("-----------")
print("sumx2 : ",sumx2)
print("sumx3 : ",sumx3)
print("sumx4 : ",sumx4)
print("-----------")
print("sumy : ",sumy)
print("sumxy : ",sumxy)
print("sumx2y : ",sumx2y)

A = [[n,sumx,sumx2],[sumx,sumx2,sumx3],[sumx2,sumx3,sumx4]]
B = [[sumy],[sumxy],[sumx2y]]

print("A")
print(np.reshape(A,(-1,len(A[0]))))
print("B")
print(np.reshape(B,(-1,len(B[0]))))