import java.util.ArrayList;
import java.util.Collections;

public class Player {
	
	/**
	 * holds reference for other classes 
	 */
	public int color;

	public ArrayList<String> pieces = new ArrayList<>();

	public Player(int c) {
		color = c;
		pieces.add("Mar"); // #1 == 1 index 0
		pieces.add("Gen"); // #2 == 1
		pieces.add("Col");// #3 == 2
		pieces.add("Col");
		pieces.add("Maj"); // #4 == 3
		pieces.add("Maj");
		pieces.add("Maj");
		pieces.add("Cap"); // #5 == 4
		pieces.add("Cap");
		pieces.add("Cap");
		pieces.add("Cap");
		pieces.add("Lie");// #6 == 4
		pieces.add("Lie");
		pieces.add("Lie");
		pieces.add("Lie");
		pieces.add("Ser");// #7 == 4
		pieces.add("Ser");
		pieces.add("Ser");
		pieces.add("Ser");
		pieces.add("Min");// #8 == 5
		pieces.add("Min");
		pieces.add("Min");
		pieces.add("Min");
		pieces.add("Min");
		pieces.add("Sco");// #9 == 8
		pieces.add("Sco");
		pieces.add("Sco");
		pieces.add("Sco");
		pieces.add("Sco");
		pieces.add("Sco");
		pieces.add("Sco");
		pieces.add("Sco");
		pieces.add("Spy");// #NA == 1
		pieces.add("Bom");// #NA == 6
		pieces.add("Bom");
		pieces.add("Bom");
		pieces.add("Bom");
		pieces.add("Bom");
		pieces.add("Bom");
		pieces.add("Fla");// #NA == 1

	}

	public void remove(String piece)
	{
		pieces.remove(piece);
	}
	
	public Move promptForMove(GameBoard board)
	{
		StdOut.print("Enter move starting at => row col: ");
		
		int fromRow = StdIn.readInt();
		
		//fromRow = Math.random()*6 +1; could i use this to move automatically?

		int fromColumn = StdIn.readInt();// read space from user

		StdIn.readLine();

		// get location of piece to move to

		StdOut.print("Enter move ending at => row col: ");
		
		int toRow = StdIn.readInt();

		int toColumn = StdIn.readInt();// read space from user

		StdIn.readLine();
		
		return new Move(fromRow,fromColumn,toRow,toColumn);

	}
	public static void main(String[] args) {

	}

}
