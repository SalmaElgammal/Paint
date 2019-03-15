package eg.edu.alexu.csd.oop.draw.cs71;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public class Circle extends MyShape {

	public Circle() {
		prop = new HashMap<>();
		prop.put("radius", 0.0);
	}

	public void draw(Graphics canvas) {
		int radius = Double.valueOf(this.prop.get("radius")).intValue();
		((Graphics2D) canvas).setColor(getFillColor());
		((Graphics2D) canvas).fillOval((int) this.p.getX(),
				(int) this.p.getY(), radius, radius);
		((Graphics2D) canvas).setColor(getColor());
		((Graphics2D) canvas).drawOval((int) this.p.getX(),
				(int) this.p.getY(), radius, radius);
	}
	public Object clone(){
        MyShape r = new Circle();
        r.setColor(c);
        r.setFillColor(fc);
        r.setPosition(p);
        Map newprop = new HashMap<>();
        for (Map.Entry s: prop.entrySet())
            newprop.put(s.getKey(), s.getValue());
        r.setProperties(newprop);
        return r;
    }
}
