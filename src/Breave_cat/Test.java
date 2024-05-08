package Breave_cat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Test extends Animation {
	private int x ;
	private int y ;
	private GameOb gameOb ;
	private int num;
	private Clip sound;
	
	public Test(int x,int y ,GameOb gameOb) {
		this.gameOb=gameOb ;
		this.x=x;
		this.y=y ;
		setAnimetion() ;
	}




	private void setAnimetion() {
		try {
			C1 = new Level("Img\\c1.png").getLevel1() ;
			C2 = new Level("Img\\c2.png").getLevel1() ;
			C3 = new Level("Img\\c3.png").getLevel1() ;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage img =null ;
	
		if(numfram==1) {
			img = C1 ;
		}else if(numfram==2) {
			img = C2 ;
		}else if(numfram==3) {
			img = C3 ;
		}
		g2.drawImage(img,x,y, 32, 32,null) ;
		
	}

	public void update() {
		num++ ;
		if(num>5) {
			num=0 ;
			numfram+=1 ;
			if(numfram==4)
				numfram=1 ;
		}
	
		
	}

	public Rectangle getRectangle() {
		return new Rectangle(x,y,32,32) ;
	}

}
