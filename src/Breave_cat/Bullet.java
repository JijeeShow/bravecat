package Breave_cat;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.util.ArrayList;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Bullet extends Animation  {
	private int x ;
	private int y ;
	private int cx ;
	private int cy ;
	private int speedx ;
	private int speedy ;
	private ArrayList bullet  ;
	private GameOb gameOb ;
	private int loop ;
	private int i ;
	private int station;
	private Clip sound1,sound2,sound3,sound4,sound5,sound6,sound7 ;
	private Random r =new Random() ;
	private long time;
	private boolean ch = true;
	
	

	public Bullet(int x, int y,int cx, int cy,GameOb gameOb, int i) {
		this.x=x ;
		this.y=y ;
		this.cx=cx ;
		this.cy=cy ;
		this.gameOb=gameOb;
		bullet = gameOb.getBullet().getBullet() ;
		this.i=i ;
		setAnimetion() ;
		setSound() ;
		int sound = r.nextInt(4) ;
		if(i==1) {
			if(sound==0) {
				sound1.start();
			}else if(sound==1) {
				sound2.start();
			}else if(sound==2) {
				sound3.start();
			}else if(sound==3) {
				sound4.start();
			}else if(sound==4) {
				sound5.start();
			}
		}else if (i==3) {
			sound6.start();
		}
	}

	private void setAnimetion() {
		Bu1 = new Level("Img\\bu.png").getLevel1() ;
	}
	
	private void setSound() {
		 try {
			AudioInputStream inputStream ;
	        inputStream = AudioSystem.getAudioInputStream(new File("sound\\1.wav"));
	        sound1 = AudioSystem.getClip() ;
	        sound1.open(inputStream);
	        inputStream = AudioSystem.getAudioInputStream(new File("sound\\2.wav"));
	        sound2 = AudioSystem.getClip() ;
	        sound2.open(inputStream);
	        inputStream = AudioSystem.getAudioInputStream(new File("sound\\3.wav"));
	        sound3 = AudioSystem.getClip() ;
	        sound3.open(inputStream);
	        inputStream = AudioSystem.getAudioInputStream(new File("sound\\4.wav"));
	        sound4 = AudioSystem.getClip() ;
	        sound4.open(inputStream);
	        inputStream = AudioSystem.getAudioInputStream(new File("sound\\5.wav"));
	        sound5 = AudioSystem.getClip() ;
	        sound5.open(inputStream);
	        inputStream = AudioSystem.getAudioInputStream(new File("sound\\6.wav"));
	        sound6 = AudioSystem.getClip() ;
	        sound6.open(inputStream);
	    	inputStream = AudioSystem.getAudioInputStream(new File("sound\\e1.wav"));
	    	sound7 = AudioSystem.getClip() ;
	    	sound7.open(inputStream); 
	 

	      } catch (Exception e) {
	         e.printStackTrace();
	  
	      }
			
		}


	public void update(int k) {
		for(int l =0;l<gameOb.getBlockOb().getBlock().size();l++) {
			Block b =	gameOb.getBlockOb().getBlock().get(l) ;
			if(getRectangle().intersects(b.getRectangle())) {
				bullet.remove(k);
				return ;
			}
		} 
		if(gameOb.getPlayer().getStation()==1) {
		ArrayList<Enemy> e = gameOb.getEnemy().getEnemy() ;
		for(int l=0;l<e.size();l++) {
			if(getRectangle().intersects(e.get(l).getRectangle())) {
				if(i==1) {
					bullet.remove(k);
					e.get(l).setHp(e.get(l).getHp()-1);
					if(e.get(l).getHp()==0) {
						e.remove(l) ;
						sound7.start();
					}
					return ;
				}else if(i==3) {
					e.remove(l) ;
				}	
			}
		}
		if(gameOb.getPlayer().getL()==5) {
		if(getRectangle().intersects(gameOb.getBoss().getRectangle())) {
			if(i==1) {
				gameOb.getBoss().setHp(gameOb.getBoss().getHp()-1);
			}
			bullet.remove(k);
			return ;
		}	
		}
		}
		speedx=(cx-x)/10 ;
		speedy=(cy-y)/10 ;
		x+=speedx ;
		y+=speedy ;
		if(speedx==0&&speedy==0) {
			bullet.remove(k);
		}

	}
	
	public void draw(Graphics2D g2) {
		if(i==1)
			g2.drawImage(Bu1,x-8,y-8, 16,16,null) ;
		if(i==3)
			g2.drawImage(Bu1,x-16,y-16,32,32,null) ;
	}
	public Rectangle getRectangle() {
		return new Rectangle(x-8,y-8,16,16) ;
	}
	public Rectangle getRectanglr2() {
		return new Rectangle(x-16,y-16,32,32) ;
	}

	public int getStation() {
		return station;
	}

	public void setStation(int station) {
		this.station = station;
	}
	

}
