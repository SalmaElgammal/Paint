package eg.edu.alexu.csd.oop.draw.cs71;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

public class Triangle extends MyShape{
	public Triangle(){
		prop = new HashMap<String,Double>();
        prop.put("x1", 1.0);
        prop.put("y1", 1.0);
        prop.put("x2", 4.0);
        prop.put("y2", 4.0);
        prop.put("x3", 5.0);
        prop.put("y3", 5.0);
	}
	
	public void draw(Graphics canvas) {
        ((Graphics2D) canvas).setColor(getFillColor());
        canvas.fillPolygon(new int[] {(int) prop.get("x1").intValue(),
        		(int) prop.get("x2").intValue(),
        		(int) prop.get("x3").intValue()},
        		new int[] {(int) prop.get("y1").intValue(),
        		(int) prop.get("y2").intValue(),
        		(int) prop.get("y3").intValue()}, 3);
        ((Graphics2D) canvas).setStroke(new BasicStroke(2));
        ((Graphics2D) canvas).setColor(getColor());
        
        canvas.drawPolygon(new int[] {(int) prop.get("x1").intValue(),
        		(int) prop.get("x2").intValue(),
        		(int) prop.get("x3").intValue()},
        		new int[] {(int) prop.get("y1").intValue(),
        		(int) prop.get("y2").intValue(),
        		(int) prop.get("y3").intValue()}, 3);
        
	}
}


