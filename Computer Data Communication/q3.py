# coding: utf-8

# In[1]:


# This function created for inverse the dataword 
def bi_inverse(dataword):
    result = ''
    for i in dataword:
        if i == '1':
            result = result + '0'
        else:
            result = result + '1'
    return result


# In[2]:


def Checksum_gen(dataword, word_size, num_blocks):
    
    dataw = [] 
    w = list(dataword)
    
    #Split dataword into [...,...,...] following the numblock
    
    for i in range(num_blocks): # i * word_size = start assume that word_size = 5 > 0:5, 5:10 
        dataw.append(''.join(w[i * word_size: i * word_size + word_size]))
    print("Dataword:",dataword, "\n", dataw)
    
    #for summation
    
    sum = '0'
    
    for i in dataw: #['11100' (0), '01010'(i), '10001'(i)]
        sum =(int(sum, 2) + int(i, 2))
        sum = bin(sum)[2:]
    #print("Summation: ", sum)
    
    # In case the lenght of summation longer than word_size 
    while len(sum) > word_size:
        sum = (int(sum[len(sum) - word_size:],2) + int(sum[0: len(sum) - word_size], 2))
        sum = bin(sum)[2:]
 
    # In case the length of summation less than word_size, add "0" in front of the result 
    while len(sum) < word_size:
        sum = '0' + sum 
        
    dataw.append(bi_inverse(sum))
    
    print("Sum: ",sum, "\n" "Checksum: ",(bi_inverse(sum)), "\nThe codeword is "+ " ".join(dataw))
    


# In[3]:


print('-------------1---------------------')
cgs_1 = Checksum_gen('101010010011100100011101', 8, 3)

print('-------------2---------------------')
cgs_2 = Checksum_gen('1011001101011010', 4, 4)

print('-------------3---------------------')
cgs_3 = Checksum_gen('110110010100', 4, 3)

print('-------------4---------------------')
cgs_4 = Checksum_gen('11001001010010100110', 4, 5)

print('-------------5---------------------')
cgs_5 = Checksum_gen('010110001101', 4, 3)

print('-------------6---------------------')
cgs_6 = Checksum_gen('1011011010101010', 4, 4)

print('-------------7---------------------')
cgs_7 = Checksum_gen('010010101010010111101011', 4, 5)

print('-------------8---------------------')
cgs_8 = Checksum_gen('101001111111', 4, 3)

print('-------------9---------------------')
cgs_9 = Checksum_gen('0110110101010010', 4, 4)

print('-------------10---------------------')
cgs_10 = Checksum_gen('11101111111010110111', 5, 3)

print('-------------11---------------------')
cgs_11 = Checksum_gen('1010100100111001', 8, 2)


# In[4]:


def Checksum_check(codeword, word_size, num_blocks):
    
    d = list(codeword)
    dataw = []
    
    for i in range(num_blocks+1):
    #    print(i)
        dataw.append("".join(d[i * word_size: i * word_size + word_size]))
    print(dataw)
    
    sum = '0'
    
    for i in dataw: #['11100' (0), '01010'(i), '10001'(i)]
        sum =(int(sum, 2) + int(i, 2))
        sum = bin(sum)[2:]
    #print("Summation: ", sum)
    
    # In case the lenght of summation longer than word_size 
    while len(sum) > word_size:
        sum = (int(sum[len(sum) - word_size:],2) + int(sum[0: len(sum) - word_size], 2))
        sum = bin(sum)[2:]
 
    # In case the length of summation less than word_size, add "0" in front of the result 
    while len(sum) < word_size:
        sum = '0' + sum 
      
    # For check validation
    check = ''
    
    for i in range(word_size):
        check += '0'
        
    print("Codeword: "+" ".join(dataw))
    
    if bi_inverse(sum) == check:
        print("Validity of the array of codewords: PASS")
    else:
        print("Validity of the array of codewords: FAIL")
  
        


# In[5]:


print('-------------1---------------------')
case1 = Checksum_check('11100010101000100111', 5, 3)
print('-------------2---------------------')
case2 = Checksum_check('111110111101111000000011011010', 5, 3)
print('-------------3---------------------')
case3 = Checksum_check('1010101101001111', 5, 2)
print('-------------4---------------------')
case4 = Checksum_check('1110111101010101001000111', 5, 3)
print('-------------5---------------------')
case5 = Checksum_check('1110111101010101', 4, 3)
print('-------------6---------------------')
case6 = Checksum_check('101101010011', 3, 3)
print('-------------7---------------------')
case7 = Checksum_check('11101111111010101100', 5, 3)
print('-------------8-------------------')
case8 = Checksum_check('1010011111111101', 4, 3)
print('-------------9-------------------')
case9 = Checksum_check('101110111000', 3, 3)
print('-------------10-------------------')
case10 = Checksum_check('101010010011100100011101', 8, 2)
print('-------------11-------------------')
case11 = Checksum_check('10110011010110100001', 4, 4)


# In[ ]:




