def romberg(y):
    return (2.2)+(1.5*y)+(1.8*(y**2))

b = 9.9
a = 4.7

n = 2

result = (((-(b-a)/n)**2)/12) * (romberg(b)-romberg(a))

print(result)