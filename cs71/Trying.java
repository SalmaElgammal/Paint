package eg.edu.alexu.csd.oop.draw.cs71;
import com.google.gson.Gson;

import eg.edu.alexu.csd.oop.draw.Shape;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trying {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String, Double> prop = new HashMap<>();
		MyDrawingEngine de = new MyDrawingEngine();
		
		Circle c = new Circle();
		c.setColor(Color.red);
		c.setFillColor(Color.blue);
		prop.put("radius", 100.0);
		c.setProperties(prop);
		de.addShape(c);
		
		Rectangle r = new Rectangle();
		r.setColor(Color.red);
		r.setFillColor(Color.blue);
		prop = new HashMap<>();
		prop.put("height", 100.0);
		prop.put("height", 50.0);
		c.setProperties(prop);
		de.addShape(r);
		
		System.out.println(de.allShapes.size());
		JsonEquivalent(de.allShapes);
		de.save("jsonfile.json");
		System.out.println("Undo, Now size is:");
		de.undo();
		System.out.println(de.allShapes.size());
		JsonEquivalent(de.allShapes);
		
	}
	public static void JsonEquivalent(List<Shape> allShapes){
		String gson = new Gson().toJson(allShapes);
		System.out.println(gson);
	}

}
