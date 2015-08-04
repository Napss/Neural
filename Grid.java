/** 
* GUI of Hopfield Network
* @author Naps
* @version 1.0
*/
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Grid extends Simulation implements MouseListener{
	protected static JFrame myFrame = new JFrame("Hopfield Network");
 	JPanel panel = new JPanel();
 	JPanel panel2 = new JPanel();
 	JPanel menuPanel = new JPanel();
	JButton train = new JButton("train");
	JButton clear = new JButton("clear");
	JButton test = new JButton("test");
	JButton testreco = new JButton("testreco");
	JButton reset = new JButton("reset");

    public void frm(){

    	myFrame.setResizable(false);
    	panel.setPreferredSize(new Dimension(500, 500));
    	panel.setLayout(new GridLayout(8,8));
    	panel.addMouseListener(this);
		JMenuBar menuBar;
		menuBar = new JMenuBar();
		menuPanel.add(menuBar);
		JMenu menu1= new JMenu("Menu");
		menuBar.add(menu1);
		JMenuItem reset = new JMenuItem("Reset");
		menu1.add(reset);
    	reset.addActionListener(this);

    	myLabels = new JLabel[64];
    	panel2.add(train);
    	train.addActionListener(this);
    	panel2.add(test);
    	test.addActionListener(this);
    	panel2.add(clear);
    	clear.addActionListener(this);
    	panel2.add(testreco);
    	testreco.addActionListener(this);
    	int width= 500;
    	int height= 500;
        for (int x = 0;x<myLabels.length;x++){

        	myLabels[x]=new JLabel("");
        	myLabels[x].setSize(width, height);
            myLabels[x].setOpaque(true);
            myLabels[x].setBackground(Color.white);
            myLabels[x].setBorder(BorderFactory.createLineBorder(Color.black));
            myLabels[x].addMouseListener(this); 
        }
        for (int x = 0;x<myLabels.length;x++){
        	panel.add(myLabels[x]);
        }
        myFrame.getContentPane().add(menuPanel, BorderLayout.NORTH);
        myFrame.add(panel);
        myFrame.add(panel2, BorderLayout.SOUTH);
		FlowLayout flowLayout = (FlowLayout) menuPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
        myFrame.setVisible(true);
        myFrame.pack();
    }
    public boolean[] getPattern(){
    	int size = myLabels.length;
    	boolean[] pattern = new boolean[size];
    	for (int x = 0;x<size;x++){
    		if (myLabels[x].getBackground()==Color.white){pattern[x]=false;}
    		else{pattern[x]=true;}
    	}
    return pattern;
    } 
    @Override
    public void mouseClicked(MouseEvent e) {
        JLabel clickedPanel = (JLabel) e.getSource();

        //Toggle colours    
        if (clickedPanel.getBackground()==Color.white)
            clickedPanel.setBackground(Color.black);
        else 
            clickedPanel.setBackground(Color.white);
    }
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == clear){
			for (int x = 0;x<myLabels.length;x++){
				myLabels[x].setBackground(Color.white);
			}
	        myFrame.setVisible(true);
			myFrame.repaint();
		}	
		else if (e.getSource() == train){
			Matrix matrix = new Matrix();
	    	int size = myLabels.length;
			boolean[] pattern = new boolean[size];
			pattern = getPattern();
			HopfieldNetwork hop = new HopfieldNetwork();
			hop.train(pattern);
			//matrix.display(getPattern());
		}
		else if (e.getSource() == test){
			HopfieldNetwork hop = new HopfieldNetwork();
	    	int size = myLabels.length;
			boolean[] pattern = new boolean[size];
			pattern = getPattern();
			System.out.println(hop.test(pattern));
		}
		else if (e.getSource() == testreco){
			HopfieldNetwork hop = new HopfieldNetwork();
	    	int size = myLabels.length;
			boolean[] pattern = new boolean[size];
			pattern = getPattern();
			double[][] output = hop.testreturn(pattern);
			int col = output[0].length;
			for(int i=0; i<col;i++){
				if(output[0][i]==1){myLabels[i].setBackground(Color.black);}
				else if(output[0][i]==-1){myLabels[i].setBackground(Color.white);}
				else{myLabels[i].setBackground(Color.yellow);}
			}
	        myFrame.setVisible(true);
			myFrame.repaint();
		}
		else if (e.getSource() == reset){
			Matrix matrix = new Matrix();
			matrix.clear(weightMatrix);
		}
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



}
