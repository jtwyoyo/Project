from decimal import Decimal

def f(x):
    return (x**4)-(2*x)-10

def g(x):
    return ((x**4) - 10)/2

def fixed_point(x0):
    xr_prev = x0
    epa = 100
    eps = 0.005
    while epa > eps:
        xr = g(xr_prev)
        epa = abs(100*((xr-xr_prev)/xr))
        print('xr = '+str(xr)+' epa = '+str(epa)+'')
        xr_prev = xr
    print('final xr = ',xr)
    return xr

print(fixed_point(1))
