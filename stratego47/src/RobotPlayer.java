
public class RobotPlayer extends Player
{

	public RobotPlayer(int c)
	{
		super(c);
	}

	public int randomFromTo(int start, int stop)
	{
		return start + (int) ((stop - start + 1) * Math.random());

	}

	/**
	 * Generates random move, based on free space in board
	 */
	
	public Move promptForMove(GameBoard gboard)
	{
		// while (not done) {
		// pick a piece from this.pieces
		
		while (true)
		{
			String piece = pieces.get(randomFromTo(0, pieces.size() - 1));
			// replace 0 with random from
			// 0..pieces.size()-1
			// search for piece in gboard.board

			for (int r = 0; r < 10; r++)
			{
				for (int c = 0; c < 10; c++)
				{
					if (hasntVisited[r][c] && piece.equals(gboard.board[r][c]))
					{
						if (gboard.colors[r][c] == color)
						{
							/**
							 * if the randomly found piece is found at row/
							 * column location then...
							 */
							hasntVisited[r][c] = false;
							
							int inc;
							if (color == 1) // color 1 moves down, increasing r)
							{
								inc = +1;
							}
							else
								inc = -1; // color 2 moves up, decreasing r)
							
							// should try moving left and right, too

							if (0 > r + inc || 9 < r + c) // if off board, flip move direction
								inc = -inc;

							Move move = new Move(r, c, r + inc, c);

							return move;
						}

					}
				}
			}
			
			clearVisited();
			return new Move (0,0,0,0); // invalid, but will allow more random Move
		}
		

	}
	// find the square (row,col) it sits on
	// check if this piece can be moved forward legally
	// if so, that's the move
	//

}
