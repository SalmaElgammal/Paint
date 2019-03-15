package eg.edu.alexu.csd.oop.draw.cs71;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.awt.*;

public class Line extends MyShape {

	public Line() {
		prop = new HashMap<>();
		prop.put("x1", 0.0);
		prop.put("y1", 0.0);
		prop.put("x2", 0.0);
		prop.put("y2", 0.0);
	}
	public void draw(Graphics canvas) {
		((Graphics2D) canvas).setColor(getColor());
	}
	public Object clone(){
        MyShape r = new Line();
        r.setColor(c);
        r.setPosition(p);
        Map newprop = new HashMap<>();
        for (Map.Entry s: prop.entrySet())
            newprop.put(s.getKey(), s.getValue());
        r.setProperties(newprop);
        return r;
    }
		
	
}
