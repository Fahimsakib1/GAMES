package Touch_The_Ball;

import javax.swing.JFrame;


public class MainBallTouch {

	public static void main(String[] args)
	
	{
		JFrame obj = new JFrame();
		BallTouch gameplay = new BallTouch();
		obj.setBounds(550, 180, 700, 600);
		obj.setTitle(" Touch The Ball ");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gameplay);
		
		
		
    }
	
	
	

}
