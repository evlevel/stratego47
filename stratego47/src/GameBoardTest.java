import static org.junit.Assert.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GameBoardTest {

	@Test
	public void testRankings1() {
		GameBoard tester = new GameBoard();

		// test string equivalent of pieceRankings

		assertEquals("", tester.pieceRankings.get(0), "Mar");
		assertEquals("", tester.pieceRankings.get(1), "Gen");
		assertEquals("", tester.pieceRankings.get(2), "Col");
		assertEquals("", tester.pieceRankings.get(3), "Maj");
		assertEquals("", tester.pieceRankings.get(4), "Cap");
		assertEquals("", tester.pieceRankings.get(5), "Lie");
		assertEquals("", tester.pieceRankings.get(6), "Ser");
		assertEquals("", tester.pieceRankings.get(7), "Min");
		assertEquals("", tester.pieceRankings.get(8), "Sco");
		assertEquals("", tester.pieceRankings.get(9), "Spy");
		assertEquals("", tester.pieceRankings.get(10), "Bom");
		assertEquals("", tester.pieceRankings.get(11), "Fla");
	}

	@Test
	public void testLocation()

	// checks for locations of pieces on board
	{
		GameBoard tester = new GameBoard();

		tester.arrangePieces();
		assertEquals("test for first location of red", "Sco", tester.board[3][0]);
		assertEquals("test for first location of blue", "Mar", tester.board[6][0]);
		assertEquals("test for first move by red", null, tester.board[4][0]);
		assertEquals("test for first move by blue", null, tester.board[5][0]);
	}

	@Test
	public void testMove1() // Marshal2 (Blue) captures Scout1(Red)
	{
		GameBoard tester = new GameBoard();

		tester.arrangePieces();
		tester.fromRow = 3;
		tester.fromColumn = 0;
		tester.toRow = 4;
		tester.toColumn = 0;
		// tester.makeMove(1);
		tester.fromRow = 6;
		tester.fromColumn = 0;
		tester.toRow = 5;
		tester.toColumn = 0;
		//tester.makeMove(1);
		tester.fromRow = 4;
		tester.fromColumn = 0;
		tester.toRow = 5;
		tester.toColumn = 0;
		//tester.makeMove(1);
		assertEquals("test for piece on board after capture", "Mar", tester.board[5][0]);

	}

}
