package edu.jsu.mcis;

import org.junit.*;
import static org.junit.Assert.*;

public class TicTacToeTest {
	private TicTacToe t;
	
	@Before
	public void setUp() {
		t = new TicTacToe();
	}
	
	@Test
	public void testInitialBoardIsEmpty() {
		t.clearBoard();
		for(int row = 0; row < 3; row++)
		{
			for (int col = 0; col < 3; col++)
			{
				assertEquals(TicTacToe.Mark.EMPTY, t.getMark(row,col));
			}
		}
	};
	
	@Test
	public void testMarkXInUpperRightCorner() 
	{
		t.clearBoard();		
		t.setMark(0,2);
		assertEquals(TicTacToe.Mark.XMARK,t.getMark(0,2));
	};
	
	@Test
	public void testMarkOInBottomLeftCorner() 
	{
		t.clearBoard();
		t.setMark(0,0);
		t.setMark(2,0);
		assertEquals(TicTacToe.Mark.OMARK,t.getMark(2,0));
	};
	
	@Test
	public void testUnableToMarkOverExistingMark() 
	{
		t.clearBoard();
		t.setMark(2,0);
		t.setMark(2,0);
		assertEquals(TicTacToe.Mark.XMARK,t.getMark(2,0));
	};
	
	@Test
	public void testGameIsNotOverAfterTheFirstMark() {
		t.clearBoard();
		t.setMark(0,1);
		assertEquals(TicTacToe.gameStatus.ONGOING,t.checkForWin());
	};
	
	@Test
	public void testGameIsWonByXHorizontallyAcrossTopRow() {
		t.clearBoard();
		t.setMark(0,0);
		t.setMark(1,1);
		t.setMark(0,1);
		t.setMark(2,1);
		t.setMark(0,2);
		t.checkForWin();
		assertEquals(TicTacToe.gameStatus.XWIN,t.checkForWin());

	};
	
	@Test
	public void testGameIsOverByTieIfAllLocationsAreFilled() {
		t.clearBoard();
		t.setMark(0,0);
		t.setMark(0,1);
		t.setMark(0,2);
		t.setMark(1,1);
		t.setMark(1,0);
		t.setMark(2,0);
		t.setMark(1,2);
		t.setMark(2,2);
		t.setMark(2,1);
		t.checkForWin();
		assertEquals(TicTacToe.gameStatus.TIE,t.checkForWin());
	};	
};