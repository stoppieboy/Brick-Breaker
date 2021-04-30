package Main;

import java.awt.Color;
import java.awt.Graphics;

public class Bar {
	
	private final int bar_initPosition = 500;
	
	private float x;
	private final int y =  Game.windowHeight-11;
	private final float move_speed = 15;
	private final int LENGTH = 120;
	private final int BREADTH = 10;
	private Color bar_color = Color.RED;
	
	public Bar() {
		x = bar_initPosition;
	}
	
	public void Draw(Graphics g) {
//		System.out.println(Thread.currentThread().getName());
		g.setColor(bar_color);
		g.fillRect((int)x, y, LENGTH, BREADTH);
	}
	
	public void moveLeft() {
//		System.out.println(Thread.currentThread().getName());
		if(x < 0)
			x = 0;
		else {
			if(x - move_speed < 0)
				x = 0;
			else
				x -= move_speed;
		}
	}
	
	public void moveRight() {
//		System.out.println(Thread.currentThread().getName());
		if(x > Game.windowWidth-LENGTH)
			x = Game.windowWidth-LENGTH;
		else {
			if(x + move_speed > Game.windowWidth-LENGTH)
				x = Game.windowWidth-LENGTH;
			else
				x += move_speed;
		}
	}
	
	public int getX() {
		return (int)x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getLength() {
		return LENGTH;
	}
	
	public int getBreadth() {
		return BREADTH;
	}
	
	public void setColor(Color color) {
		bar_color = color;
	}
}
