package Breave_cat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Enemy extends Animation{	
	private int x ;
	private int y ;
	private int i=0,j=10 ;
	private  Random r = new Random() ; 
	private GameOb gameOb ;
	private int speedx;
	private int speedy;
	private int speedx2;
	private int speedy2;
	private int xx;
	private int yy;
	private int num;
	private boolean ch;
	private int hp=5 ;
	private Clip sound;
	
	public Enemy(int x, int y,GameOb gameOb) {
		this.x=x ;
		this.y=y ;
		this.gameOb=gameOb ;
		setAnimetion() ;
		
	}


	public void setAnimetion() {
		try {
				
			E1 = new Level("Img\\E1.png").getLevel1() ;
			E2 = new Level("Img\\E2.png").getLevel1() ;
			E3 = new Level("Img\\E3.png").getLevel1() ;
			E4 = new Level("Img\\E4.png").getLevel1() ;
			E5 = new Level("Img\\E5.png").getLevel1() ;
			E6 = new Level("Img\\E6.png").getLevel1() ;
			E7 = new Level("Img\\E7.png").getLevel1() ;
			E8 = new Level("Img\\E8.png").getLevel1() ;
			E9 = new Level("Img\\E9.png").getLevel1() ;
			E10 = new Level("Img\\E10.png").getLevel1() ;
			E11 = new Level("Img\\E11.png").getLevel1() ;
			E12 = new Level("Img\\E12.png").getLevel1() ;
			E13 = new Level("Img\\E13.png").getLevel1() ;
			Ef1 = new Level("Img\\3.1.png").getLevel1() ;
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update() {
		if(j>i) {
			i=r.nextInt(50) ;
			speedx = (r.nextInt(16)-8) ;
			speedy = (r.nextInt(16)-8) ;
			j=0 ;
		}
			x+=speedx;
			y+=speedy ;	
		Iterator<Block> block =	gameOb.getBlockIt() ;
		while(block.hasNext()) {
			Block block2 = block.next() ;
			if(getRectangleun().intersects(block2.getRectangle())) {
				x += speedx*-1;
				y += speedy*-1 ;
				j=i ;
			}
		}
		j++;
		num++ ;
		if(num>1) {
			num=0 ;
			numfram+=1 ;
			if(numfram==14)
				numfram=1 ;
		}
		ch=true ;
		
		
		}
	private Rectangle getRectangleun() {
		return new Rectangle(x,y+12,56,56) ;
	}

	public void follw(int px,int py) {
		Player p = gameOb.getPlayer();
		if(getRectangle().intersects(p.getRectangle())) {
			speedx2=0 ;
			speedy2=0 ;
		}else {
			if(x<px) 
				speedx2=9 ;
			if(x>px)
				speedx2=-9;
			if(y<py)
				speedy2=9;
			if(y>py)
				speedy2=-9;
			if(x>px-24&&x<px+24)
				speedx2=0 ;
			if(y>py-24&&y<py+24)
				speedy2=0 ;
		}
		xx=x;
		x+=speedx2 ;
		yy=y+speedy2;
		Iterator<Block> block =	gameOb.getBlockIt() ;
		while(block.hasNext()) {
			Block block2 = block.next() ;
			if(getRectangle().intersects(block2.getRectangle())) {
				x += speedx2*-1;
			}
			if(getRectangle2().intersects(block2.getRectangle())) {
				yy += speedy2*-1 ;
			}
		}
		y=yy;
		ch=false ;
	}
		
	
	

	public void draw(Graphics2D g2) {
		BufferedImage img =null ;
		if(ch) {
			if(numfram==1) {
				img = E1 ;
			}else if(numfram==2) {
				img = E2 ;
			}else if(numfram==3) {
				img = E3 ;
			}else if(numfram==4) {
				img = E4 ;
			}else if(numfram==5) {
				img = E5 ;
			}else if(numfram==6) {
				img = E6 ;
			}else if(numfram==7) {
				img = E7 ;
			}else if(numfram==8) {
				img = E8 ;
			}else if(numfram==9) {
				img = E9 ;
			}else if(numfram==10) {
				img = E10 ;
			}else if(numfram==11) {
				img = E11 ;
			}else if(numfram==12) {
				img = E12 ;
			}else if(numfram==13) {
				img = E13 ;
			}
			g2.drawImage(img,x,y, 56, 96,null) ;
		}else {
				img = Ef1 ;
			g2.drawImage(img,x,y, 48,48,null) ;
		
		}
	
	}

	public Rectangle getRectangle() {
		return new Rectangle(x,y,48,48) ;
	}
	private Rectangle getRectangle2() {
		return new Rectangle(xx,yy,48,48) ;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	

}
