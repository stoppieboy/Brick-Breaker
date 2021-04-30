package Main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	
	private final static int radius = 10;
	private final static int diameter = radius*2;
	private static float ballX;
	private static float ballY;
	private static float speedX = -2.5f;
	private static float speedY = -3;
	private Color ball_color = Color.red;
	
	public Ball(int x, int y) {
		ballX = x;
		ballY = y;
//		System.out.println(Thread.currentThread().getName());
	}
	
	public Ball() {
		System.out.println("Setting default ball co-ordinates....");
		ballX = 200;
		ballY = 600;
	}
	
	public void Draw(Graphics2D g) {
		
		g.setColor(ball_color);
		g.fillOval((int)ballX, (int)ballY, radius*2, radius*2);
//		System.out.println(Thread.currentThread().getName());
	}
	
	public void check_collision(Bar bar, Brick brick) {
		this.wall_collision();
		this.bar_collision(bar);
		this.brick_collision(brick);
	}
	
	public void bar_collision(Bar bar) {
		if(new Rectangle((int)bar.getX(), (int)bar.getY(), bar.getLength(), bar.getBreadth()).intersects(new Rectangle((int)ballX, (int)ballY, diameter, diameter)))
			speedY = -speedY;
	}
	
	public void brick_collision(Brick brick) {
		
	}
	
	public void wall_collision() {
		if(ballX < 0 || ballX > Game.windowWidth-diameter)
			speedX = -speedX;
		if(ballY < 0)
			speedY = -speedY;
		
		// GAMEOVER
		if(ballY > Game.windowHeight-diameter)
			System.exit(0);
	}
	
	public void Move() {
		
		ballX += speedX;
		ballY += speedY;
//		System.out.println(Thread.currentThread().getName());
	}
	
	public int getX() {
		return (int)ballX;
	}
	
	public int getY() {
		return (int)ballY;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public float speedX() {
		return speedX;
	}
	
	public float speedY() {
		return speedY;
	}
	
	public void setColor(Color color) {
		ball_color = color;
	}
}
