def chckSquare(mat):
    row = len(mat)
    col = len(mat[0])
    if(row==col): return True
    else: return False

def chckSkew(mat):
    for i in range(len(mat)): 
        for j in range(len(mat[i])):
            if (mat[i][j] != (-1)*mat[j][i]) and i!=j:
                print("the error occur on i = %d, j = %d"%(i+1,j+1))
                return False
    return True

mat = [[ 3, 2, -4],
       [ -2, 5, 2],
       [ 4, -2, 3]]

if chckSquare(mat):
    if chckSkew(mat): print("Given matrix is skew matrix")
    else: print("Given matrix is not skew matrix")
else: print("Given matrix is not square matrix")