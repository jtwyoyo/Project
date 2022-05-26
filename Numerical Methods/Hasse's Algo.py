x = float(input("enter a number: "))
count = 1
while x != 1:
    if x % 2 == 1: 
        x = 3*x + 1
        print("iteration "+str(count)+": "+str(x))
    else: 
        x = x/2
        print("iteration "+str(count)+": "+str(x))
    count = count+1 