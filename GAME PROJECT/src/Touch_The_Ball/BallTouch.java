package Touch_The_Ball;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import Brick_Breaker_Game.MapGenerator;

import javax.swing.JPanel;

public class BallTouch extends JPanel implements KeyListener,ActionListener


{
	
	private boolean play = false;
	private int score = 0;
	
	private int totalBricks = 21;
	
	private Timer timer;
	private int delay = 8;
	
	private int playerX = 310;
	
	private int ballposX = 120;
	private int ballposY = 350;
	private int ballXdir = -1;
	private int ballYdir = -2;
	
	public BallTouch ()
	{
		
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer (delay, this);
		timer.start();
		
	}
	
	public void paint (Graphics g)
	
	
	{
		// background
		g.setColor(Color.black);
		g.fillRect(1,1, 692, 592 );
		
		//borders 
        g.setColor(Color.green);
		g.fillRect(0,  0 ,  3, 592 );
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		// paddle
		g.setColor(Color.red);
		g.fillRect(playerX, 550, 100 , 8 );
		
		// ball
		g.setColor(Color.yellow);
		g.fillOval(ballposX, ballposY, 20, 20 );
		
		
		if ( ballposY > 570 )
		{
			
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			
			g.setColor(Color.red);
			g.setFont( new Font ("serif", Font.BOLD, 28));
			g.drawString("GAME OVER ", 230, 300 );
			
			g.setFont( new Font ("serif", Font.BOLD, 25));
			g.drawString("Press Enter To Continue  ", 190, 350 );
			
			}
		
		
		g.dispose();
		
	}
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
		timer.start();
		
		if (play )
			
		{    
			if (new Rectangle (ballposX, ballposY, 20, 20 ).intersects(new Rectangle (playerX, 550 , 100, 8 )))
			{
				ballYdir = -ballYdir;
				
			}
			
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			
			if ( ballposX < 0 )
			{
				
				ballXdir = -ballXdir;
			}
			
			if ( ballposY < 0 )
			{
				
				ballYdir = -ballYdir;
			}
			
			if ( ballposX > 670 )
			{
				
				ballXdir = -ballXdir;
			}
			
			
		}
		
		
		repaint();
		
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e)  // don't delete this. It it show  an error to the BallTouch Class 
	{
		
		
	}

	@Override
    public void keyReleased(KeyEvent e) // don't delete this. It it show an error  to the BallTouch Class 
	{
	
		
	}
	
	


	public void keyPressed(KeyEvent e) 
	
	{
		
		if ( e.getKeyCode() == KeyEvent.VK_RIGHT )
		{
			
			if( playerX >=600 )
			{
				
				playerX = 600;
			}
			
			else
			{
				
				moveRight();
			}
		}
		
		
		if ( e.getKeyCode() == KeyEvent.VK_LEFT)
		{
			
			if( playerX < 10 )
			{
				
				playerX = 10;
			}
			
			else
			{
				
				moveLeft();
			}
			
		}
		
		
		
		if ( e.getKeyCode() == KeyEvent.VK_ENTER )
		{
			if (!play )
			{
				play = true;
				ballposX = 120;
				ballposY = 350;
				ballXdir = -1;
				ballYdir = -2;
				playerX = 310;
				score = 0;
				//totalBricks = 30;
				//map = new MapGenerator (5, 6);
				
				repaint();
				
			}
			
		}
		
		
		
	}
	
	public void moveRight()
	{
		play = true;
		playerX += 20;
		
	}
	
	public void moveLeft()
	{
		play = true;
		playerX -= 20;
		
	}

	
	

}

