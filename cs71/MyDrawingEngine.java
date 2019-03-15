package eg.edu.alexu.csd.oop.draw.cs71;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

import com.google.gson.Gson;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;

public class MyDrawingEngine implements DrawingEngine {

	List<Shape> allShapes = new ArrayList<>();
	boolean[] operations = new boolean[500];
	Stack<Shape> added = new Stack<>();
	Stack<Shape> removed = new Stack<>();
	Stack<Shape> undone = new Stack<>();
	int currentIndex = -1;
	int undos = 0;
	// Shape removed;
	Graphics c;

	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub
		c = canvas;
		for (int i = 0; i < allShapes.size(); i++) {
			allShapes.get(i).draw(c);
		}
	}

	@Override
	public void addShape(Shape shape) {
		// TODO Auto-generated method stub
		allShapes.add(shape);
		added.push(shape);
		currentIndex++;
		if (currentIndex >= 0 && currentIndex < 500) {
			operations[currentIndex] = true;
		}

	}

	@Override
	public void removeShape(Shape shape) {
		// TODO Auto-generated method stub
		allShapes.remove(shape);
		removed.push(shape);
		currentIndex++;
		if (currentIndex >= 0 && currentIndex < 500) {
			operations[currentIndex] = false;
		}

	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// TODO Auto-generated method stub
		for (int i = 0; i < allShapes.size(); i++) {
			if (allShapes.get(i) == oldShape) {
				allShapes.remove(i);
				allShapes.add(i, newShape);
				break;
			}
		}
	}

	@Override
	public Shape[] getShapes() {
		// TODO Auto-generated method stub
		int size = allShapes.size();
		Shape[] arr = new Shape[size];
		for (int i = 0; i < size; i++) {
			arr[i] = allShapes.get(i);
		}
		return arr;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		java.util.List<Class<? extends Shape>> list = new LinkedList<Class<? extends Shape>>();
		list.add(Circle.class);
		list.add(Ellipse.class);
		list.add(Line.class);
		list.add(Square.class);
		list.add(Rectangle.class);
		list.add(Triangle.class);

		String[] path = System.getProperty("java.class.path").split(
				"" + File.pathSeparatorChar);
		try {
			for (int i = 0; i < path.length; i++) {
				if (!path[i].endsWith(".jar"))
					continue;
				JarInputStream jarFile = new JarInputStream(
						new FileInputStream(path[i]));
				JarEntry jarEntry;
				while ((jarEntry = jarFile.getNextJarEntry()) != null) {
					if ((jarEntry.getName().endsWith(".class"))) {
						String className = jarEntry.getName().replace('/', '.')
								.replaceAll(".class", "");
						Class<?> myclass = null;
						try {
							myclass = Class.forName(className);
						} catch (Throwable e) {
							continue;
						}
						if (className.indexOf("$") != -1)
							continue;
						int modifer = myclass.getModifiers();
						if (Modifier.isAbstract(modifer)
								|| Modifier.isInterface(modifer))
							continue;
						Class<?>[] interfaces = myclass.getInterfaces();
						for (int k = 0; k < interfaces.length; k++) {
							if (interfaces[k].getName().equals(
									"eg.edu.alexu.csd.oop.draw.Shape")) {
								list.add((Class<? extends Shape>) myclass);
								break;
							}
						}
					}
				}
				jarFile.close();
			}
		} catch (Exception t) {
			throw new RuntimeException("Can not find plugins");
		}
		return list;

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		try {
			if (currentIndex >= 0 && currentIndex < 500 && undos < 20) {
				if (operations[currentIndex] == true) {
					Shape lastAdded = added.pop();
					this.removeShape(lastAdded);
					undone.push(lastAdded);
				} else {
					Shape lastRemoved = removed.pop();
					this.addShape(lastRemoved);
					undone.push(lastRemoved);
				}

				undos++;
				currentIndex--;
			}
		} catch (Exception e) {

		}
	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub
		// currentIndex++;
		if (currentIndex >= 0 && currentIndex < 500 && undos > 0 && undos < 20) {
			if (operations[currentIndex] == true) {
				this.addShape(undone.pop());
			} else if (operations[currentIndex] == false) {
				this.removeShape(undone.pop());
			}
			undos--;
		}

	}

	@Override
	public void save(String path) {
		String gson = new Gson().toJson(allShapes);
		
		try {
			FileWriter fw = new FileWriter(path);
			PrintWriter pw = new PrintWriter(fw);
			pw.println(gson);
			pw.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		try {
			allShapes = gson.fromJson(new FileReader(path), List.class);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
