package Breave_cat;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class EnemyAr {
	private ArrayList<Enemy> enemy  ;
	private GameOb gameOb ;
	private boolean check ;
	private  Random r = new Random() ; 
	
	public EnemyAr(GameOb gameOb) {
		 enemy = new ArrayList<Enemy>() ;
		 this.gameOb=gameOb ;
		enemy.add(new Enemy(960,700,gameOb));
		enemy.add(new Enemy(700,300,gameOb));
		enemy.add(new Enemy(1000,800,gameOb));
		enemy.add(new Enemy(1200,600,gameOb)) ;
		enemy.add(new Enemy(200,200,gameOb)) ;
		enemy.add(new Enemy(3000,200,gameOb)) ;
		enemy.add(new Enemy(200,1800,gameOb)) ;
		enemy.add(new Enemy(300,1800,gameOb)) ;
	}
	public void draw(Graphics2D g2) {
		for(int i=0 ;i<enemy.size();i++)
			enemy.get(i).draw(g2); 
		
	}
	public void update() {
		for(int i=0 ;i<enemy.size();i++) 
			enemy.get(i).update(); 
		
	}
	public void newEnemy() {
		check=true ;
		int x =r.nextInt(3360);
		int y =r.nextInt(1920);
		class re {
			public Rectangle getRectangle() {
			 return new Rectangle(x,y,48,48) ;
			}
		}
		Iterator<Block> b =	gameOb.getBlockOb().getBlock().iterator() ;
		re re2 = new re() ;
		Rectangle re3 = re2.getRectangle() ;
		while(b.hasNext()) {
			Block b2 = b.next() ;
			if(re3.intersects(b2.getRectangle())) {
				check = false ;
			}
		}
		if(check) 
			enemy.add(new Enemy(r.nextInt(3360),r.nextInt(1920),gameOb)) ;
	}
	public void newEnemyBoss(int x, int y) {
		int num = r.nextInt(4) ;
		
		for(int i=0;i<=num;i++) {
			int x2 =r.nextInt(x+240) ;
			int y2 =r.nextInt(y+240) ;
			for(;x2<x;)
				x2 =r.nextInt(x+240) ;
			for(;y2<y;)
				y2 =r.nextInt(y+240) ;
			enemy.add(new Enemy(x2,y2,gameOb)) ;
		}
		
	
		
	}
	
	public void update2() {
		for(int i=0 ;i<enemy.size();i++) 
			enemy.get(i).follw(gameOb.getPlayer().getx()-24,gameOb.getPlayer().gety()-24); 
	}
	public ArrayList<Enemy> getEnemy() {
		return enemy ;
	}
	
	
	public static void main(String[] args) {
		

	}


}
