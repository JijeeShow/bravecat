package Breave_cat;

import java.util.ArrayList;
import java.util.Iterator;

public class GameOb {
	private Player player ;
	private Block_ob block ;
	private EnemyAr enemy ;
	private BulletAr bullet ;
	private TestAr test;
	private Boss boss;
	
	public GameOb () {
		
	}
	public void setPlayer(Player player) {
		this.player=player ;
	}
	
	public Player getPlayer() {
		return player ;
	}
	public void setBlock(Block_ob b) {
		this.block=b ;
	}
	
	public Block_ob getBlockOb() {
		return block ;
	}
	public void setEnemyAr(EnemyAr e) {
		this.enemy=e ;
	}
	
	public EnemyAr getEnemy() {
		return enemy ;
	}
	public void setBullet (BulletAr b) {
		this.bullet=b ;
	}
	
	public BulletAr getBullet() {
		return bullet ;
	}
	public Iterator<Block> getBlockIt() {
		return  block.getBlock().iterator();
	}
	public Iterator<Block> getBlockIt2() {
		return  block.getBlock2().iterator();
	}
	public Iterator<Block> getBlockIt3() {
		return  block.getBlock3().iterator();
	}
	public Iterator<Block> getBlockIt4() {
		return  block.getBlock4().iterator();
	}
	public Iterator<Block> getBlockIt5() {
		return  block.getBlock5().iterator();
	}
	public Iterator<Block> getBlockIt6() {
		return  block.getBlock6().iterator();
	}
	public Iterator<Enemy> getEnemyIt() {
		return enemy.getEnemy().iterator() ;
	}
	public void setTestAr(TestAr test2) {
		this.test=test2 ;
		
	}
	public ArrayList<Test> getTestAr() {
		return test.getTestAr();
	}
	public TestAr getTest() {
		return test;
	}
	public void setBoss(Boss boss) {
		this.boss=boss ;
		
	}
	public Boss getBoss() {
		return boss;
	}
	

}
