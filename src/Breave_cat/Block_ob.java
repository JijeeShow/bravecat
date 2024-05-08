package Breave_cat;

import java.util.ArrayList;
import java.util.Iterator;

public class Block_ob {
	private ArrayList<Block> bList  ;
	private ArrayList<Block> b2List  ;
	private ArrayList<Block> b3List  ;
	private ArrayList<Block> b4List  ;
	private ArrayList<Block> b5List;
	private ArrayList<Block> b6List;
	

	public Block_ob() {
		bList= new ArrayList<Block>();
		b2List= new ArrayList<Block>();
		b3List= new ArrayList<Block>();
		b4List= new ArrayList<Block>();
		b5List= new ArrayList<Block>();
		b6List= new ArrayList<Block>();
	}
	public void addBlock_ob(Block b,int i) {
		if(i==1)
			bList.add(b) ;
		if(i==2)
			b2List.add(b) ;
		if(i==3)
			b3List.add(b) ;
		if(i==4)
			b4List.add(b) ;
		if(i==5)
			b5List.add(b) ;
		if(i==6)
			b6List.add(b) ;
		
	}
	
	public ArrayList<Block> getBlock() {
		return bList;
	}
	public ArrayList<Block> getBlock2() {
		return b2List;
	}
	public ArrayList<Block> getBlock3() {
		return b3List;
	}
	public ArrayList<Block> getBlock4() {
		return b4List;
	}
	public ArrayList<Block> getBlock5() {
		return b5List;
	}
	public ArrayList<Block> getBlock6() {
		return b6List;
	}
	
	

	public static void main(String[] args) {
		

	}


}
