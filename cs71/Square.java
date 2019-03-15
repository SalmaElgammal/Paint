package eg.edu.alexu.csd.oop.draw.cs71;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

public class Square extends MyShape{
	public Square() {
		prop = new HashMap<String,Double>();
        prop.put("x", 0.0);
        prop.put("y", 0.0);
        prop.put("side", 0.0);
	}
	public void draw(Graphics canvas) {
        ((Graphics2D) canvas).setColor(getFillColor());
        
        canvas.fillRect((int) prop.get("x").intValue(),
        		(int) prop.get("y").intValue(),
        		(int) prop.get("side").intValue(),
        		(int) prop.get("side").intValue());
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        
        canvas.drawRect((int) prop.get("x").intValue(),
        		(int) prop.get("y").intValue(),
        		(int) prop.get("side").intValue(),
        		(int) prop.get("side").intValue());
        
	}
}


