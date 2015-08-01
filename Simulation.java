/** 
* Generate Patterns and Test Neural Network
* @author Naps
* @version 1.0
*/

import java.util.Random;

public class Simulation {

	public boolean[][] generatePatterns(int size,int nb){
	    Random rand = new Random();
	    boolean[][] pats = new boolean[nb][size];
	    
	    for(int i=0; i<size;i++){
	    	for(int j=0; j<nb;j++){
	    		int x=rand.nextInt(2);
	    		if(x==1){pats[j][i]=true;}
	    		else{pats[j][i]=false;}
	    	}
	    }
		return pats;
	}
	public boolean[] generatePattern(int size){
	    Random rand = new Random();
	    boolean[] pat = new boolean[size];
		for(int i=0; i<size;i++){
    		int x=rand.nextInt(2);
    		if(x==1){pat[i]=true;}
    		else{pat[i]=false;}
		}
		return pat;
	}
	public static void main(String[] args) {
		Matrix matrix = new Matrix();
		MatrixMath matrixMath = new MatrixMath();
		BiPolarUtil bip = new BiPolarUtil();
		HopfieldNetwork hop = new HopfieldNetwork();
		Simulation simu = new Simulation();
		int size=4;
		hop.weightMatrix = new double[size][size];
		boolean[] pattern = simu.generatePattern(size);
		matrix.display(pattern);
		System.out.println(" ");
		boolean[][] patternlist = simu.generatePatterns(size,10);
		matrix.display(patternlist);
		System.out.println(" ");
		matrix.display(matrix.getRowBoo(patternlist,3));
		hop.train(pattern);
		System.out.println(hop.test(patternlist));
	}
}
