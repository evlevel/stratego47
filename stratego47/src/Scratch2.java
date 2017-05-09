
public class Scratch2  {

	public Scratch2() {
		
	}
	
	
	public void placeSimulatedPieces(Player p) {
		for (int i = 0; i < 40; i++) {

			int row = (int)(Math.random() + 1) / 10;
			if (p.color == 2)
				row = row + 6;
			
//			int row = i / 10;
//			if (p.color == 2)
//				row = row + 6;

			int column = i % 10;
			
			/**double random = Math. random() * 50 + 1; 
			 * or int random = (int )(Math. random() * 50 + 1);*/

//			board[row][column] = p.pieces.get(i);
//			colors[row][column] = p.color;

			// ask use where to place next piece p.pieces.get(i)
			// StdOut.println(p.color + "-" + p.pieces.get(i));

			// print out the piece to be placed

			// read the row and column of placement
			 boolean inputNeeded = false;
			 /**
			  * try/ catch to defend against bad integer input
			  */ 
			 do {
			 try {
			
			// int row = StdIn.readInt();
			
			// int column = StdIn.readInt();
			 StdIn.readLine();
			
//			 board[row][column] = p.pieces.get(i);
//			
//			 colors[row][column] = p.color;
			
			 inputNeeded = false;
			 } catch (ArrayIndexOutOfBoundsException ex) {
			 StdOut.println("Bad Location");
			 inputNeeded = true;
			 }
			
			 } while (inputNeeded);

			// printBoard();

			// put that piece in board [row] [column] array

			// put player color into same colors [row] [column]

		}

	}

	public static void main(String[] args) {
		

	}

}
