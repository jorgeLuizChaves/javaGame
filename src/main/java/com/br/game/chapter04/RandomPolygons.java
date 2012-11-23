package com.br.game.chapter04;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class RandomPolygons extends Applet {
	
	private static final long serialVersionUID = -125557162172013734L;
	private int[] xPoints = {0, -10, -7, 7, 10};
	private int[] yPoints = {-10, -2, 10, 10, -2};
	
	private Polygon polygon;
	
	@Override
	public void init(){
		polygon = new Polygon(xPoints, yPoints, xPoints.length);
	}
	
	@Override
	public void paint(Graphics graphics){
		Graphics2D graphics2d = (Graphics2D) graphics;
		AffineTransform affineTransform = new AffineTransform();
		Random random = new Random();
		
		int width = getSize().width;
		int height = getSize().height;
		int x = 0;
		int y = 0;
		
		graphics2d.setColor(Color.BLACK);
		graphics2d.fillRect(x, y, width, height);
		
		for(int cont=0; cont < 300; cont++){
			double radians = Math.toRadians(360 * random.nextDouble());
			double tx = random.nextInt() % width;
			double ty = random.nextInt() % height;
			double sx = 5 * random.nextDouble();
			double sy = 5 * random.nextDouble();
			graphics2d.setTransform(affineTransform);
			graphics2d.translate(tx, ty);
			graphics2d.rotate(radians);
			graphics2d.scale(sx, sy);
			
			graphics2d.setColor(new Color(random.nextInt()));
			graphics2d.fill(polygon);
		}
		
		
	}
}