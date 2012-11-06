package com.br.game.chapter03;

import java.awt.Polygon;
import java.awt.Rectangle;

public class Asteroid extends BaseVectorShape {
	
	private static int[] ASTEROIDS_COORDINATES_X = {-20, -13, 0, 20, 22, 20, 12, 2, -10, -22, -16};
	private static int[] ASTEROIDS_COORDINATES_Y = {20, 23, 17, 20, 16, -20, -22, -14, -17, -20};
	private double rotationVelocity;
	
	public Asteroid(){
		setShape(new Polygon(ASTEROIDS_COORDINATES_X, ASTEROIDS_COORDINATES_Y, ASTEROIDS_COORDINATES_X.length));
		setAlive(true);
	}
	
	public double getRotationVelocity() {
		return rotationVelocity;
	}

	public void setRotationVelocity(double rotationVelocity) {
		this.rotationVelocity = rotationVelocity;
	}
	
	@Override
	public Rectangle getBounds() {
		int coordinatesX = (int) (getPositionX() - 20);
		int coordinatesY = (int) (getPositionY() - 20);
		int width = 40;
		int height = 40;
		return new Rectangle(coordinatesX, coordinatesY, width, height);
	}
}