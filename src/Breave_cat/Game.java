package Breave_cat;



import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Canvas ;




import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Menu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Random;

import javax.swing.Timer;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Game extends JPanel implements ActionListener{
	private boolean runnig = true ;
	private  Timer loop ;
	private Level img ;
	private BufferedImage img1,img2,img3,img11,img22,img33,te5,img44,te6 ;
	private Camera camera ;
	private GameOb gameOb ;
	private long time,time2;
	private long lass=0;
	private long lass2=System.currentTimeMillis();
	private  Random r = new Random() ; 
	private int fol= 0 ; 
	private int unfol= 10000 ;
	private boolean c = true,c2=true,c3=true,csound=true ; 
	private int j=0,i ;
	private Player player;
	private boolean stationbool,stationbool2=true,stationbool3=true;
	private static int station=0 ;
	private Boss boss ;
	private AudioInputStream map1 ;
	private Clip sound ;
	
	public Game() {
		this.setBounds(0,0,1120,640);
		setFocusable(runnig) ;
		gameOb = new GameOb() ;
		img = new Level("Img\\lev1.png") ;
		img1 = img.getLevel1();
		img11 = new Level("Img\\lev11.png").getLevel1() ; 
		img22 = new Level("Img\\lev22.png").getLevel1() ; 
		img33 = new Level("Img\\lev33.png").getLevel1() ; 
		img44 = new Level("Img\\lev44.png").getLevel1() ; 
		te5 = new Level("Img\\te5.png").getLevel1() ;
		te6 = new Level("Img\\te6.png").getLevel1() ;
		loadBlackgrow(station) ;
		img = new Level("Img\\lev2.png") ;
		img2 = img.getLevel1();
		gameOb.setEnemyAr(new EnemyAr(gameOb)) ;
		gameOb.setPlayer(new Player(200,950,100,100,gameOb)) ;
		gameOb.setBullet(new BulletAr(gameOb)) ;
		gameOb.setTestAr(new TestAr(gameOb)) ;
		boss = new Boss(1800,960,gameOb) ;
		gameOb.setBoss(boss) ;
		camera =new Camera(0,620) ;
		loop = new Timer(1000/50,this) ;
		loop.start();
		player = gameOb.getPlayer() ;
		addKeyListener(new Key(gameOb)) ;
		addMouseListener(new Mouse(camera,gameOb)) ;
		
	}
	
private void setSound(String file,int station) {
	 try {
		 if(station>=1)
        	sound.close();
        File f1 = new File(file);
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(f1);
        sound = AudioSystem.getClip() ;
        sound.open(inputStream);
        sound.start();
      } catch (Exception e) {
         e.printStackTrace();
      }
	}

@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2 = (Graphics2D) g ;
		g2.translate(-camera.getX(), -camera.getY());
		if(station==0) {
			g2.drawImage(img11,0,0,3360,1920,null);
			if(csound) {
				setSound("sound\\map1.wav",station) ;
				csound=false ;
			}
		}else if(station==1) {
			g2.drawImage(img22,0,0,3360,1920,null);
			if(!csound) {
				time2=System.currentTimeMillis() ;
				setSound("sound\\map2.wav",station) ;
				csound=true ;
			}
		}else if(station==2) {
			g2.drawImage(img33,0,0,3360,1920,null);
			if(csound) {
				setSound("sound\\map4.wav",station) ;
				csound=false ;
			}
			
		}else if(station==3) {
			g2.drawImage(img44,camera.getX(),camera.getY(),1120,640,null);
			
		}
		if(station<3) {
		g2.setFont(new Font("MEGLORIA", Font.PLAIN, 25));
		g2.setColor(Color.red);
		g2.drawString("Hp = "+gameOb.getPlayer().getK(),camera.getX()+40,camera.getY()+40);
		g2.setFont(new Font("MEGLORIA", Font.PLAIN, 20));
		g2.setColor(Color.orange);
		g2.drawString("energy ="+gameOb.getPlayer().getE(),camera.getX()+40,camera.getY()+80);	
		player.draw(g2) ;
		}
		if(station>=1) {
			g2.setFont(new Font("MEGLORIA", Font.PLAIN, 15));
			g2.setColor(Color.orange);
			g2.drawString("key = "+gameOb.getPlayer().getL(),camera.getX()+40,camera.getY()+570);	
		}
		
		if(System.currentTimeMillis()-time2>0&&System.currentTimeMillis()-time2<5000&&station==1)
			g2.drawImage(te5,camera.getX()+150,camera.getY()+120,800,400,null);
		if(station==1)
			gameOb.getEnemy().draw(g2) ;
		gameOb.getBullet().draw(g2) ;
		if(!c3&&boss.getHp()>0) {
			boss.draw(g2);
			if(System.currentTimeMillis()-time<4000) {
				g2.drawImage(te6,camera.getX(),camera.getY() ,1000,600,null);
			}
		}
		g2.translate(camera.getX(), camera.getY());
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		station =player.getStation() ;
		if(stationbool2) {
			stationbool= player.getStationbool() ;
			if(stationbool) {
				loadBlackgrow(station) ;
				player.setXY(1500,960);
				camera.setXY(1000,600);
			}
		}
		if(station==2&&stationbool3) {
			stationbool= player.getStationbool() ;
			if(stationbool) {
				img = new Level("img\\lev3.png") ;
				img3 = img.getLevel1();
				loadBlackgrow(station) ;
				stationbool3 =false ;
			}
		}
		player.update();
		gameOb.getBullet().update() ;
		if(station>=1&&!player.getBoss()) {
		time = System.currentTimeMillis() ;
		if(time-lass2<=unfol||c) {
			gameOb.getEnemy().update();
			if(c) {
				lass2 = System.currentTimeMillis() ;
				for(;true;) {
					unfol= r.nextInt(7000) ;
					if(unfol>=2000)
						break ;
				}
				c=false ;
				c2=true ;
			}	
		}else if(time-lass<=fol||c2){
			gameOb.getEnemy().update2();
			if(j==1) {
				gameOb.getEnemy().newEnemy();
				gameOb.getEnemy().newEnemy();
				j=0;
			}
				if(c2) {
					lass=System.currentTimeMillis() ;
					for(;true;) {
						fol= r.nextInt(3000) ;
						if(fol>=1500)
							break ;
						c2=false ;
					}
				}
			}else {
				c=true;
				j++ ;
			}
		}else if(player.getL()==5){
			if(c3) {
				setSound("sound\\map3.wav",station) ;
				time = System.currentTimeMillis() ;
				c3 =false ;
			}
			if(System.currentTimeMillis()-time>5000&&boss.getHp()>0) {
				boss.update(); 
				if(i%100==0) {
					boss.addEn();
					i=1 ;
					}
					gameOb.getEnemy().update2();
					i++ ;
			}
		
		}
		camera.update(gameOb.getPlayer().getx(),gameOb.getPlayer().gety(),station) ;
		repaint();
		/*if(player.getHp()<=0) {
			JOptionPane.showMessageDialog(null, "GAME OVER");
			System.exit(0);
		}*/
	}
	
	public void loadBlackgrow(int station) {
		int w = 0;
		int h = 0;
		int pixel = 0  ;
		if(station==0) {
			w = img1.getWidth() ;
			h = img1.getHeight();
		}else if(station==1) {
			gameOb.getBlockOb().getBlock().clear();
			gameOb.getBlockOb().getBlock2().clear();
			w = img2.getWidth() ;
			h = img2.getHeight();
			stationbool2 = false ;
		}else if(station==2) {
			w = img3.getWidth() ;
			h =  img3.getHeight();
			stationbool3=false ;
		}	
		gameOb.setBlock(new Block_ob()) ;
		for(int x=0;x<w;x++) {
			for(int y=0;y<h;y++) {
				if(station==0) {
					pixel = img1.getRGB(x, y) ;
				}else if(station==1) {
					pixel = img2.getRGB(x, y) ;
				}else if(station==2) {
					pixel = img3.getRGB(x, y) ;
				}
				int red = (pixel >> 16 ) & 0xff ;
				int green = (pixel >> 8 ) & 0xff ;
				int blue = (pixel) & 0xff ;
				if(red==255) {
					gameOb.getBlockOb().addBlock_ob(new Block(x*32,y*32),1) ;
				}else if(green==255) {
					gameOb.getBlockOb().addBlock_ob(new Block(x*32,y*32),2) ;
				}else if(blue==255) {
					gameOb.getBlockOb().addBlock_ob(new Block(x*32,y*32),3) ;
				}else if(blue==200) {
					gameOb.getBlockOb().addBlock_ob(new Block(x*32,y*32),4) ;
				}else if(blue==150) {
					gameOb.getBlockOb().addBlock_ob(new Block(x*32,y*32),5) ;
				}else if(blue==100) {
					gameOb.getBlockOb().addBlock_ob(new Block(x*32,y*32),6) ;
				}
				
			}
		}
		
	}

}