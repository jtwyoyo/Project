# Convert decimal to IEEE-754

import math

n = float(input("Input: "))
dec,val = math.modf(n)
val = abs(val)
dec = abs(dec)

#Division Method
def conv_integer(val):
    res = ''
    while(val!=0):
        if(val%2 == 0):
            val//=2 
            res = '0'+res
        else:
            val=(val/2)-0.5
            res = '1'+res
    return res

#Floating Point Decimal to Binary
def conv_fractions(dec):
    res = ''
    while dec != 1:
        dec = dec * 2
        if len(res) == 23: break
        if(dec > 1): 
            dec-=1
            res+='1'
        elif(dec == 1): res+='1'
        else: res+='0'
    return res

#Show binary form of the given decimal
if n > 0: bin = float(conv_integer(val) + "." + conv_fractions(dec))
if n < 0: bin = float("-" + conv_integer(val) + "." + conv_fractions(dec))
print("Binary Form: "+str(bin))

#Calculate Sign (1 bit)
sign = '0'
if(n > 0): sign = '0'
else: sign = '1' 
print("Sign: "+sign)

#Calculate Exponent (8 bits)
exp = str(conv_integer((len(conv_integer(val))-1)+127))
while len(exp) != 8:
    exp = '0' + exp
print("Exponential bits: "+exp)

#Calculate Mantissa (23 bits)
man = (conv_integer(val) + conv_fractions(dec))[1:]
x = 23-len(man)
for i in range(x):
     man+='0'
print("Mantissa: "+man)

#Show the final result
print('Final Value: ' + sign + " " + exp + " " + man)