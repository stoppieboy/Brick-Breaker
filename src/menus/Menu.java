package menus;

//import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

public class Menu extends Menus{
	
//	PauseMenu pause;
	Graphics2D g;
//	Menus menus;
//	SettingsMenu settings;
//	StartMenu startMenu;
	
	public Menu(Graphics2D g) {
		this.g = g;
//		menus = new Menus();
	}
	
	public void pauseMenu() {
		super.Draw(g);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("PAUSED", 150, 150);
	}
	
	public void startMenu() {
		super.Draw(g);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("START MENU", 150, 150);
	}
	
	public void settingsMenu() {
		super.Draw(g);
		g.setFont(new Font("serif", Font.BOLD, 25));
		g.drawString("SETTINGS MENU", 150, 150);
	}
	
//	public void setGraphics(Graphics2D g) {
//		this.g = g;
//	}
	
}
