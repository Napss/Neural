/** 
* Hopfield Network
* @author Naps
* @version 1.0
*/
import java.lang.Math;
import java.util.ArrayList;

public class HopfieldNetwork{
	protected double[][] weightMatrix;

	public double[][] train(boolean[] pattern){
		Matrix matrix = new Matrix();
		MatrixMath matrixMath = new MatrixMath();
		BiPolarUtil bip = new BiPolarUtil();
		int l=pattern.length;
		double[][] vect = new double[1][l];
		double[][] trans = new double[l][1];
		double[][] res = new double[l][l];
		for(int i=0; i<l;i++){
			vect[0][i] = bip.boo2double(pattern[i]);
		}
		trans = matrixMath.transpose(vect);
		res=matrixMath.mult(trans,vect);
		double z=res[0][0];
		res = matrixMath.subMat(res,matrixMath.multiply(matrixMath.identity(l),z));
		res=matrixMath.addMat(weightMatrix,res);
		weightMatrix=res;
		return res;
	}
	public double degre(){
		double a = 0;
		int row = weightMatrix.length;
		int col = weightMatrix[0].length;
		for(int r=0; r<row;r++){
			for(int c=0; c<col;c++){
				if(weightMatrix[r][c]!=0){a=weightMatrix[r][c];}				
			}
		}
		return Math.abs(a);
	}
	public boolean test(boolean[] pattern){
		Matrix matrix = new Matrix();
		MatrixMath matrixMath = new MatrixMath();
		BiPolarUtil bip = new BiPolarUtil();
		double[][] pat = bip.boo2double(pattern);
		double[][] mu=matrixMath.mult(pat,weightMatrix);
		double k = degre();
		int row = weightMatrix.length;
		double[][] m = matrixMath.multiply(pat,row-k);
		return matrix.equals(m,mu);
	}
	public ArrayList<String> test(boolean[][] patternlist){
		Matrix matrix = new Matrix();
		MatrixMath matrixMath = new MatrixMath();
		BiPolarUtil bip = new BiPolarUtil();
		int row = patternlist.length;
		int col = patternlist[0].length;
		ArrayList<String> list = new ArrayList<String>();
		for(int r=0; r<row;r++){
			if(test(matrix.getRowBoo(patternlist,r))==true){list.add(Integer.toString(r+1));}
		}
		return list;
	}
	
	public double[][] getMatrix(){
		return this.weightMatrix;
	}
	
	public int getSize(){
		return this.weightMatrix.length;
	}
}
