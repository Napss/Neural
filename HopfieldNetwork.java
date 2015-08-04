/** 
* Hopfield Network
* @author Naps
* @version 1.0
*/
import java.lang.Math;
import java.util.ArrayList;

public class HopfieldNetwork extends Simulation{

	public String convert2letters(boolean[] pattern){
		int l=pattern.length;
		String s="";
		for(int i=0; i<l;i++){
			if(pattern[i]==true){s=s+"T";}
			else{s=s+"F";}
		}
			return s;	
	}
	
	public String convert2letters(boolean[][] patternlist, int ligne){
		int row = patternlist.length;
		int col = patternlist[0].length;
		String s="";
		for(int i=0; i<col;i++){
			if(patternlist[ligne][i]==true){s=s+"T";}
			else{s=s+"F";}
		}
			return s;	
	}
	public double[][] train(boolean[] pattern){
		Matrix matrix = new Matrix();
		MatrixMath matrixMath = new MatrixMath();
		BiPolarUtil bip = new BiPolarUtil();
		HopfieldNetwork hop = new HopfieldNetwork();
		int l=pattern.length;
		degre=degre+1;
		trainedPattern.add(" ");
		double[][] vect = new double[1][l];
		double[][] trans = new double[l][1];
		double[][] res = new double[l][l];
		String s=hop.convert2letters(pattern);
		trainedPattern.set(degre-1,s);
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
	public ArrayList<ArrayList<String>> test(boolean[][] patternlist){
		Matrix matrix = new Matrix();
		MatrixMath matrixMath = new MatrixMath();
		BiPolarUtil bip = new BiPolarUtil();
		HopfieldNetwork hop = new HopfieldNetwork();
		int row = patternlist.length;
		int col = patternlist[0].length;
		ArrayList<String> l = new ArrayList<String>();
		ArrayList<String> l2 = new ArrayList<String>();
		ArrayList<String> l3 = new ArrayList<String>();
		int c=0;
		int compt=0;
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		list.clear();
		list.add(l);
		list.add(l2);
		for(int r=0; r<row;r++){
			if(test(matrix.getRowBoo(patternlist,r))==true){l.add(String.valueOf(r+1)); l2.add(convert2letters(patternlist[r]));c=c+1;}
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
