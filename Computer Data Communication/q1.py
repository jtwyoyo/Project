# coding: utf-8

# # Parity bit:

# In[34]:


import numpy as np


# In[35]:


# set default that 1 is one-dimensional-even, 2 is one-dimensional-odd, 3 is two-dimensional-even, 4 is two-dimensional-odd
TYPE_OF_PARITY = ['one-dimensional-even', 'one-dimensional-odd',
                  'two-dimensional-even', 'two-dimensional-odd']


# In[36]:


def Check_Sum_Even(input: np.ndarray) -> bool:
 
 # Input: an array of bit
 # Caculate the sum of bits given and consider whether it is EVEN number or not.
 # Output: Boolean whether it is EVEN or not (TRUE = EVEN / FALSE = ODD)
    
  count = 0
  for bin in input:
      count = count + int(bin)
  return bool(count % 2 == 0) # Return the boolean whether the number is even or not?


def addBit(parity_type: str): 
   
   #Input: type of parity bit
   #Calculate the key for odd and even parity bit
   # Depend on TYPE
   
    first = '0' if parity_type in (
        TYPE_OF_PARITY[0], TYPE_OF_PARITY[2]) else '1'
    
    second = '1' if parity_type in (
        TYPE_OF_PARITY[0], TYPE_OF_PARITY[2]) else '0'
  
    return [first, second] #Output: Array of key of parity bit

def gen_CheckBit(dataword: np.ndarray, parity_type: str, axis='x') -> np.ndarray:

    """
      Input: dataword, type of parity bit, and axis of parity bit
      Generate the parity bit and append into original dataword given
      Output: the dataword combined with parity bit
  """
    
    # Get key that depends on the parity type
    [first, second] = addBit(parity_type) 
    
    # if two dimension and want to generate the parity bit for y axis, transpose them to x
    if axis == 'y':  
        dataword = dataword.T 
    
    # Append generated parity bit to original array of bit
    dataword = np.array( # even or not if type 0 2 , even add 0 else 1 
      [np.append(w, [first if Check_Sum_Even(w) else second]) for w in dataword])
    
    if axis == 'y': 
        return dataword.T # transpose back
    
    return dataword

def VerifyBits(c_word, parity_type):
  """
  Input: codeword, type of parity bit
  For Check whether the bit has changed or not
  Output: Validity of parity bit
  """
  [first, second] = addBit(parity_type) # Get key that depends on the parity type

  for word in c_word:
      keyCheck = first if Check_Sum_Even(word[0:-1]) else second
      if word[-1] != keyCheck: # If the key check is not equal the key for codeword -> the codeword has been damaged
          return 'FAILED'
  return 'PASSED'

def mergeStringFromList(arr: list): # Input: Array of array of bit or string
 
  # This function will Merge a bit or string in array to be 1 string
    
  return [''.join(l) for l in (d.tolist() for d in arr)] # Output: Array of string_


# In[37]:


def parity_gen(dataword: list, word_size: int, parity_type: str, array_size: int):

#codeword: bit string of any size up to word_size
#word_size: size of each dataword where word_size ≥ 5

  d_word = np.array([np.array(list(f)) for f in dataword]) # Create Numpy Array from the Dataword Array

  d_word = gen_CheckBit(d_word, parity_type) # Generate Bit in x axis

  # If the word is less than data word size provided in parameters, add 0 until it reaches data word size given.
  for i in range(len(d_word)):
      while d_word[i].size < word_size:
          d_word[i] = np.append(d_word[i], [0]) # Add 0 in word array in Dataword Numpy array

  
  if parity_type in TYPE_OF_PARITY[0:2]:
      return mergeStringFromList(d_word) # If type is 1D, return to codeword

  d_word = gen_CheckBit(d_word, parity_type, axis='y') # Generate Bit in y axis
  return mergeStringFromList(d_word) # Return codeword


# In[31]:


