#Compute T_n(x) of sin(x) such that n = 2, 4, 6, 8, 10

import matplotlib.pyplot as plt
import numpy as np

x = np.arange(-8, 8, 0.01)

def factorial(x):
    if(x == 0): return 1
    a=x
    for i in range(x-1):
        a=a*(x-1)
        x-=1
    return a

y = 0; ind = 1; i = 1
for a in range(2, 11, 2):
    if a == 2 or a == 6 or a == 10: y+=(x**ind)/factorial(i)
    elif a == 4 or a == 8: y+=(-1)*(x**ind)/factorial(i)
    ind+=2; i+=2
    plt.plot(x,y,label="T_"+str(a)+"(x)")

plt.plot(x, np.sin(x), label="original")
plt.legend(); plt.ylim(-3, 3); plt.grid()
plt.show()