package Breave_cat;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Mouse extends MouseAdapter {
	private GameOb gameOb ;
	private Camera camera ;
	
	public Mouse(Camera camera,GameOb gameOb) {
		this.camera=camera;
		this.gameOb=gameOb;
	}
	
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		gameOb.getPlayer().mouseClicked(e,camera) ;
		
		
	}



	public static void main(String[] args) {
		

	}

}
