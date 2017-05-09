
import java.util.ArrayList;

public class GameBoard
{

	/**
	 * The Stratego framework plays out a rudimentary game of Stratego.
	 */

	/** Use array list to hold temp pieceRankings */
	public ArrayList<String> pieceRankings = new ArrayList<>();

	/** Create multidimensional array of 10x10 board */
	public String[][] board = new String[10][10];

	/**
	 * 0 means no color or piece and 1 means red + 2 means blue
	 */
	public int[][] colors = new int[10][10];

	/** array with with 2 players that calls from player class to get pieces */
	public Player[] players = new Player[2];

	/**
	 * method that sets rankings of pieces and instantiates player 1 and 2 can
	 * be regular player, shuffle player, or robotPlayer
	 */
	public GameBoard()
	{
		pieceRankings.add("Mar"); // #1 == 1 index 0
		pieceRankings.add("Gen"); // #2 == 1
		pieceRankings.add("Col"); // #3 == 2
		pieceRankings.add("Maj"); // #4 == 3
		pieceRankings.add("Cap"); // #5 == 4
		pieceRankings.add("Lie");// #6 == 4
		pieceRankings.add("Ser");// #7 == 4
		pieceRankings.add("Min");// #8 == 5
		pieceRankings.add("Sco");// #9 == 8
		pieceRankings.add("Spy");// #NA == 1
		pieceRankings.add("Bom");// #NA == 6
		pieceRankings.add("Fla");// #NA == 1

		/*
		 * Marshal #1 = 1 General #2 = 1 Colonels #3 = 2 Majors #4 = 3 Captains
		 * #5 = 4 Lieutenants #6 = 4 Sergeants #7 = 4 Miners #8 = 5 Scouts #9 =
		 * 8 Spy #NA = 1 Bomb #NA = 6 Flag #NA = 1
		 */

		/* Change to introduce new players */
		// players[0] = new RobotPlayer(1);
		// players[1] = new ShufflePlayer(2);

		players[0] = new RobotPlayer(1);
		players[1] = new RobotPlayer(2);

		// players[0] = new ShufflePlayer(1);
		// players[1] = new Player(2);

	}

	/**
	 * Pulls values of pieces from player into arrays
	 */
	public void placePieces(Player p)
	{
		for (int i = 0; i < 40; i++)
		{

			int row = i / 10;
			if (p.color == 2)
				row = row + 6;

			int column = i % 10;

			board[row][column] = p.pieces.get(i);
			colors[row][column] = p.color;
		}
	}

	/**
	 * Prints board with null in open spaces to show where is left to place if
	 * players are playing Prints the board automatically if robot player or
	 * shuffle player are playing
	 */
	public void printBoard()
	{

		StdOut.println("-------------------------------------------------");
		for (int row = 0; row < 10; row++)
		{
			for (int column = 0; column < 10; column++)
			{

				if (board[row][column] != null)
				{
					StdOut.print(board[row][column]);
					StdOut.print(colors[row][column]);
				}

				else
				{
					StdOut.print("    ");
				}
				StdOut.print("-");
			}
			StdOut.println();
		}
		StdOut.println("-------------------------------------------------");
	}

	/**
	 * Calls the place pieces method on both arrays 1 for red and 2 for blue
	 */
	public void arrangePieces()
	{
		placePieces(players[0]);
		placePieces(players[1]);
	}

	public int fromRow;
	public int fromColumn;
	public int toRow;
	public int toColumn;

	public Move theMove;

	public void makeMove(int color, Move m)
	{

		/**
		 * pulls values from Move
		 */
		fromRow = m.getFromRow();
		fromColumn = m.getFromCol();
		toRow = m.getToRow();
		toColumn = m.getToCol();

		String fromPieceValue = board[fromRow][fromColumn];
		int fromColorValue = colors[fromRow][fromColumn];

		board[fromRow][fromColumn] = null;
		colors[fromRow][fromColumn] = 0;

		// what is in the to location

		String toPieceValue = board[toRow][toColumn];// assuming moving piece is
														// always higher value
		int toColorValue = colors[toRow][toColumn];

		if (toPieceValue != null)
		{
			if (pieceRankings.indexOf(fromPieceValue) <= pieceRankings.indexOf(toPieceValue))
			{

				board[toRow][toColumn] = fromPieceValue;
				colors[toRow][toColumn] = fromColorValue;

				// players[toColorValue - 1].pieces.remove(toPieceValue);
				players[color - 1].remove(toPieceValue);
				/** removes color value of piece 0 or 1 red or blue */

				/**
				 * prints out toString value of Move
				 */
				StdOut.println(m.toString());

			}

			else
			{

				board[toRow][toColumn] = toPieceValue;
				colors[toRow][toColumn] = toColorValue;

				players[color - 1].remove(fromPieceValue);
				/** removes color value of piece 1 red */

				StdOut.println("From loses" + fromPieceValue);
				StdOut.println("From loses" + players[fromColorValue - 1].pieces);
			}
		}
		else
		{
			board[toRow][toColumn] = fromPieceValue;
			colors[toRow][toColumn] = fromColorValue;

		}

	}

