def Hamming_gen(dataword):
    #Find Number of Redundancy Bit
    length = len(dataword)
    for i in range(length):
        if(2**i >= length + i + 1):
            r = i
            break
    #Place Redundancy Bit
    j = 0
    k = 1
    res = ''
    for i in range(1, length + r+1):
        if(i == 2**j):
            res = res + '0'
            j += 1
        else:
            res = res + dataword[-1 * k]
            k += 1
    #Reversing
    output = res[::-1]
    #Finding Parity bit
    n = len(output)
    for i in range(r):
        x = 0
        for j in range(1, n + 1):
            if(j & (2**i) == (2**i)):
                x = x ^ int(output[-1 * j])
        output = output[:n-(2**i)] + str(x) + output[n-(2**i)+1:]
    return output

def Hamming_check(codeword):
    m = len(codeword)
    #Calculate Parity bit
    for i in range(m):
        if(2**i >= m + i + 1):
            nr = i
            break
    n = len(codeword)
    res = 0
    for i in range(nr):
        val = 0
        for j in range(1, n + 1):
            if(j & (2**i) == (2**i)):
                val = val ^ int(codeword[-1 * j])
        #Append Parity bit
        res = res + val*(10**i)
    if(int(str(res), 2) == 0): return -1
    else: return int(str(res), 2)

test1 = Hamming_gen("101011")
test2 = Hamming_gen("1010")
test3 = Hamming_gen("1100101")
test4 = Hamming_gen("1011010")
test5 = Hamming_gen("101001")
test6 = Hamming_gen("100110010")
test7 = Hamming_gen("11100101")
test8 = Hamming_gen("1010010010")
test9 = Hamming_gen("1010")
test10 = Hamming_gen("1010010010100010")
print("codeword 1: ", test1)
print("codeword 2: ", test2)
print("codeword 3: ", test3)
print("codeword 4: ", test4)
print("codeword 5: ", test5)
print("codeword 6: ", test6)
print("codeword 7: ", test7)
print("codeword 8: ", test8)
print("codeword 9: ", test9)
print("codeword 10: ", test10)
print("check 1: ", Hamming_check(test1))
print("check 2: ", Hamming_check(test2))
print("check 3: ", Hamming_check(test3))
print("check 4: ", Hamming_check(test4))
print("check 5: ", Hamming_check(test5))
print("check 6: ", Hamming_check(test6))
print("check 7: ", Hamming_check(test7))
print("check 8: ", Hamming_check(test8))
print("check 9: ", Hamming_check(test9))
print("check 10: ", Hamming_check(test10))

