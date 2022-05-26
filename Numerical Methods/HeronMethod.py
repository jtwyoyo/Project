#Calculate square root value via Heron's Method

n = int(input("Input: "))
SigFig = int(input("Significant Figures: "))
def heron(n,sf):
    i = 1
    a = int(input("Starting Value: "))
    b = 0 #Previous calculated value
    Es = 0.5 * (10**(2-sf))
    while (abs((a-b))/a)*100 > Es:
        b = a
        a = (a+(n/a))/2
        print("Step",i,":",a)
        i+=1
    return a
print("Final Result: " , heron(n,SigFig))