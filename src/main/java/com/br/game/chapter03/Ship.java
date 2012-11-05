package com.br.game.chapter03;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;

public class Ship extends BaseVectorShape {
	
	private int[] coordinatesY = {6, 7, 7, 7, 6, -7};
	private int[] coordinatesX = {-6, -3, 0, 3, 6, 0};

	public Ship(){
		configureShip();
	}

	@Override
	public Rectangle getBounds() {
		int width  = 12;
		int height = 12;
		int x = (int) (getPositionX() - 6);
		int y = (int) (getPositionY() - 6);
		return new Rectangle(x, y, width, height);
	}
	
	private void configureShip() {
		Shape polygon = new Polygon(coordinatesX, coordinatesY, coordinatesX.length);
		setShape(polygon);
		setAlive(true);
	}
}