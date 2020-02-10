package GUI;

public class Essentials 
{
	static Boolean winner=false;
	static Boolean tie=false;
	public static int count=0; //this will be to check when count reaches 9, meaning 9 turns have passed so game ends
	static String[][] board= 	{
							{" ", " ", " "},
							{" ", " ", " "},
							{" ", " ", " "}
						}; //this board holds onto the values that we show on the board
	
	static int  turn =0;// we will have two turns, 0 and 1, for both players
	
	public static String getBoardPosition(int x, int y) //returns what located in our board at the positions given
	{
		return board[x][y];
	}
	public static void setBoardposition(int x, int y) //this sets the board positions based on who turns it is
	{
		if(turn==0) board[x][y]="O";
		else if(turn==1) board[x][y]="X";
		else board[x][y]="error";
		
	}
	public static  void changeTurns() //changes turn
	{
		turn=(turn+1)%2; //we add one to our current turn, if it's zero it becomes 1, if its 2 it becomes 2 but when we mod it by 2 it becomes zero
	}
	public static  int getTurn() //gets the current player turns
	{
		return turn;
	}
	public static Boolean getWinner() //when a winner is declared this gets the winner
	{
		return winner;
	}
	public static Boolean getTie()
	{
		return tie;
	}
	
	//hint draw the board on paper and list the array
	public static void checkForWinner()
	{
		
		if(board[1][1]!=" " && board[1][1]==board[0][2]&& board[1][1]==board[2][0]) winner=true; //checks for a diagonal win of positive slop
		/*If this negative diagonal win is hard to understand you can use this line instead right after the If statement

		  else if(board[1][1]!=" " && board[0][0]==board[1][1]&& board[2][2]==board[0][0]) winner=true;

		 */ 
		else
		{
			for(int i=0; i<3; i++)
			{
				for(int j=0; j<3; j++)
				{
					if(board[i][j]!=" ") 
					{
						if (board[i][j]==board[i][(j+1)%3] && board[i][j]==board[i][(j+2)%3])  //checks for a horizontal win
						{
							winner=true;
							break;
						}
						else if(board[i][j]==board[(i+1)%3][j] && board[i][j]==board[(i+2)%3][j]) //checks for a vertical win
						{
							winner=true;
							break;
						}
						else if(i==j && board[i][j]==board[(i+1)%3][(j+1)%3] && board[i][j]==board[(i+2)%3][(j+2)%3])//checks for a diagonal win of negative slope
						{
							winner=true;
							break;
						}
					}
				}
		
			}
		}
		count++; //this increments each turn so when we reach 9 turns, the game is over
		//we already checked for winners, if 9 turn passed and no winner, we have a tie
		if(count==9&& winner==false) tie=true;
	}
	
}
