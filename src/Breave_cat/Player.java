package Breave_cat;

import java.awt.Color;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;

public class Player extends Animation {
	private int x;
	private int y;
	private int yy=0;
	private int xx=0;
	private int Hp,l=0;
	private int en;
	private int speedx=0;
	private int speedy=0;
	private GameOb gameOb ;
	private boolean check=false ;
	private int station=0 ;
	private boolean Stationbool =false;
	private int num;
	private boolean boss = false, bull=true ;
	private long time;
	private Clip sound;
	
	
		
	public Player(int x,int y,int k,int e,GameOb gameOb) {
		this.x=x ;
		this.y=y ;
		this.Hp=k ;
		this.en=e ;
		this.gameOb=gameOb ;    
		setAnimetion() ;
	}
	private void setSound() {
		try {
			AudioInputStream inputStream ;
	        inputStream = AudioSystem.getAudioInputStream(new File("sound\\c1.wav"));
	        sound = AudioSystem.getClip() ;
	        sound.open(inputStream); 
	        sound.start();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}

	public void update() {
		xx=x ;
		x+=speedx ;
		yy=y+speedy ;
		Iterator<Block> block =	gameOb.getBlockIt() ;
		while(block.hasNext()) {
			Block block2 = block.next() ;
			if(getRectangle().intersects(block2.getRectangle())) {
				x += speedx*-1;
			}
			if(getRectangle2().intersects(block2.getRectangle())) {
				yy += speedy*-1 ;
			}
		}
		y=yy;
		
		
		
		if(station==1) {
			Iterator<Enemy> enemy =	gameOb.getEnemyIt() ;
			while(enemy.hasNext()) {
				Enemy enemy2 = enemy.next() ;
				if(getRectangle().intersects(enemy2.getRectangle())) {
					Hp-=1 ;
				}
			}
			if(l!=5) {
			ArrayList<Test> test =gameOb.getTestAr() ;
			Test test2 = test.get(0) ;
			test2.update() ;
				if(getRectangle().intersects(test2.getRectangle())) {
					setSound() ;
					test.remove(0) ;
					l++ ;
					
				}
			}
			if(l==5&&!boss){
				gameOb.getEnemy().getEnemy().clear();
				boss = true ;
			}
			}
		
		Iterator<Block> bpass =	gameOb.getBlockIt2() ;
		while(bpass.hasNext()) {
			Block bpass2 = bpass.next() ;
			if(getRectangle().intersects(bpass2.getRectangle())) {
				if(station==0)
					station=1 ;
				if(station==2)
					station=3;
				Stationbool = true ;
			}
		}
		if (gameOb.getBoss().getHp()==0&&station==1) {
			station = 2 ;
		}		
		if(check&&en>0&&(speedx!=0||speedy!=0)) {
			en--;
		}else if(en<100&&!check)
			en++ ;
		if(en==0) {
		if(speedx==-10)
			speedx=-7 ;
		if(speedx==10)
			speedx=7 ;
		if(speedy==-10)
			speedy=-7 ;
		if(speedy==10)
			speedy=7 ;
		}
		num++ ;
		if(num>5) {
			num=0 ;
			numfram+=1 ;
			if(numfram==5)
				numfram=1 ;
		}
		
	}

	public void draw(Graphics2D g2) {
		if(station==0) {
			Iterator<Block> block3 =	gameOb.getBlockIt3() ;
			while(block3.hasNext()) {
				Block block = block3.next() ;
				if(getRectangle().intersects(block.getRectangle())) {
					g2.drawImage(te1,400-100,950-50,200,100,null) ;
				}
			}
			Iterator<Block> block4 =	gameOb.getBlockIt4() ;
			while(block4.hasNext()) {
				Block block = block4.next() ;
				if(getRectangle().intersects(block.getRectangle())) {
					g2.drawImage(te2,1500,300,500,250,null) ;
				}
			}
			Iterator<Block> block5 =	gameOb.getBlockIt5() ;
			while(block5.hasNext()) {
				Block block = block5.next() ;
				if(getRectangle().intersects(block.getRectangle())) {
					g2.drawImage(te3,2200,1500,500,250,null) ;
				}
			}
			Iterator<Block> block6 =	gameOb.getBlockIt6() ;
			while(block6.hasNext()) {
				Block block = block6.next() ;
				if(getRectangle().intersects(block.getRectangle())) {
					g2.drawImage(te4,2300,800,500,250,null) ;
				}
			}
		}
		BufferedImage img = null ;
		if(l<5&&station==1)
			gameOb.getTest().draw(g2,0) ;
		if(speedx>0) {
			if(numfram==1) {
				img = l1 ;
			}else if(numfram==2) {
				img = l2 ;
			}else if(numfram==3) {
				img = l3 ;
			}else if (numfram==4) {
				img = l4 ;
			}
		}else if (speedx<0) {
			if(numfram==1) {
				img = r1 ;
			}else if(numfram==2) {
				img = r2 ;
			}else if(numfram==3) {
				img = r3 ;
			}else if (numfram==4) {
				img = r4 ;
			}
		}else if (speedy<0) {
			if(numfram==1) {
				img = up1 ;
			}else if(numfram==2) {
				img = up2 ;
			}else if(numfram==3) {
				img = up1 ;
			}else if (numfram==4) {
				img = up2 ;
			}	
			
			
		}else  {
			if(numfram==1) {
					img = still1 ;
				}else if(numfram==2) {
					img = still2 ;
				}else if(numfram==3) {
					img = still3 ;
				}else if (numfram==4) {
					img = still4 ;
				}
			
		}
		g2.drawImage(img,x-24,y-24, 56, 56,null) ;
	
	}
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode() ;
		if(key==KeyEvent.VK_A) {
			speedx=-7;
			if(check&&en!=0)
				speedx=-10 ;
		}
		if(key==KeyEvent.VK_W) {
			speedy=-7;
			if(check&&en!=0)
				speedy=-10 ;
		}
		if(key==KeyEvent.VK_D) {
			speedx=7;
			if(check&&en!=0)
				speedx=10 ;
		}
		if(key==KeyEvent.VK_S) {
			speedy=7;
			if(check&&en!=0)
				speedy=10 ;
		}
		if(key==KeyEvent.VK_SPACE&&!check&&en!=0) {
			check = true ;
			if(speedy==7) {
				speedy=10 ;
			}
			if(speedy==-7) {
				speedy=-10 ;
			}
			if(speedx==7) {
				speedx=10 ;
			}
			if(speedx==-7) {
				speedx=-10 ;
			}
		}
		
	}
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode() ;
		if(key==KeyEvent.VK_A) {
			speedx=0;
		}
		if(key==KeyEvent.VK_W) {
			speedy=0;
		}
		if(key==KeyEvent.VK_D) {
			speedx=0;
		}
		if(key==KeyEvent.VK_S) {
			speedy= 0;
		}
		if(key==KeyEvent.VK_SPACE&&check) {
			check = false ;
			if(speedy>0) {
				speedy=7 ;
			}
			if(speedy<0) {
				speedy=-7 ;
			}
			if(speedx>0) {
				speedx=7 ;
			}
			if(speedx<0) {
				speedx=-7 ;
			}
		}
		
	}
	public void mouseClicked(MouseEvent e,Camera camera) {
		if(bull) {
			time = System.currentTimeMillis() ;
			bull=false ;
		}
		if(e.getButton()==MouseEvent.BUTTON1) {
			gameOb.getBullet().Bullet(x,y,e.getX()+camera.getX(),e.getY()+camera.getY(),e.getButton());
		}
		if(e.getButton()==MouseEvent.BUTTON3&&System.currentTimeMillis()-time>3000) {
			gameOb.getBullet().Bullet(x,y,e.getX()+camera.getX(),e.getY()+camera.getY(),e.getButton());
			bull = true ;
		}
	}
	
	public void setAnimetion() {
		try {
			still1 = new Level("Img\\still1.png").getLevel1() ;
			still2 = new Level("Img\\still2.png").getLevel1() ;
			still3 = new Level("Img\\still3.png").getLevel1() ;
			still4 = new Level("Img\\still4.png").getLevel1() ;
			l1 = new Level("Img\\l1.png").getLevel1() ;
			l2 = new Level("Img\\l2.png").getLevel1() ;
			l3 = new Level("Img\\l3.png").getLevel1() ;
			l4 = new Level("Img\\l4.png").getLevel1() ;
			up1 = new Level("Img\\up1.png").getLevel1() ;
			up2 = new Level("Img\\up2.png").getLevel1() ;
			r1 = new Level("Img\\r1.png").getLevel1() ;
			r2 = new Level("Img\\r2.png").getLevel1() ;
			r3 = new Level("Img\\r3.png").getLevel1() ;
			r4 = new Level("Img\\r4.png").getLevel1() ;
			te1 = new Level("Img\\te1.png").getLevel1() ;
			te2 = new Level("Img\\te2.png").getLevel1() ;
			te3 = new Level("Img\\te3.png").getLevel1() ;
			te4 = new Level("Img\\te4.png").getLevel1() ;
			
		
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
	public Rectangle getRectangle() {
		return new Rectangle(x-24,y-24,48,48) ;
	}
	private Rectangle getRectangle2() {
		return new Rectangle(xx-24,yy-24,48,48) ;
	}
	
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	public int getK() {
		return Hp;
	}
	public int getStation() {
		return station;
	}
	
	public int getE() {
		return en;
	}
	public int getHp() {
		return Hp;
	}
	public int getL() {
		return l;
	}
	public boolean getStationbool() {
		return Stationbool ;
	}
	public void setXY(int x,int y) {
		this.x=x ;
		this.y=y ;
	}
	public boolean getBoss() {
		return boss;
	}

	
}
