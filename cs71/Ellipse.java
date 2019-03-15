package eg.edu.alexu.csd.oop.draw.cs71;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;

public class Ellipse extends MyShape {

	public Ellipse() {
		prop = new HashMap<>();
		prop.put("major", 0.0);
		prop.put("minor", 0.0);
	}

	public void draw(Graphics canvas) {
		int major = this.prop.get("major").intValue();
		int minor = this.prop.get("minor").intValue();
		((Graphics2D) canvas).setStroke(new BasicStroke(2));
		
		((Graphics2D) canvas).setColor(getFillColor());
		((Graphics2D) canvas).fillOval((int) this.p.getX(),
				(int) this.p.getY(), major, minor);
		((Graphics2D) canvas).setColor(getColor());
		((Graphics2D) canvas).drawOval((int) this.p.getX(),
				(int) this.p.getY(), major, minor);
		


	}

	public Object clone() {
		MyShape r = new Ellipse();
		r.setColor(c);
		r.setFillColor(fc);
		r.setPosition(p);
		Map newprop = new HashMap<>();
		for (Map.Entry s : prop.entrySet())
			newprop.put(s.getKey(), s.getValue());
		r.setProperties(newprop);
		return r;
	}
}
