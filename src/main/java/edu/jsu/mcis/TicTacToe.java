package edu.jsu.mcis;

import java.io.*;

public class TicTacToe 
{		
	public enum Mark{XMARK,OMARK,EMPTY};
	public enum gameStatus{XWIN,OWIN,TIE,ONGOING};
	public boolean xturn = true;
	private Mark[][] board = new Mark[3][3];

	
	public static void main(String[] args) 
	{

	}
	
	public TicTacToe() {
		clearBoard();
	}

	public void clearBoard()
	{
		for(int row = 0; row < 3; row++)
		{
			for(int col = 0; col < 3; col++)
			{
				board[row][col] = Mark.EMPTY;
				
			}
		}xturn = true;
	}
	
	public void setMark(int x, int y)
	{	
		if (board[x][y] == Mark.EMPTY)
		{
			if (xturn == true)
			{
				board[x][y] = Mark.XMARK;
				xturn = false;
			}
			else if (xturn == false)
			{
				board[x][y] = Mark.OMARK;
				xturn = true;
			}
		}
		else System.out.println("Choose another Space!");
	}
	
	public Mark getMark(int x, int y)
	{
		Mark mark = board[x][y];
		System.out.println(mark);
		return mark;
	}
	
	public gameStatus checkForWin()
	{
		boolean h = false;
		boolean v = false;
		boolean d = false;
		boolean d1 = false;
		
		for(int i=0; i<3; i++) 
		{
			h = board[i][0].equals(board[i][1]) && board[i][0].equals(board[i][2]);
			v = board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i]);
			if(h)
			{
				Mark mark = getMark(i,0);
				if (mark == Mark.XMARK) return gameStatus.XWIN;
				else if (mark == Mark.OMARK) return gameStatus.OWIN;
				else return gameStatus.ONGOING;
			}
			else if (v)
			{
				Mark mark = getMark(0,i);
				if (mark == Mark.XMARK) return gameStatus.XWIN;
				else if (mark == Mark.OMARK) return gameStatus.OWIN;
				else return gameStatus.ONGOING;
			}
			
		}
		d = board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]);
		d1 = board[0][2].equals(board[1][1]) && board[1][1].equals(board[0][2]);
		
		if(d)
			{
				Mark mark = getMark(0,0);
				if (mark == Mark.XMARK) return gameStatus.XWIN;
				else if (mark == Mark.OMARK) return gameStatus.OWIN;
				else return gameStatus.ONGOING;
			}
		else if (d1)
			{
				Mark mark = getMark(0,2);
				if (mark == Mark.XMARK) return gameStatus.XWIN;
				else if (mark == Mark.OMARK) return gameStatus.OWIN;
				else return gameStatus.ONGOING;
			}
		else if (!d && !d1 && !h && !v) return gameStatus.TIE;
	
		else return gameStatus.ONGOING;
	}
	
}