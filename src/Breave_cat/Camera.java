package Breave_cat;

public class Camera {
	private int x ;
	private int y ;
	
	public Camera (int x,int y) {
		this.x=x ;
		this.y=y ;
	}

	public void update(int xx,int yy,int sa) {
		this.x+= ((xx-x)-1120/2)*0.2f ;
		this.y+= ((yy-y)-640/2)*0.2f ;
		if(x<=0) 
			x=0 ;
		if(x>=2254)
			x=2254;
		if(y<=0)
			y=0 ;
		if(y>=1318)
			y=1318 ;
		}
		
	
	public int getX() {
		return x ;
	}
	public int getY() {
		return y ;
	}

	public void setXY(int x, int y) {
		this.x=x;
		this.y=y;
		
	}

}
