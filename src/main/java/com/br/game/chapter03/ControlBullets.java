package com.br.game.chapter03;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class ControlBullets implements Controlable {

	private static int BULLETS = 10;
	private Bullet[] bullets = new Bullet[BULLETS];
	private int currentBullet = 0;
	
	@Override
	public void setup() {
		for(int cont=0; cont < BULLETS; cont++){
			bullets[cont] = new Bullet();
		}
	}

	@Override
	public void draw(Graphics2D graphics2d, AffineTransform affineTransform) {
		for (Bullet bullet : bullets) {
			if(bullet.isAlive()){
				graphics2d.setTransform(affineTransform);
				graphics2d.translate(bullet.getPositionX(), bullet.getPositionY());
				graphics2d.setColor(Color.MAGENTA);
				graphics2d.draw(bullet.getShape());
			}
		}
	}

	@Override
	public void update() {
		for (Bullet bullet : bullets) {
			if(bullet.isAlive()){
				double valuePositionX = bullet.getVelocityX();
				bullet.incrementPositionX(valuePositionX);
				if(bullet.getPositionX() < 0 || bullet.getPositionX() > ConstantGame.WIDTH.getValue()){
					bullet.setAlive(false);
				}
				
				double valuePositionY = bullet.getVelocityY();
				bullet.incrementPositionY(valuePositionY);
				if(bullet.getPositionY() < 0 || bullet.getPositionY() > ConstantGame.HEIGHT.getValue()){
					bullet.setAlive(false);
				}
			}
		}
	}
}