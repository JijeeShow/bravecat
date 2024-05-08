package Breave_cat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class BulletAr {
	private int x ;
	private int y ;
	private GameOb gameOb ;
	private ArrayList<Bullet> bullet= new ArrayList<Bullet>()  ;
	private int mo;
	
	public BulletAr(GameOb gameOb) {
		this.gameOb=gameOb ;
	}
	public BulletAr() {
		
	}
	public void Bullet(int x,int y,int cx,int cy, int i) {
		this.x=x;
		this.y=y ;
		this.mo=i ;
		if(i==1)
			bullet.add(new Bullet(x,y,cx,cy,gameOb,i)) ;
		if(i==3)
			bullet.add(new Bullet(x,y,cx,cy,gameOb,i)) ;
	}
	public void draw(Graphics2D g2) {
		for(int i=0 ;i<bullet.size();i++)
			bullet.get(i).draw(g2); 
		
	}
	public void update() {
		for(int i=0 ;i<bullet.size();i++) 
			bullet.get(i).update(i); 
	}
	public void remove(int i) {
		for( ;i<bullet.size();i++) 
			bullet.get(i).update(i); 
		
	}
	public ArrayList getBullet() {
		return bullet;
		
	}
	public GameOb getGameOb() {
		return gameOb;
		
	}

	
	

}
