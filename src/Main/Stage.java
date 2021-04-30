package Main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Stage {
	public static String stage_file;
	
	private int row;
	private int col;
	
	private int brick_width;
	private int brick_height;
	
	private int brickSpace_X = 940;
	private int brickSpace_Y = 300;
	
	private int x_offset = 80;
	private int y_offset = 50;
	
	private boolean[][] layout;
	
	Brick brick;
	
	public Stage(int stage_number) {
		
		stage_file = "res/Stages/stage_"+stage_number+".txt";
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(stage_file));
			
			row = Integer.parseInt(br.readLine());
			col = Integer.parseInt(br.readLine());
			
			br.close();
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		layout = new boolean[row][col];
		
		brick_width = brickSpace_X/col;
		brick_height = brickSpace_Y/row;
		
		brick = new Brick(brick_width, brick_height);
		System.out.println("here in stage");
	}
	
	public void Draw(Graphics2D g) {
		for(int i = 0; i < layout.length; i++) {
			for(int j = 0; j < layout[0].length;j++) {
				if(!layout[i][j])
					brick.Draw(j*brick_width+80, i*brick_height+50,g);
				g.setStroke(new BasicStroke(3));
				g.setColor(Color.BLACK);
				g.drawRect(j*brick_width+x_offset, i*brick_height+y_offset, brick_width, brick_height);
			}
		}
	}
	
	public void setBrickSpace(int x, int y) {
		brickSpace_X = x;
		brickSpace_Y = y;
	}
	
	public void setOffsets(int x, int y) {
		x_offset = x;
		y_offset = y;
	}
}
