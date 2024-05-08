package Breave_cat;

import java.awt.Color;

import javax.swing.JFrame ;

public class GamePanel {
	private final int HIGHT = 640 ; 
	private final int WIDTH = 1120 ; 
	
	public GamePanel() {
		JFrame jf = new JFrame("Brave Cat Runing") ;
		jf.setSize(WIDTH, HIGHT);
		jf.add(new Game()) ;
		jf.setResizable(false) ;
		jf.setVisible(true);
		jf.setLocationRelativeTo(null);
		jf.setBackground(Color.BLUE);
 		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 		

		
	}
	public static void main(String[] args) {
		
		

}
}
