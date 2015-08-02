/** 
* Hopfield Network
* @author Naps
* @version 1.0
*/
import java.lang.Math;
import java.util.ArrayList;

public class HopfieldNetwork extends Simulation{

	
	public double[][] train(boolean[] pattern){
		Matrix matrix = new Matrix();
		MatrixMath matrixMath = new MatrixMath();
		BiPolarUtil bip = new BiPolarUtil();
		HopfieldNetwork hop = new HopfieldNetwork();
		int l=pattern.length;
		degre=degre+1;
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

	public boolean test(boolean[] pattern){
		Matrix matrix = new Matrix();
		MatrixMath matrixMath = new MatrixMath();
		BiPolarUtil bip = new BiPolarUtil();
		double[][] pat = bip.boo2double(pattern);
		double[][] mu=matrixMath.mult(pat,weightMatrix);
		int row = weightMatrix.length;
		double[][] m = matrixMath.multiply(pat,row-degre);
		m=matrixMath.sign(m);
		mu=matrixMath.sign(mu);
		return matrix.equals(m,mu);
	}
	public ArrayList<ArrayList<Integer>> test(boolean[][] patternlist){
		Matrix matrix = new Matrix();
		MatrixMath matrixMath = new MatrixMath();
		BiPolarUtil bip = new BiPolarUtil();
		HopfieldNetwork hop = new HopfieldNetwork();
		int row = patternlist.length;
		int col = patternlist[0].length;
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int r=0; r<row;r++){
			if(test(matrix.getRowBoo(patternlist,r))==true){l.add(r+1);}
		}
		list.add(l);
		return list;
	}
	
	public double[][] getMatrix(){
		return this.weightMatrix;
	}
	
	public int getSize(){
		return this.weightMatrix.length;
	}
}
