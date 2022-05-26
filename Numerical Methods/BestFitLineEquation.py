import math

numx = [2.2,3.8,6.4,8]
numy = [4.85,5.99,11.04,18.85]

n = len(numx)

sumx = 0
sumy = 0
sumx2 = 0
sumy2 = 0
sumxy = 0

for i in range (len(numx)) :
    sumx += numx[i]
    sumy += numy[i]
    sumx2 += numx[i]**2
    sumy2 += numy[i]**2
    sumxy += numx[i] * numy[i]
    
print("sum x :",sumx)
print("sum y :",sumy)
print("sum xy :",sumxy)
print("sum x**2 :",sumx2)

a1 = ((n*sumxy)-(sumx*sumy))/((n*sumx2)-(sumx**2))
print("a 1 :",a1)

xmean = sumx/n
ymean = sumy/n
a0 = ymean - xmean*a1
print("a 0 :",a0)

print("==========================")
print(xmean,ymean)
print("equation : ",a0,"+",a1,"x")
print("==========================")

sr = 0.00
st = 0
for i in range (len(numx)) :
    sr += (numy[i] - a0 - a1*numx[i])**2
    st += (numy[i]-ymean)**2
stderror = math.sqrt(sr/(n-2))
print("stderror : ",stderror)
print("sr :",sr)
print("st :",st)
r = (st - sr)/st
r0 = math.sqrt(r)
print("==========================")
print("r**2 :",r)
print("r : ",r0)
print("==========================")