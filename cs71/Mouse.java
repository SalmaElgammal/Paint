package eg.edu.alexu.csd.oop.draw.cs71;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

public class Mouse implements MouseMotionListener, MouseInputListener{

	/**
	 * @param args
	 */
	int mx;
	int my;
	public static boolean mousedragged, mouseclicked;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame jf = new JFrame("Shapes");
		GUI gui = new GUI();
		jf.setSize(500, 500);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		while (mouseclicked){
			
		}
		
		jf.add(gui);
	}
	public void paint(Graphics g){
		Rectangle r = new Rectangle();
		if(mousedragged){
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, r.prop.get("height").intValue(), r.prop.get("width").intValue() );
			g.setColor(Color.cyan);
			g.drawRect(mx, my, 20, 20 );
			
		}else{
			g.setColor(Color.cyan);
			g.fillRect(0, 0, r.prop.get("height").intValue(), r.prop.get("width").intValue() );
			g.setColor(Color.BLACK);
			g.drawRect(mx, my, 20, 20 );
			
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		mx = e.getX();
		my = e.getY();
		mousedragged = true;
		e.consume();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mx = e.getX()-10;
		my = e.getY()-10;
		mousedragged = false;
		e.consume();
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
		mouseclicked=true;
		
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		mouseclicked = false;
		
	}

}
