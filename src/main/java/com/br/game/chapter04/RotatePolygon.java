package com.br.game.chapter04;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RotatePolygon extends Applet implements KeyListener, MouseListener{

	private static final long serialVersionUID = -4655690517220269273L;
	
	private Polygon polygon;
	int rotation = 0;
	private int[] xPoints = {0, -10, -7, 7, 10};
	private int[] yPoints = {-10, -2, 10, 10, -2};
	
	@Override
	public void init(){
		polygon = new Polygon(xPoints, yPoints, xPoints.length);
		addKeyListener(this);
		addMouseListener(this);
	}
	
	@Override
	public void paint(Graphics graphics){
		Graphics2D graphics2d = (Graphics2D) graphics;
		
		int width = getSize().width;
		int height = getSize().height;
		
		graphics2d.setColor(Color.BLACK);
		int x = 0;
		int y = 0;
		graphics2d.fillRect(x, y, width, height);
		
		graphics2d.translate(width / 2, height / 2);
		double sx = 20;
		double sy = 20;
		graphics2d.scale(sx, sy);
		graphics2d.rotate(Math.toRadians(rotation));
		
		graphics2d.setColor(Color.RED);
		graphics2d.fill(polygon);
		graphics2d.setColor(Color.BLUE);
		graphics2d.draw(polygon);
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		switch(keyEvent.getKeyCode()){
		case KeyEvent.VK_LEFT:
			rotation--;
			if(rotation < 0)
				rotation = 359;
			repaint();
			break;
		case KeyEvent.VK_RIGHT:
			rotation++;
			if(rotation > 360)
				rotation = 0;
			repaint();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

}
