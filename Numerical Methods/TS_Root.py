#Taylor Series Expansion for Square and Cube roots.

choice = int(input('Select Program: Square root[1], Cube root[2]: '))
x = float(input('Check: '))
sf = int(input('SigFig: '))

def factorial(x):
    if(x == 0): return 1
    a=x
    for i in range(x-1):
        a=a*(x-1)
        x-=1
    return a

a = x+1
prev = 0
frac = 1
if(choice==1): ind = 1/2
elif(choice==2): ind = 1/3
i = 0
res = a**ind
Es = 0.5 * (10**(2-sf)) #Stopping Criterion
while (abs((res-prev))/res)*100 > Es:
    prev = res
    i+=1
    frac*=ind
    ind-=1
    res+=((frac*(a**ind))/factorial(i))*(x-a)**i
print(res)