package com.br.game.chapter04;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.Random;

public class RandomShapes extends Applet{

	private static final long serialVersionUID = 1400709224496193101L;
	private Shape shape;
	
	@Override
	public void init(){
		double positionX = -1.0;
		double positionY = -1.0;
		double width = 1.0;
		double height = 1.0;
		shape = new Rectangle2D.Double(positionX, positionY, width, height);
	}
	
	@Override
	public void paint(Graphics graphics){
		Graphics2D graphics2d = (Graphics2D) graphics;
		AffineTransform affineTransform = new AffineTransform();
		
		Random random = new Random();
		int width = getSize().width;
		int height = getSize().height;
		
		graphics2d.setColor(Color.black);
		
		int positionX = 0;
		int positionY = 0;
		
		graphics2d.fillRect(positionX, positionY, width, height);
		
		for(int cont = 0; cont < 300; cont++){
			graphics2d.setTransform(affineTransform);
			int translateX = random.nextInt() % width;
			int translateY = random.nextInt() % height;
			graphics2d.translate(translateX, translateY);
			double theta = Math.toRadians(360 * random.nextDouble());
			graphics2d.rotate(theta);
			double sx = 60 * random.nextDouble();
			double sy = 60 * random.nextDouble();
			graphics2d.scale(sx, sy);
			
			graphics2d.setColor(new Color(random.nextInt()));
			graphics2d.fill(shape);
		}
	}
}