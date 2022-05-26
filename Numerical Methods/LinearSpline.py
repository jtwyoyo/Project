import math

numx = [2,8,14]
numy = [2.5,6.3,2.1]

x = 4.9

print(f"fx1 : {numy[0]} + {(numy[1]-numy[0])/(numx[1]-numx[0])}*(x-{numx[0]})")
print(f"fx2 : {numy[1]} + {(numy[2]-numy[1])/(numx[2]-numx[1])}*(x-{numx[1]})")
if x >= numx[0] and x <= numx[1] :
    print("fx =", numy[0] + (numy[1]-numy[0])/(numx[1]-numx[0])*(x-numx[0]))
if x >= numx[1] and x <= numx[2] :
    print("fx =", numy[1] + (numy[2]-numy[1])/(numx[2]-numx[1])*(x-numx[1]))