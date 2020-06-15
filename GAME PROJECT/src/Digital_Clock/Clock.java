package Digital_Clock;

import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Clock extends Frame implements Runnable

{
      Label text;
  	  boolean running = false;
      
      
      public Clock()
      
      { 
    	   JFrame frame = new JFrame (" Digital Clock ");
    	   //frame.setSize (600, 300);
    	   frame.setSize (850, 300); 
    	   frame.setLocationRelativeTo (null);
    	   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   
    	   
    	   text = new Label("");
    	   text.setFont( new Font ("Timenewroman", Font.BOLD, 120));
    	   //text.setText(" 00: 00: 00 ");
    	   frame.add(text);
    	   frame.setVisible(true);
    	   
    	   dateupdate();
    	   
      }
      
      
     public void run() 

      {
      	while( running )
      	{
      		
      		dateupdate();
      		
      		try
      		{
      			Thread.sleep(1000);
      			
      		}
      		
      		catch (Exception e)
      		{
      			
      			e.printStackTrace();
      		}
      	}
      	
     }
      
      public void start ()
      
      {
    	  running = true;
    	  new Thread (this).start();
    	  
      }

   
      
      public void dateupdate()
      
      {
    	  Calendar calendar = Calendar.getInstance();
    	  
    	  int hour = calendar.get(Calendar.HOUR);
    	  int minute = calendar.get(Calendar.MINUTE);
    	  int second = calendar.get(Calendar.SECOND);
    	  
    	  String sr = "Time ";
    	  
    	  if( hour < 10 )
    	  {
    		  sr += "0"+ hour;
    		  
    	  }
    	  else
    	  {
    		  sr += hour;
    		  
    	  }
    	  
    	  
    	  
    	  if( minute < 10 )
    	  {
    		  sr += ":0"+ minute;
    		  
    	  }
    	  else
    	  {
    		  sr += ":"+ minute;
    		  
    	  }
    	  
    	  
    	  
    	  if( second < 10 )
    	  {
    		  sr += ":0"+ second;
    		  
    	  }
    	  else
    	  {
    		  sr += ":" +second;
    		  
    	  }
    	  
    	  text.setText(sr);
    	
    	 }
      

        public static void main(String[] args) 
	
	   {
		  new Clock ().start();

	   }
     

     }
