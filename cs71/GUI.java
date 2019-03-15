package eg.edu.alexu.csd.oop.draw.cs71;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class GUI extends Canvas implements MouseInputListener,
		MouseMotionListener {

	/**
	 * @param args
	 */
	boolean pressed = false;
	int currentx, currenty;
	static int firstx = 0, firsty = 0;
	static int currentTool;

	public void paint(Graphics g) {

		Map<String, Double> prop;
		prop = new HashMap<>();
		Point p = new Point(300, 50);
		Rectangle r = new Rectangle();
		r.setColor(Color.red);
		r.setFillColor(Color.white);
		prop = new HashMap<>();
		prop.put("height", 20.0);
		prop.put("width", 60.0);
		p = new Point(50, 50);
		r.setPosition(p);
		r.setProperties(prop);
		if (pressed) {
			r.draw(g);
		} else {
			g.clearRect((int) r.getPosition().getX() - 3, (int) r.getPosition()
					.getY() - 3, (int) r.getProperties().get("width")
					.intValue() + 10, (int) r.getProperties().get("height")
					.intValue() + 10);
		}

	}

	public GUI() {
		addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				pressed = false;
				Graphics g = getGraphics();
				if (currentTool == 1) {
					paintCircle(g);
				} else {
					paintRectangle(g);
				}
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				pressed = true;
				currentx = e.getX();
				currenty = e.getY();
				firstx = e.getX();
				firsty = e.getY();
				Graphics g = getGraphics();
				if (currentTool == 1) {
					paintCircle(g);
				} else {
					paintRectangle(g);
				}

			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				pressed = false;
				Graphics g = getGraphics();
				paintCircle(g);
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent arg0) {
				// TODO Auto-generated method stub

			}
		});
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {

			}

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub

				currentx = e.getX();
				currenty = e.getY();
				Graphics g = getGraphics();
				g.clearRect(firstx, firsty, currentx, currenty);
				if (currentTool == 1) {
					paintCircle(g);
				} else {
					paintRectangle(g);
				}
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		JFrame jf = new JFrame("Shapes");
		GUI gui = new GUI();
		JButton jb = new JButton("circle");
		jb.setVisible(true);
		jb.setBounds(5, 5, 50, 30);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				currentTool = 1;

			}
		});
		JButton rectButton = new JButton("Rectangle");
		rectButton.setVisible(true);
		rectButton.setBounds(60, 5, 50, 30);
		rectButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				currentTool = 2;

			}
		});
		jf.setSize(500, 500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(jb);
		jf.add(rectButton);
		jf.add(gui);

	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	public void paintCircle(Graphics g) {
		Map<String, Double> prop;
		prop = new HashMap<>();
		Point p = new Point(0, 0);
		Circle c = new Circle();
		c.setColor(Color.red);
		c.setFillColor(Color.white);
		prop = new HashMap<>();
		prop.put("radius", 40.0);
		c.setProperties(prop);
		if (pressed) {
			if (currentx < firstx && currenty > firsty) {
				p.setLocation(currentx, firsty);
				c.setPosition(p);
				prop.put("radius", (double) firstx - currentx);
				c.draw(g);
			}
			if (currenty < firsty && currentx > firstx) {
				p.setLocation(firstx, currenty);
				c.setPosition(p);
				prop.put("radius", (double) currentx - firstx);
				c.draw(g);
			}
			if (currenty < firsty && currentx < firstx) {
				p.setLocation(currentx, currenty);
				c.setPosition(p);
				prop.put("radius", (double) firstx - currentx);
				c.draw(g);
			} else {
				p.setLocation(firstx, firsty);
				c.setPosition(p);
				prop.put("radius", (double) currenty - firsty);
				c.draw(g);
			}
		}
	}

	public void paintRectangle(Graphics g) {
		Map<String, Double> prop;
		prop = new HashMap<>();
		Point p = new Point(0, 0);
		Rectangle r = new Rectangle();
		r.setColor(Color.blue);
		r.setFillColor(Color.cyan);
		prop = new HashMap<>();
		prop.put("height", 0.0);
		prop.put("width", 0.0);
		r.setProperties(prop);
		if (pressed) {
			if (currenty < firsty && currentx < firstx) {
				p.setLocation(currentx, currenty);
				r.setPosition(p);
				prop.put("width", (double) firstx - currentx);
				prop.put("height", (double) firsty - currenty);
				r.draw(g);
			} else if (currentx < firstx && currenty > firsty) {
				p.setLocation(currentx, firsty);
				r.setPosition(p);
				prop.put("width", (double) firstx - currentx);
				prop.put("height", (double) currenty - firsty);
				r.draw(g);
			} else if (currenty < firsty && currentx > firstx) {
				p.setLocation(firstx, currenty);
				r.setPosition(p);
				prop.put("width", (double) currentx - firstx);
				prop.put("height", (double) firsty - currenty);
				r.draw(g);
			} else if (currenty > firsty && currentx > firstx) {
				p.setLocation(firstx, firsty);
				r.setPosition(p);
				prop.put("height", (double) currenty - firsty);
				prop.put("width", (double) currentx - firstx);
				r.draw(g);
			}
		}
	}
}
