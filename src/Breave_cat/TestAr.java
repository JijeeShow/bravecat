package Breave_cat;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;

public class TestAr {
	private ArrayList<Test> tList  ;
	

	public TestAr(GameOb gameOb) {
		tList= new ArrayList<Test>();
		tList.add(new Test(100,100,gameOb)) ;
		tList.add(new Test(3260,100,gameOb)) ;
		tList.add(new Test(100,1820,gameOb)) ;
		tList.add(new Test(3260,1820,gameOb)) ;
		tList.add(new Test(1700,1100,gameOb)) ;
		
	}
	public void draw(Graphics2D g2,int l) {
			tList.get(l).draw(g2); 
		
	}
	public void update() {
		
	}
	
	public ArrayList<Test> getTestAr() {
		return tList;
	}
	
	public static void main(String[] args) {
		

	}
}
