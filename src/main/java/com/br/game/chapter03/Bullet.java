package com.br.game.chapter03;

import java.awt.Rectangle;
import java.awt.Shape;

public class Bullet extends BaseVectorShape {

	
	public Bullet(){
		configureBullet();
	}

	@Override
	public Rectangle getBounds() {
		int width = 1;
		int height = 1;
		int coordinatesX = (int) getPositionX();
		int coordinatesY = (int) getPositionY();
		return new Rectangle(coordinatesX, coordinatesY, width, height);
	}
	
	private void configureBullet() {
		int x = 0;
		int y = 0;
		int width = 1;
		int height = 1;
		setAlive(false);
		Shape rectangle = new Rectangle(x, y, width, height);
		setShape(rectangle);
	}
}