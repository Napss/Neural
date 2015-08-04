/** 
* Generate Patterns and Test Neural Network
* @author Naps
* @version 1.0
*/

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Simulation implements ActionListener{
	protected static double[][] weightMatrix;
	protected static int degre;
	protected static ArrayList<String> trainedPattern = new ArrayList<String>();
	protected static JLabel myLabels[];

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
		int size=64;
		weightMatrix = new double[size][size];
		Grid grid = new Grid();
		grid.frm();
		//System.out.println(myLabels[0].getBackground());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
