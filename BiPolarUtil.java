/** 
* Bipolar to Double & Double to Bipolar
* @author Naps
* @version 1.0
*/

public class BiPolarUtil{
	
	public double bipolar2double(double bipolar){
		if(bipolar==0 || bipolar==1){
			double dble = 2*bipolar -1;
			return dble;
		}
	}
	
	public double boo2double(boolean boo){
		double dble;
		if(boo==true){dble==1;}
		else{dble=-1;}
		return dble;
	}
	
	public double[][] boo2double(boolean boo[]){
		double dble[][] = new double[1][boo.length];
		for(int i=0;i<boo.length;i++){
			dble[0][i]=boo2double(boo[i]);
		}
		return dble;
	}
	
	public double double2bipolar(double dble){
		if(dble==-1 || dble==1){
			double bipolar = (dble+1)/2; 
			return bipolar;
		}
		else{return 0;}
	}
	
	public boolean double2boo(double dble){
		boolean boo;
		if(dble==1){boo=true;}
		else{boo=false;}
		return boo;
	}
	
}
