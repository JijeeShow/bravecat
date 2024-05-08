package Breave_cat;

import java.awt.Rectangle;


public class Block {
	private int x ;
	private int y ;
	
	public Block(int x,int y) {
		this.x=x ;
		this.y=y ;
		
	}
	public Rectangle getRectangle() {
		return new Rectangle(x, y, 32, 32) ;
	}
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
}