package Main;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class KeyBindings{
	
	AbstractAction left;
	AbstractAction right;
	AbstractAction exit;
	
	boolean keyAlreadyClicked = false;
	
	Bar bar;
	
	public KeyBindings(JPanel panel, Bar player1_object) {
		bar = player1_object;
		left = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("LEFT");
				bar.moveLeft();	
//				System.out.println(Thread.currentThread().getName());
			}
			
		};
		
		right = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("RIGHT");
				bar.moveRight();
			}
			
		};
		
		exit = new AbstractAction() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Game.running = false;
//				System.out.println("EXIT");
//				System.exit(0);
			}
			
		};
		
		
		panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("LEFT"), "moveleft");
		panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("RIGHT"), "moveright");
		panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ESCAPE"), "escExit");
		
		panel.getActionMap().put("moveleft", left);
		panel.getActionMap().put("moveright", right);
		panel.getActionMap().put("escExit", exit);
		
	}
	
}
