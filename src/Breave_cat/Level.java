package Breave_cat;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.*;

public class Level {
	private BufferedImage img ;
	
	public Level(String path) {
		try {
			img = ImageIO.read(new File(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.img=img;
	}
	
	public BufferedImage getLevel1() {
		return img;
	}

	public static void main(String[] args) {

	}
}
