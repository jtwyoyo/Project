import math
import numpy as np

numx = [1.9,3.7,5.5]
numy = [19.7,29.5,32.9]

y = 21.4

x1 = ((y-numy[1])*(y-numy[2]))/((numy[0]-numy[1])*(numy[0]-numy[2])) *numx[0]
x2 = ((y-numy[0])*(y-numy[2]))/((numy[1]-numy[0])*(numy[1]-numy[2])) *numx[1]
x3 = ((y-numy[0])*(y-numy[1]))/((numy[2]-numy[0])*(numy[2]-numy[1])) *numx[2]
x = x1 + x2 + x3
print(x)