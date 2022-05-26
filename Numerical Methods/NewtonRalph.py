import math
import numpy as np

def f(x):
    return 1+x+(np.e**x)
#10/((x3)-2)
def g(x):
    #return 10/((x*3)-2)
    return -1-(np.e**x)
def fix_point(g, x0):
    xr_prev = x0
    ea, es = 100, 0.005
    count = 1
    while (ea > 10):
        print(count)
        count+=1
        xr = g(xr_prev)
        ea = abs(100*((xr - xr_prev) / xr))
        #print(ea,"|", xr,"|", xr_prev)
        xr_prev = xr
    return xr

print(fix_point(g, 1.5))