pbg_1 = parity_gen(['10110', '10010', '11101'], 5, TYPE_OF_PARITY[0], 3)
pbg_2 = parity_gen(['10110', '10010', '11101'], 5, TYPE_OF_PARITY[2], 3)
pbg_3 = parity_gen(['1011', '1000', '1010'], 4, TYPE_OF_PARITY[1], 3)
pbg_4 = parity_gen(['10110101', '10110000', '10010101'], 8, TYPE_OF_PARITY[1], 3)
pbg_5 = parity_gen(['101011', '010111', '000111'], 6, TYPE_OF_PARITY[2], 3)
pbg_6 = parity_gen(['111110', '001100', '101001'], 6, TYPE_OF_PARITY[3], 3)
pbg_7 = parity_gen(['10111', '10110', '00110','10100'], 5, TYPE_OF_PARITY[3], 4)
pbg_8 = parity_gen(['10110000', '01101100', '10010101','10110111'], 8, TYPE_OF_PARITY[2], 4)
pbg_9 = parity_gen(['111110', '001100', '101001','101101'], 6, TYPE_OF_PARITY[3], 4)
pbg_10 = parity_gen(['10111', '01000', '11111','10110'], 5, TYPE_OF_PARITY[2], 4)



print(f'Parity Bit Generation 1  : {pbg_1}')
print(f'Parity Bit Generation 2  : {pbg_2}')
print(f'Parity Bit Generation 3  : {pbg_3}')
print(f'Parity Bit Generation 4  : {pbg_4}')
print(f'Parity Bit Generation 5  : {pbg_5}')
print(f'Parity Bit Generation 6  : {pbg_6}')
print(f'Parity Bit Generation 7  : {pbg_7}')
print(f'Parity Bit Generation 8  : {pbg_8}')
print(f'Parity Bit Generation 9  : {pbg_9}')
print(f'Parity Bit Generation 10  : {pbg_10}')


# # Parity_check

# codeword: An array of codewords to check
# 
# parity_type: type of parity (one-dimensional-even, one-dimensional-odd, two-dimensional-even, two-dimensional-odd)
# 
# ARRAY_SIZE: Size of the array of the dataword

# In[32]:


def parity_check(codeword: list, parity_type: str, size: int):  # Parity Checker
    
  checkValid = 'PASSED' # Initialize Check Status

  c_word = np.array([np.array(list(w)) for w in codeword]) # Create Numpy Array from the Codeword Array

  checkValid = VerifyBits(c_word, parity_type) # Verify Checkbit in X axis

  if parity_type in TYPE_OF_PARITY[0:2] or checkValid == 'FAILED':
      return checkValid

  return VerifyBits(c_word.T, parity_type) # Verify Checkbit in Y axis


# In[33]:


pbv_1 = parity_check(['101101', '100100', '111010', '110011'], TYPE_OF_PARITY[0], 4)
pbv_2 = parity_check(['101101', '100100', '111010'], TYPE_OF_PARITY[1], 3)
pbv_3 = parity_check(['111010', '110011', '100100', '110001'], TYPE_OF_PARITY[2], 3)
pbv_4 = parity_check(['101111', '101100', '111010'], TYPE_OF_PARITY[3], 2)
pbv_5 = parity_check(['101101', '100100', '111010', '110011'], TYPE_OF_PARITY[2], 3)
pbv_6 = parity_check(['101111', '010111', '010110', '111111'], TYPE_OF_PARITY[3], 3)
pbv_7 = parity_check(['101101', '101100', '010001'], TYPE_OF_PARITY[0], 3)
pbv_8 = parity_check(['111000', '010100', '010011'], TYPE_OF_PARITY[1], 3)
pbv_9 = parity_check(['101101', '010101', '000001', '111010'], TYPE_OF_PARITY[1], 4)
pbv_10 = parity_check(['101001', '110011', '101010'], TYPE_OF_PARITY[0], 3)

print(f'Parity Bit Validation 1  : {pbv_1}')
print(f'Parity Bit Validation 2  : {pbv_2}')
print(f'Parity Bit Validation 3  : {pbv_3}')
print(f'Parity Bit Validation 4  : {pbv_4}')
print(f'Parity Bit Validation 5  : {pbv_5}')
print(f'Parity Bit Validation 6  : {pbv_6}')
print(f'Parity Bit Validation 7  : {pbv_7}')
print(f'Parity Bit Validation 8  : {pbv_8}')
print(f'Parity Bit Validation 9  : {pbv_9}')
print(f'Parity Bit Validation 10  : {pbv_10}')


# In[ ]:




