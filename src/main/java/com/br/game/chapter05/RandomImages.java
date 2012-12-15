package com.br.game.chapter05;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.net.URL;
import java.util.Random;

public class RandomImages extends Applet{

	private static final long serialVersionUID = -3636396376215319678L;
	private Image image;
	
	AffineTransform affineTransform = new AffineTransform();
	
	@Override
	public void init(){
		String fileName = "spaceship.png";
		URL url = getURL(fileName);
		image = getImage(url);
	}
	
	@Override
	public void paint(Graphics graphics){
		Graphics2D graphics2d = (Graphics2D) graphics;
		AffineTransform affineTransform = new  AffineTransform();
		Random random = new Random();
		
		int width = getSize().width;
		int height = getSize().height;
		int coordinatesX = 0, coordinatesY = 0;
		
		graphics2d.setColor(Color.BLACK);
		graphics2d.fillRect(coordinatesX, coordinatesY, width, height);
		
		for(int cont=0; cont<50; cont++){
			double tx = random.nextInt() % width;
			double ty = random.nextInt() % height;
			double theta = Math.toRadians(360 * random.nextDouble());
			double scale = random.nextDouble() + 1;
			
			this.affineTransform.setTransform(affineTransform);
			this.affineTransform.translate(tx, ty);
			this.affineTransform.rotate(theta);
			this.affineTransform.scale(scale, scale);
			
			graphics2d.drawImage(image, this.affineTransform, this);
		}
	}
	
	private URL getURL(String fileName){
		return this.getClass().getResource(fileName);
	}
	
	

}
