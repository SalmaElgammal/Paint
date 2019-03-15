package eg.edu.alexu.csd.oop.draw.cs71;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

public class Rectangle extends MyShape{
	public Rectangle(){
		prop = new HashMap<String,Double>();
        prop.put("height", 0.0);
        prop.put("width", 0.0);
	}
	
	public void draw(Graphics canvas) {
        ((Graphics2D) canvas).setColor(getFillColor());
        canvas.fillRect( (int) p.getX(),
        		(int) p.getY(),
        		(int) prop.get("width").intValue(),
        		(int) prop.get("height").intValue());
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        
        canvas.drawRect((int) p.getX(),
        		(int) p.getY(),
        		(int) prop.get("width").intValue(),
        		(int) prop.get("height").intValue());
        
	}
}


