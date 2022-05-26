#Compute natural log (Taylor Series (0 < x <= 2a))

import numpy as np

x = float(input('input x of ln(x), x needs to be greater than zero: '))
sf = int(input('SigFig: '))

def factorial(x):
    if(x == 0): return 1
    a=x
    for i in range(x-1):
        a=a*(x-1)
        x-=1
    return a

e_power_x = 0
for i in range(100):
    e_power_x += (1**i)/factorial(i)

count = 0
for i in range(1000):
    t = x/(e_power_x**i)
    if(t < 2): break
    count+=1

t-=1
res = 0 # compute natural log
Es = 0.5 * (10**(2-sf))
i = 1
temp = 0
while(1):
    res+=((-1)**(i+1))*((t**i)/i)
    i+=1
    if(abs((res-temp)/res)*100) < Es: break
    temp = res
print('result is: '+str(res+count))