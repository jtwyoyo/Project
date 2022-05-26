import math
import numpy as np

# saturation growth rate model
numx = [2.2,3.8,6.1,8]
numy = [4.85,5.99,11.04,18.85]

n = len(numx)

sumx = 0
sumy = 0
sum1x = 0
sum1x2 = 0
sum1y = 0
sum1xy = 0

for i in range (len(numx)) :
    #print(numx[i],numy[i],1/numx[i],1/numy[i],1/(numx[i]numy[i]))
    sumx += numx[i]
    sum1x += 1/numx[i]
    sum1x2 += 1/(numx[i]**2)
    sum1y += 1/numy[i]
    sum1xy += 1/(numx[i]*numy[i])

print("sumx =" ,sumx)
print("sum1x =" ,sum1x)
print("sum1x2 =" ,sum1x2)
print("sum1y =" ,sum1y)
print("sum1xy =" ,sum1xy)
print("====================")

A = np.array([[sum1x2,sum1x],[sum1x,n]])
b = np.array([[sum1xy],[sum1y]])
A_inv = np.linalg.inv(A)
x = np.dot(A_inv,b)
print(x)
print("====================")

ansa = 1/x[1]
ansb = x[0] * ansa
print("a = ",ansa)
print("b = ",ansb)
print("====================")
print(f"equation : y = ({ansa} * X) /({ansb} + X)  ")