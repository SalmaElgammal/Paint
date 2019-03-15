package eg.edu.alexu.csd.oop.draw.cs71;
import eg.edu.alexu.csd.oop.draw.Shape;

public class Pair {
	boolean action; //true for add & false for remove
	Shape shape;
	public Pair(boolean s,Shape sh) {
		action=s;
		shape=sh;
	}
}