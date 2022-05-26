def chckSquare(mat):
    row = len(mat)
    col = len(mat[0])
    if(row==col): return True
    else: return False

def chckDiagonal(mat):
    for i in range(len(mat)): 
        for j in range(len(mat[i])):
            if (i!=j) and (mat[i][j]!=0):
                print("the error occur on row and column %d, %d respectively"%(i+1,j+1))
                return False
    return True

mat = [[ 4, 0, 0, 0 ],
       [ 0, 7, 0, 0 ],
       [ 0, 0, 5, 0 ],
       [ 0, 0, 0, 1 ]]

if chckSquare(mat):
    if chckDiagonal(mat): print("Given matrix is diagonal matrix")
    else: print("Given matrix is not diagonal matrix")
else: print("Given matrix is not square matrix")