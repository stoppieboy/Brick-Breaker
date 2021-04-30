package Main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import menus.*;

/*
 * number of threads = 3
 * ->main
 * ->gui
 * ->paint
 */

import javax.swing.JPanel;

public class Game extends JPanel implements Runnable {
	private static final long serialVersionUID = 1L;
	
	// FRAME RATE
	private int FPS = 60;
	private double averageFPS;	
			
	// WINDOW SPECS
	public static int windowWidth = 1100, windowHeight = 695;
	private final Color windowColor = Color.black;
	
	// BALL INITIALS
	private static final int ballX = 200;
	private static final int ballY = 600;
	
	// GAME STATE
	protected static boolean running = false;
	
	// STAGE NUMBER
	private int stage_number = 1;
	
	Frame frame;
	Ball ball;
	Brick brick;
	Stage stage;
	KeyBindings key;
	Bar bar;
	Menu menu;
	
	Dimension screenSize = new Dimension(windowWidth, windowHeight);
	
	private Thread thread;
	
	private BufferedImage image;
	private Graphics2D g;
	
	public Game() {
		super();
		this.setPreferredSize(screenSize);
		this.setBackground(windowColor);
		
		stage = new Stage(stage_number);
		ball = new Ball(ballX, ballY);
		bar = new Bar();
		key = new KeyBindings(this, bar);
//		menu = new Menu();
		
		frame = new Frame();
		frame.add(this);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
				
	}
	
	public void addNotify() {
		super.addNotify();
		
		if(thread == null) {
			thread = new Thread(this);
			thread.start();
		}
	}
	
	@Override
	public void run() {
		
		running = true;
		System.out.println("here too");
		
		image = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
		g = (Graphics2D) image.getGraphics();
		
		long startTime;
		long waitTime;
		long URDTimeMillis;// Update Render Draw time in milliseconds
		long totalTime = 0;
		
		int frameCount = 0;
		int maxFrameCount = 30;
		
		long targetTime = 1000 / FPS;
		
		// GAME LOOP
		while(running) {
			
			startTime = System.nanoTime();
			
			this.update();
			this.render();
			this.draw();
			
			URDTimeMillis = (System.nanoTime() - startTime) / 1000000;
			waitTime = targetTime - URDTimeMillis;
			
			if(waitTime >= 0) {
				try {
					Thread.sleep(waitTime);
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("Something wrong in the sleep function");
				}
			}
			
			totalTime += System.nanoTime() - startTime;
			frameCount++;
			
			if(frameCount == maxFrameCount) {
				averageFPS = 1000.0 / ((totalTime / frameCount) / 1000000);
				frameCount = 0;
				totalTime = 0;
			}
		}
		
		
		System.out.println("EXITING...");
//		menus.
		System.exit(0);
		
	}
	
	public void update() {
		ball.check_collision(bar, stage.brick);
		ball.Move();
	}
	
	public void render() {
		super.paintComponent(g);
		
		Thread.currentThread().setName("paint");
		ball.Draw(g);
		bar.Draw(g);
		stage.Draw(g);
		g.setColor(Color.blue);
		g.drawString("FPS: " + averageFPS, 10, 10);
	}
	
	public void draw() {
		Graphics g2 = this.getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	
//	public void setGameState(boolean state) {
//		running = state;
//	}
	
}
