package edu.quinnipiac.ser210.fourinarow;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * TicTacToe class implements the interface
 * @author relkharboutly
 * @date 2/12/2022
 */
//Julia Woeste
//assignment 1 part 2
//2/21/22
public class FourInARow implements IGame {
		 
	   // The game board and the game status
	   private static final int ROWS = 6, COLS = 6; // number of rows and columns
	   private int[][] board = new int[ROWS][COLS]; // game board in 2D array
	  
	/**
	 * clear board and set current player   
	 */
	public FourInARow(){
		
	}
	@Override
	public void clearBoard() {
		for(int i = 0; i < ROWS; i++) {
			for(int j = 0; j < COLS; j++) {
				board[ROWS][COLS] = EMPTY;
			}
		}
	}

	@Override
	public void setMove(int player, int location) {
		int col = (location%6);
		int row = ((location/6)%6);
		if(board[row][col] == EMPTY) {
		board[row][col] = player;
		
		}
		else if(board[row][col] != EMPTY && player == FourInARow.BLUE) {
			System.out.println("That spot is taken, please try again");
			Scanner userInput = new Scanner(System.in); 
			int playermove = userInput.nextInt();
			setMove(FourInARow.BLUE, playermove);
		
		} 
		else if(board[row][col] != EMPTY && player == FourInARow.RED) {
			getComputerMove();
		}
	}

	@Override
	public int getComputerMove() {
		
			return genNum();
		}
		
		
	

	@Override
	public int checkForWinner() {
		int blueplayer = 0;
		int redplayer = 0; 
		
		//checking for horizontal
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if(board[r][c] == FourInARow.BLUE) {
					blueplayer++;
				} else blueplayer = 0;
				
				if(board[r][c] == FourInARow.RED) {
					redplayer++;
				} else redplayer = 0;
					
				if (blueplayer >= 4) {
					System.out.println("blue player won");
					return BLUE_WON;
				}
				if(redplayer >= 4) {
					System.out.println("red player won");
					return RED_WON;
				}
			}
		}
			

		//check for vertical
		for (int c = 0; c < COLS; c++) {
			for(int r = 0; r < ROWS; r++) {
				if(board[r][c] == FourInARow.BLUE ) {
					blueplayer++; 
				}else blueplayer = 0;
				
				if(board[r][c] == FourInARow.RED) {
					redplayer++;
				}else redplayer = 0;
				
				if (blueplayer >= 4) {
					System.out.println("blue won");
					return BLUE_WON;
				}
				if(redplayer >= 4) {
					System.out.println("red won");
					return RED_WON;
				}
						
			 }
		 }
		
		//check diagonally
		for(int r = 0; r < ROWS; r++ ) { 
			for(int c = 0; c < COLS; c++) {
				int currentsquare = board[r][c];
				if(currentsquare != EMPTY) {
				if (r+ 1 < ROWS && c + 1 < COLS && board[r + 1][c + 1] == currentsquare ) {
					if(r+ 2 < ROWS && c + 2 < COLS && board[r + 2][c + 2] == currentsquare ) {
						if(r+ 3 < ROWS && c + 3 < COLS && board[r + 3][c + 3] == currentsquare ) {
							if(currentsquare == RED) {
								//System.out.println("red won");
								return RED_WON;
							}
							else{
								//System.out.println("blue won");
								return BLUE_WON;
								}
							}
						}
					}
				}
			}
		}
		for(int r = 0; r < ROWS; r++ ) {  
			for(int c = 0; c < COLS; c++) {
				int currentsquare = board[r][c];
				if(currentsquare != EMPTY) {
					if (r + 1 < ROWS && c - 1 >= 0 && board[r + 1][c - 1] == currentsquare ) {
						if(r + 2 < ROWS  && c - 2 >= 0 && board[r + 2][c - 2] == currentsquare ) {
							if(r + 3 < ROWS  && c - 3 >= 0 && board[r + 3][c - 3] == currentsquare ) {
								if(currentsquare == RED) {
										//System.out.println("red won 2");
									return RED_WON;
									}
								else{
										//System.out.println("blue won 2");
									return BLUE_WON;
									}
								}
							}
						}
					}
			    }
			}
	
					
			
			
			
			//check for tie, checks if any empty cells and if there is then return playing. anything else return a tie
			for(int r = 0; r < ROWS; r++ ) { 
				for(int c = 0; c < COLS; c++) {
					if(board[r][c] == EMPTY) {
						return PLAYING;
					}
				
				}
				
				}
			
		
			return TIE;
	}
		
	  /**
	   *  Print the game board 
	   */
	   public  void printBoard() {
		  
	      for (int row = 0; row < ROWS; ++row) {
	         for (int col = 0; col < COLS; ++col) {
	            printCell(board[row][col]); // print each of the cells
	            if (col != COLS - 1) {
	               System.out.print("|");   // print vertical partition
	            }
	         }
	         System.out.println();
	         if (row != ROWS - 1) {
	            System.out.println("------------------------"); // print horizontal partition
	         }
	      }
	      System.out.println(); 
	   }
	 
	   /**
	    * Print a cell with the specified "content" 
	    * @param content either BLUE, RED or EMPTY
	    */
	   public  void printCell(int content) {
	      switch (content) {
	         case EMPTY:  System.out.print("   "); break;
	         case BLUE: System.out.print(" B "); break;
	         case RED:  System.out.print(" R "); break;
	      }
	   }
	   
	   public static int genNum()
	   {
		   return ((int)(Math.random()*(35)))+0;
	   }
}

