
import java.util.Collections;

public class ShufflePlayer extends Player {

	public ShufflePlayer(int c) {
		super(c);
		Collections.shuffle(pieces);
	}
	

}
