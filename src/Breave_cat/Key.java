package Breave_cat;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Key extends KeyAdapter {
	private GameOb gameOb ;
	
	public Key(GameOb g) {
		this.gameOb=g;
	}
	@Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		gameOb.getPlayer().keyPressed(e) ;
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		super.keyReleased(e);
		gameOb.getPlayer().keyReleased(e) ;
		
	}

	public static void main(String[] args) {
		

	}

}
