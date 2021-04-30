package Main;

import java.awt.Color;
import java.awt.Graphics;

public class Brick {
	
	private int WIDTH, HEIGHT;
	private Color COLOR = Color.white;
	
	public Brick(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
	}
	
	public void Draw(int x, int y, Graphics g) {
		g.setColor(COLOR);
		g.fillRect(x, y, WIDTH, HEIGHT);
	}
	
	public void setColor(Color color) {
		COLOR = color;
	}
}
