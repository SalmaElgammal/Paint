package eg.edu.alexu.csd.oop.draw.cs71;

import eg.edu.alexu.csd.oop.draw.Shape;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public class MyShape implements Shape {

	public Point p;
	public Map<String, Double> prop;
	public Color c;
	public Color fc;

	@Override
	public void setPosition(Point position) {
		// TODO Auto-generated method stub
		p = position;
	}

	@Override
	public Point getPosition() {
		// TODO Auto-generated method stub
		return p;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		// TODO Auto-generated method stub
		prop = properties;
	}

	@Override
	public Map<String, Double> getProperties() {
		// TODO Auto-generated method stub
		return prop;
	}

	@Override
	public void setColor(Color color) {
		// TODO Auto-generated method stub
		c = color;
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return c;
	}

	@Override
	public void setFillColor(Color color) {
		// TODO Auto-generated method stub
		fc = color;
	}

	@Override
	public Color getFillColor() {
		// TODO Auto-generated method stub
		return fc;
	}

	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub

	}
	public Object clone() throws CloneNotSupportedException {
		Object o = new Object();
		return o;
	}


}
