def f(x):
    return 
def falseposition( xl, xu):
    ea, xrpre, count = 1, 0, 0
    while ea > 0.005:
        xr = xu - (f(xu)*((xu-xl)/(f(xu)-f(xl))))
        if(f(xl) * f(xr) < 0):
            xu = xr
        else:
            xl = xr
        ea = abs((xr - xrpre)/ xr)*100
        xrpre = xr
        count += 1
    #print(count)
    return xr