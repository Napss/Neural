/** 
* Creates and tests Matrix
* @author Naps
* @version 1.0
*/

import java.lang.Math;
import java.util.ArrayList;

public class Matrix{
	
	public double[][] createColumnMatrix(int taille){
		double[][] colMatrix= new double[taille][1];
		return colMatrix;
	}
	
	public double[][] createRowMatrix(int taille){
			double[][] rowMatrix = new double[1][taille];
			return rowMatrix;
	}
	
	public double[][]addInt(double[][] matrix, int entier){
		int row = matrix.length;
		int col = matrix[0].length;
		double[][] matadd = new double[row][col];
		for(int r=0; r<row;r++){
			for(int c=0; c<col;c++){
			matadd[r][c] = matrix[r][c] + entier;
			}
		}
	return matadd;	
	}
	public void clear(double[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		for(int r=0; r<row;r++){
			for(int c=0; c<col;c++){
			matrix[r][c] = 0;
			}
		}
	}
	public boolean[] getRowBoo(boolean[][] pats,int nb){
		int row = pats.length;
		int col = pats[0].length;
		boolean[] pat = new boolean[col];
		for(int c=0; c<col;c++){
			pat[c]=pats[nb][c];
		}
		return pat;
	}
	public double[][] clone(double[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		double[][] matclone = new double[row][col];
		for(int r=0; r<row;r++){
			for(int c=0; c<col;c++){
			matclone[r][c] = matrix[r][c];
			}
		}
		return matclone;
	}
	
	public boolean equals(double[][] matrix1, double[][] matrix2){
		int row1 = matrix1.length;
		int col1 = matrix1[0].length;	
		int row2 = matrix2.length;
		int col2 = matrix2[0].length;
		int compt=0;
		if(row1==row2 && col1==col2){
			for(int r=0; r<row1;r++){
				for(int c=0; c<col1;c++){
					if(matrix1[r][c]==matrix2[r][c]){
						compt=compt+1;
					}
				}
			}
			if(compt==row1*col1){return true;}
			else{return false;}
		}
		else{return false;}
	}
	public double[][] getCols(double[][] matrix, int colonne){
		int row = matrix.length;
		int col = matrix[0].length;
		double[][] colMat = createColumnMatrix(row);
		if(colonne<=col){
			for(int r=0; r<row;r++){
				colMat[r][0]  = matrix[r][colonne];
			}
			return colMat;
		}
		else{return colMat;}
	}
	public double[][] getRows(double[][] matrix, int ligne){
		int row = matrix.length;
		int col = matrix[0].length;
		double[][] rowMat = createRowMatrix(col);
		if(ligne<=row){
			for(int c=0; c<col;c++){
				rowMat[0][c]  = matrix[ligne][c];
			}
			return rowMat;
		}
		else{return rowMat;}
	}
	public double[][] getMat(double[][] matrix, int ligne1, int ligne2, int col1, int col2){
		int row = matrix.length;
		int col = matrix[0].length;
		int a = 0;
		int b = 0;
		if(ligne1>=0 && ligne2>=0 && col1>=0 && col2>=0 && ligne2<row && ligne1<row && col1<col && col2<col){
			double[][] mat = new double[Math.max(ligne2,ligne1)-Math.min(ligne2,ligne1)+1][Math.max(col2,col1)-Math.min(col2,col1)+1];
			for(int r=0;r<Math.max(ligne2,ligne1)-Math.min(ligne2,ligne1)+1;r++){
				for(int c=0;c<Math.max(col2,col1)-Math.min(col2,col1)+1;c++){
					mat[r][c]=matrix[r+Math.min(ligne1,ligne2)][c+Math.min(col1,col2)];
					a=a+1;
				}
				b=b+1;
			}
			return mat;
		}
		else{return matrix;}
	}
	public boolean isVector(double[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		if(row ==1 || col == 1){return true;}
		else{return false;}
	}
	public boolean isZero(double[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		int compt=0;
		for(int r=0; r<row;r++){
			for(int c=0; c<col;c++){
				if(matrix[r][c]==0){
					compt=compt+1;
				}
			}
		}
		if(compt==row*col){return true;}
		else{return false;}
	}
	public double sum(double[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		double sum = 0;
		for(int r=0; r<row;r++){
			for(int c=0; c<col;c++){
			sum = matrix[r][c] + sum;
			}
		}
		return sum;
	}
	public double[][] stackedRow(double[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		int length = row * col;
		int a = 0;
		double[][] matStacked = new double[1][length];
		for(int r=0; r<row;r++){
			for(int c=0; c<col;c++){
			matStacked[0][a] = matrix[r][c];
			a=a+1;
			}
		}
		return matStacked;
	}
	public double[][] set(double[][] matrix, int a){
		int row = matrix.length;
		int col = matrix[0].length;
		double[][] mat = new double[row][col];
		for(int r=0; r<row;r++){
			for(int c=0; c<col;c++){
			mat[r][c] = a;
			}
		}
		return mat;
	}
	
	public double[][] assembleLine(double[][] matrix1, double[][] matrix2){
		int row1 = matrix1.length;
		int col1 = matrix1[0].length;
		int row2 = matrix2.length;
		int col2 = matrix2[0].length;
		if(col1==col2){
			double[][] assembledMat = new double[row1+row2][col1];
			for(int r1=0; r1<row1;r1++){
				for(int c1=0; c1<col1;c1++){
					assembledMat[r1][c1] = matrix1[r1][c1];
				}
			}
			for(int r2=0; r2<row1;r2++){
				for(int c2=0; c2<col2;c2++){
					assembledMat[r2+row1][c2] = matrix1[r2][c2];
				}
			}
			return assembledMat;
		}
		else{return matrix1;}
	}
	public double[][] assembleColumn(double[][] matrix1, double[][] matrix2){
		int row1 = matrix1.length;
		int col1 = matrix1[0].length;
		int row2 = matrix2.length;
		int col2 = matrix2[0].length;
		if(col1==col2){
			double[][] assembledMat = new double[row1][col1+col2];
			for(int r1=0; r1<row1;r1++){
				for(int c1=0; c1<col1;c1++){
					assembledMat[r1][c1] = matrix1[r1][c1];
				}
			}
			for(int r2=0; r2<row1;r2++){
				for(int c2=0; c2<col2;c2++){
					assembledMat[r2][c2+col1] = matrix1[r2][c2];
				}
			}
			return assembledMat;
		}
		else{return matrix1;}
	}
	public void display(double[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		for(int r=0; r<row;r++){
			System.out.println(" ");
			for(int c=0; c<col;c++){
				System.out.print(" ");
				System.out.print(matrix[r][c]);
			}
		}
		System.out.println(" ");
	}
	public void display(double[] array){
		int length = array.length;
		for(int i=0;i<length;i++){
			System.out.print(" ");
			System.out.print(array[i]);
		}
		System.out.println(" ");
	}
	public void display(boolean[] array){
		int length = array.length;
		for(int i=0;i<length;i++){
			System.out.print(" ");
			System.out.print(array[i]);
		}
		System.out.println(" ");
	}
	public void display(boolean[][] pat){
		int row = pat.length;
		int col = pat[0].length;
		for(int r=0; r<row;r++){
			System.out.println(" ");
			for(int c=0; c<col;c++){
				System.out.print(" ");
				System.out.print(pat[r][c]);
			}
		}
		System.out.println(" ");
	}
	public void display(ArrayList<String> list){
		int size = list.size();
		for(int i=0; i<size;i++){
			System.out.println(" ");
				System.out.print(list.get(i));
			}
		System.out.println(" ");
	}
}
