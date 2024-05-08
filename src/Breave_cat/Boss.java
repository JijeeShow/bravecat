package Breave_cat;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.Iterator;
import java.util.Random;

public class Boss extends Animation{
	private int x;
	private int y;
	private GameOb gameOb;
	private int num;
	private int Hp=30;
	private int i;
	private int j;
	private Random r = new Random();
	private int speedx;
	private int speedy;
	
	public Boss(int x,int y,GameOb gameob) {
		this.x=x;
		this.y=y;
		this.gameOb=gameob ;
		setAnimetion() ;
		
	}
	private void setAnimetion() {
		try {			
			Ef1 = new Level("Img\\\\boss2.png").getLevel1() ;
			B1 = new Level("Img\\boss1.png").getLevel1() ;
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void addEn() {
		gameOb.getEnemy().newEnemyBoss(getX(),getY());
		
	}
	public void update() {
		if(j>i) {
			i=r.nextInt(50) ;
			speedx = (r.nextInt(10)-5) ;
			speedy = (r.nextInt(10)-5) ;
			j=0 ;
		}
			x+=speedx;
			y+=speedy ;	
		Iterator<Block> block =	gameOb.getBlockIt() ;
		while(block.hasNext()) {
			Block block2 = block.next() ;
			if(getRectangle().intersects(block2.getRectangle())) {
				x += speedx*-1;
				y += speedy*-1 ;
				j=i ;
			}
		}
		j++;
		num++ ;
		if(num>10) {
			num=0 ;
			numfram+=1 ;
			if(numfram==3)
				numfram=1 ;
		}
	}
	public void draw (Graphics2D g2) {
		BufferedImage img = null ;
		if(numfram==1) {
			img = Ef1 ;
		}else {
			img = B1 ;
		}
		g2.drawImage(img,x,y, 240, 240,null) ;
		
		
		
	}
	
	 public int getHp() {
		return Hp;
	}
	public void setHp(int hp) {
		Hp = hp;
	}
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Rectangle getRectangle() {
		return new Rectangle(x,y,240,240) ;
	}
}
