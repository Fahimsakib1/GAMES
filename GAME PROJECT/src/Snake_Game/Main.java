package Snake_Game;

import javax.swing.JFrame;

public class Main 

{
   
    public Main() 
    
    {
       
        JFrame frame = new JFrame();
        Screen screen = new Screen();
       
        frame.add(screen);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Snake Game");
        //frame.setResizable(false);
        
        
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);    
       
    }
    
    
    public static void main(String[] args) 
    
    {
        new Main();
    }
    
    
}

