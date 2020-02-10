package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.*;

public class Draw 
{
	Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
	
	JFrame boardFrame; //Creates the Frame for the board
	JButton[][] board; //creates an array of buttons
	JPanel panel = new JPanel(); //creates a Panel to place the buttons on, so we can format as 3 by 3 like a tic tac toe board
	public Draw()
	{
		boardFrame=new JFrame(); 
		boardFrame.setSize((int)width, (int)height);
		
		board=new JButton[3][3];
		setButtons(); 
		
	    GridLayout layout = new GridLayout(3,3); //creates the layout of the grid to be 3 by 3
		
		
	    
	    panel.setSize((int)width, (int)height);
	    panel.setLayout(layout); //this sets the layout of the panel        
	    createEvents(); //goes to the method, createEvents();
	    
	    boardFrame.add(panel); //this add our panel which holds our board onto our frame.
	    boardFrame.setVisible(true); //must be set after everything is added to the frame
	    
	    
	   
	}
	public void setButtons()
	{
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				board[i][j]= new JButton();
				setButtonsText(i,j);
				board[i][j].setFont(new Font("Arial", Font.PLAIN, 50));
				if(Essentials.board[i][j]!=" ") board[i][j].setEnabled(false);
				
				panel.add(board[i][j]);
			}
		}
	}
	
	public void setButtonsText(int x, int y)
	{
		board[x][y].setText(Essentials.getBoardPosition(x, y)); //calls on the essentials class to the the X or O or blank position
	}
	public void createEvents() //the actions listeenrs are for whent the button is pressed, 
	{ 
		board[0][0].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				Essentials.setBoardposition(0, 0); //sets the board position that is clicked to either x or o, this case the position is 0,0 top left
				Essentials.checkForWinner(); //checks if anyone won
				end(); //checks if the game has ended
				Essentials.changeTurns(); //changes the turn of the player
				setButtonsText(0,0); //sets what viewable on the board to x or o
				board[0][0].setEnabled(false); //makes it so the button is no longer clickable
			}  
		});
		
		board[0][1].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				Essentials.setBoardposition(0, 1);
				Essentials.checkForWinner();
				end();
				Essentials.changeTurns();
				setButtonsText(0,1);
				board[0][1].setEnabled(false);
			}  
		});
		
		board[0][2].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				Essentials.setBoardposition(0, 2);
				Essentials.checkForWinner();
				end();
				Essentials.changeTurns();
				setButtonsText(0,2);
				board[0][2].setEnabled(false);
			}  
		});
		
		board[1][0].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				Essentials.setBoardposition(1, 0);
				Essentials.checkForWinner();
				end();
				Essentials.changeTurns();
				setButtonsText(1,0);
				board[1][0].setEnabled(false);
			}  
		});
		
		board[1][1].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				Essentials.setBoardposition(1, 1);
				Essentials.checkForWinner();
				end();
				Essentials.changeTurns();
				setButtonsText(1,1);
				board[1][1].setEnabled(false);
			}  
		});
		
		board[1][2].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				Essentials.setBoardposition(1, 2);
				Essentials.checkForWinner();
				end();
				Essentials.changeTurns();
				setButtonsText(1,2);
				board[1][2].setEnabled(false);
			}  
		});
		
		board[2][0].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				Essentials.setBoardposition(2, 0);
				Essentials.checkForWinner();
				end();
				Essentials.changeTurns();
				setButtonsText(2,0);
				board[2][0].setEnabled(false);
			}  
		});
		
		board[2][1].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				Essentials.setBoardposition(2, 1);
				Essentials.checkForWinner();
				end();
				Essentials.changeTurns();
				setButtonsText(2,1);
				board[2][1].setEnabled(false);
			}  
		});
		
		board[2][2].addActionListener(new ActionListener()
		{  
			public void actionPerformed(ActionEvent e)
			{  
				Essentials.setBoardposition(2, 2);
				Essentials.checkForWinner();
				end();
				Essentials.changeTurns();
				setButtonsText(2,2);
				board[2][2].setEnabled(false);
				
			}  
		});
		
			
	}
	public void end()
	{
		Boolean endB=false;
		String endS= " ";
		if(Essentials.getWinner()) 
		{
			endB= true;
			endS="The Winner is Player ";
			
			if(Essentials.getTurn()==0) endS=endS.concat("O (Circles)"); 
			else endS=endS.concat("X (Not Circles)");
		}
		else if (Essentials.getTie())
		{
			endB= true;
			endS="Tie";
			
		}
		if(endB)
		{
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					if(board[i][j].isEnabled()) board[i][j].setEnabled(false);
				}
			}
			//if game is over, makes a new Frame with a game over message.
			JFrame end= new JFrame();
			end.setSize(1000,  1000);
			JButton endbutton= new JButton(endS);
			endbutton.setBounds(1300,1000, 500, 400);//x axis, y axis, width, height
			endbutton.setFont(new Font("Arial", Font.PLAIN, 40));
			end.add(endbutton);
			end.setVisible(true);
		
		}
		
	}
}
