/** 
* Operations on Matrix
* @author Naps
* @version 1.0
*/

public class MatrixMath {
	
	public double[][] addMat(double[][] matrix1, double[][] matrix2){
		int row1 = matrix1.length;
		int col1 = matrix1[0].length;	
		int row2 = matrix2.length;
		int col2 = matrix2[0].length;
		double[][] matadd = new double[row1][col1];
		if(row1==row2 && col1==col2){
			for(int r=0; r<row1;r++){
				for(int c=0; c<col1;c++){
				matadd[r][c] = matrix1[r][c]+matrix2[r][c];
				}
			}
		}
		return matadd;
	}
	
	public double[][] subMat(double[][] matrix1, double[][] matrix2){
		int row1 = matrix1.length;
		int col1 = matrix1[0].length;	
		int row2 = matrix2.length;
		int col2 = matrix2[0].length;
		double[][] matsub = new double[row1][col1];
		if(row1==row2 && col1==col2){
			for(int r=0; r<row1;r++){
				for(int c=0; c<col1;c++){
				matsub[r][c] = matrix1[r][c]-matrix2[r][c];
				}
			}
		}
		return matsub;
	}
	public double[][] divide(double[][] matrix1, double nb){
		int row = matrix1.length;
		int col = matrix1[0].length;
		double[][] matdiv = new double[row][col];
		if(nb!=0){
			for(int r=0; r<row;r++){
				for(int c=0; c<col;c++){
				matdiv[r][c] = matrix1[r][c]/nb;	
				}
			}
		}
		return matdiv;
	}
	public double[][] multiply(double[][] matrix1, double nb){
		int row = matrix1.length;
		int col = matrix1[0].length;
		double[][] matmult = new double[row][col];
		if(nb!=0){
			for(int r=0; r<row;r++){
				for(int c=0; c<col;c++){
				matmult[r][c] = matrix1[r][c]*nb;	
				}
			}
		}
		return matmult;
	}
	public double[][] identity(int col){
		double[][] I = new double[col][col];
		int a=0;
		for(int c=0; c<col;c++){
			I[c][a] = 1;
			a=a+1;
		}
		return I;
	}
	public double[][] transpose(double[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		double[][] transposed = new double[col][row];
		for(int r=0; r<row;r++){
			for(int c=0; c<col;c++){
			transposed[c][r] = matrix[r][c];	
			}
		}
		return transposed;
	}
	
	public double[][] mult(double[][] a, double[][] b){
		if(a.length == 0){return new double[0][0];}
		if(a[0].length != b.length){return null;}
		int n = a[0].length;int m = a.length;int p = b[0].length;
		double ans[][] = new double[m][p];
		for(int i=0; i<m;i++){
			for(int j=0; j<p;j++){
				for(int k=0; k<n;k++){
					ans[i][j] += a[i][k] * b[k][j];
			}
		}
	}
		return ans;
	}
	
	public double[][] size(double[][] matrix){
		double[][] s = new double[1][2];
		int row = matrix.length;
		int col = matrix[0].length;
		s[0][0] = row;
		s[0][1] = col;
		return s;
	}
}
