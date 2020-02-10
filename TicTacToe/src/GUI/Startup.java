package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Startup 
{
	
	Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize(); //This gets the users screensize
	Dimension buttonSize=new Dimension(screenSize.width/4, screenSize.height/4); //this will set our startingButton size later on
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	private JFrame startScreen; //we need a JFrame to create a place for our code to show
	private JPanel startPanel; //Not really needed but added for practice use. panel is a container that basicly just groups different compemenets.
	private JButton startingButton; //From the starting screen we need a way to get to our game
	
	public Startup()
	{
		startScreen= new JFrame("Tic Tac Toe");
		startScreen.setDefaultCloseOperation(startScreen.EXIT_ON_CLOSE); //if the user closes the Frame, the program terminates

		startPanel=new JPanel();
		startingButton= new JButton("Start Game"); //Initalizes and labels our button
		setup(); //calls on the method setup
	}
	
	private void setup()
	{
		startScreen.setSize((int)width, (int)height);  
		startScreen.setLayout(new GridBagLayout());//GridBagLayout is being used to center our button 
		
		
		startPanel.setSize((int)width, (int)height); //Since we are only adding a button, in this case our panel will be the same size as our frame
		
		
		
		startingButton.setPreferredSize(buttonSize);//x axis, y axis, width, height
		
		
		startingButton.setFont(new Font("Arial", Font.PLAIN, 40)); //Makes the font type arial, Plain is a simple style, 40 is the size
		startPanel.add(startingButton);//adding button in JFrame  
		startScreen.add(startPanel);//adding button in JFrame  
        
			startScreen.setVisible(true);//making the frame visible  
		
		startingButton.addActionListener(new ActionListener() //An action Listener just activates when the button is pressed
		{  
			public void actionPerformed(ActionEvent e)
			{  
				
				startScreen.dispatchEvent(new WindowEvent(startScreen, WindowEvent.WINDOW_CLOSING)); //This closes the start up Frame 
				Draw draw=new Draw(); //go to the draw class and starts at the code public draw()
				
			}  
		});
	}
	
	
}
