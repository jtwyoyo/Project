def xor(x, y):
    res = []
    for i in range(1, len(y)):
        #xor logic, same = 0, difference = 1
        if x[i] == y[i]:
            res.append('0')
        else:
            res.append('1')
    return ''.join(res)

#modulo-2 division
def mod2div(dividend, divisor):
    j = len(divisor)
    k = dividend[0 : j] 
    while j < len(dividend): 
        if k[0] == '1':
            k = xor(divisor, k) + dividend[j]
        else:
            #if the left bit is "0", use "0s" divisor
            k = xor('0'*j, k) + dividend[j]
        j += 1
    #Fix Index out of bound error
    if k[0] == '1':
        k = xor(divisor, k)
    else:
        k = xor('0'*j, k) 
    return k

def CRC_gen(dataword, word_size, CRC_type): #Encoder
    if(word_size != len(dataword) & word_size < 5): return "Please Re-Enter"
    if(CRC_type == "CRC-32"): binary = "100000100110000010001110110110111"
    elif(CRC_type == "CRC-24"): binary = "1100000000101000100000001"
    elif(CRC_type == "CRC-16"): binary = "11000000000000101"
    elif(CRC_type == "Reversed CRC-16"): binary = "10100000000000011"
    elif(CRC_type == "CRC-8"): binary = "111010101"
    elif(CRC_type == "CRC-4"): binary = "11111"
    key = len(binary)
    appended_dataword = dataword + '0'*(key-1)
    remain = mod2div(appended_dataword, binary)
    codeword = dataword + remain
    return codeword

def CRC_check(dataword, CRC_type): #Decoder
    if(CRC_type == "CRC-32"): binary = "100000100110000010001110110110111"
    elif(CRC_type == "CRC-24"): binary = "1100000000101000100000001"
    elif(CRC_type == "CRC-16"): binary = "11000000000000101"
    elif(CRC_type == "Reversed CRC-16"): binary = "10100000000000011"
    elif(CRC_type == "CRC-8"): binary = "111010101"
    elif(CRC_type == "CRC-4"): binary = "11111"
    key = len(binary)
    appended_dataword = dataword + '0'*(key-1)
    remain = mod2div(appended_dataword, binary)
    remain = int(remain)
    if(remain == 0): return 1 
    else: return 0

test1 = CRC_gen("101011", 6, "CRC-8")
test2 = CRC_gen("1010", 4, "CRC-4")
test3 = CRC_gen("1100101", 7, "CRC-8")
test4 = CRC_gen("1011010", 7, "CRC-16")
test5 = CRC_gen("101001", 6, "Reversed CRC-16")
test6 = CRC_gen("100110010", 9, "CRC-24")
test7 = CRC_gen("11100101", 8, "CRC-16")
test8 = CRC_gen("1010010010", 10, "CRC-16")
test9 = CRC_gen("1010", 4, "CRC-4")
test10 = CRC_gen("1010010010100010", 16, "CRC-32")
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
print("check 1: ", CRC_check(test1, "CRC-8"))
print("check 2: ", CRC_check(test2, "CRC-4"))
print("check 3: ", CRC_check(test3, "CRC-8"))
print("check 4: ", CRC_check(test4, "CRC-16"))
print("check 5: ", CRC_check(test5, "Reversed CRC-16"))
print("check 6: ", CRC_check(test6, "CRC-24"))
print("check 7: ", CRC_check(test7, "CRC-16"))
print("check 8: ", CRC_check(test8, "CRC-16"))
print("check 9: ", CRC_check(test9, "CRC-4"))
print("check 10: ", CRC_check(test10, "CRC-32"))






