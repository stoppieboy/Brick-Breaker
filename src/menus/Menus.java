package menus;

import java.awt.Color;
import java.awt.Graphics2D;

public class Menus {
	
	protected Color background_color = Color.black;
	
	public Menus() {
	}
	
	public void Draw(Graphics2D g) {
		
	}
	
	protected void setBackground(Color color) {
		background_color = color;
	}
	
	protected Color getBackground() {
		return background_color;
	}
	
}