	public static void main(String[] args)
	{

		GameBoard board = new GameBoard(); // Create game board
		board.play(); // initiate game
		// GameBoard stats = reportStats(); // report the output
	}

	public void reportStats(Player p)
	{

		StdOut.println(/* */" has gained their opponents flag and is victorious!");

		/**
		 * pull in players arrays
		 */
		// for (int i = 0; i < p.pieces.size(); i++) {
		// StdOut.println("(wins,losses) at " + i + (RobotPlayer(1).size())
		// + "," + RobotPlayer(2).size() + ")");
		// }

		StdOut.println("\nPlayed " + theMove + " captures total.");

		/**
		 * create variables
		 */
		// StdOut.println("Won " + numWins + "/" + numPlays + "==" + 100.0 *
		// (0.0 + numWins) / numPlays + "%");

	}

	public int intAbs(int a)
	{
		if (a < 0)
			return a;
		else
			return -a;
	}

	private boolean ERROR_OUTPUT = false;
	
	public boolean moveIsValid(Move m)
	{
		if (m.getFromRow() < 0 || m.getFromRow() > 9)
		{
			if (ERROR_OUTPUT) StdOut.println("Can't move from outside board. Try again.");
			return false;
		}

		if (m.getFromCol() < 0 || m.getFromCol() > 9)
		{
			if (ERROR_OUTPUT) StdOut.println("Can't move from outside board. Try again.");
			return false;
		}

		if (m.getToRow() < 0 || m.getToRow() > 9)
		{
			if (ERROR_OUTPUT) StdOut.println("Can't move to outside board. Try again.");
			return false;
		}

		if (m.getToCol() < 0 || m.getToCol() > 9)
		{
			if (ERROR_OUTPUT) StdOut.println("Can't move to outside board. Try again.");
			return false;
		}

		if (intAbs(m.getFromRow() - m.getToRow()) + intAbs(m.getFromCol() - m.getToCol()) > 1)
		{
			if (ERROR_OUTPUT) StdOut.println("Too big of a move. Try again.");
			return false;
		}

		if (colors[m.getFromRow()][m.getFromCol()] == colors[m.getToRow()][m.getToCol()]) // same
																							// color?
		{
			if (ERROR_OUTPUT) StdOut.println("Can't strike on same color. Try again.");
			return false;
		}

		if (board[m.getFromRow()][m.getFromCol()].equals("Bom")) // moving a
																	// bomb
		{
			if (ERROR_OUTPUT) StdOut.println("Can't move a bomb. Try again.");
			return false;
		}

		if (board[m.getFromRow()][m.getFromCol()].equals("Fla"))
		{
			if (ERROR_OUTPUT) StdOut.println("Can't move the flag. Try again.");
			return false;
		}

		return true;

	}

	private void play()
	{

		arrangePieces();

		int movesNext = 1;

		while (players[0].pieces.size() > 0 && players[1].pieces.size() > 0)
		{

			this.printBoard();			
			
			StdOut.print("ENTER to continue:");
			StdIn.readLine();

			/**
			 * print move before making move?
			 */
			// StdOut.println("Robot makes random move: " + theMove);

			Move aMove = null;
			
			do
			{
				aMove = players[movesNext - 1].promptForMove(this);

				StdOut.println("Robot [" + movesNext + "] tries random move: " + aMove);
			}
			while (!moveIsValid(aMove));

			makeMove(movesNext, aMove);
			
			if (movesNext == 1)
				movesNext = 2;
			else
				movesNext = 1;
		}
	}

}
