package com.br.game.chapter03;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class ControlBullets implements Controlable {

	private static int BULLETS = 10;
	private Bullet[] bullets = new Bullet[BULLETS];
	private int currentBullet = 0;
	
	public Bullet[] getBullets() {
		return bullets;
	}

	public void setBullets(Bullet[] bullets) {
		this.bullets = bullets;
	}

	public int getCurrentBullet() {
		return currentBullet;
	}

	public void setCurrentBullet(int currentBullet) {
		this.currentBullet = currentBullet;
	}

	@Override
	public void init() {
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
	public void update(int height, int width){
		for (Bullet bullet : bullets) {
			if(bullet.isAlive()){
				double valuePositionX = bullet.getVelocityX();
				bullet.incrementPositionX(valuePositionX);
				if(bullet.getPositionX() < 0 || bullet.getPositionX() > width){
					bullet.setAlive(false);
				}
				
				double valuePositionY = bullet.getVelocityY();
				bullet.incrementPositionY(valuePositionY);
				if(bullet.getPositionY() < 0 || bullet.getPositionY() > height){
					bullet.setAlive(false);
				}
			}
		}
	}

	public void shoot(Ship ship) {
		currentBullet++;
		if(currentBullet > BULLETS - 1){
			currentBullet = 0;
		}
		bullets[currentBullet].setAlive(true);
		bullets[currentBullet].setPositionX(ship.getPositionX());
		bullets[currentBullet].setPositionY(ship.getPositionY());
		bullets[currentBullet].setMoveAngle(ship.getFaceAngle() - 90);
		
		double angle = bullets[currentBullet].getMoveAngle();
		double velocityX = ship.getVelocityX();
		double velocityY = ship.getVelocityY();
		
		bullets[currentBullet].setVelocityX(velocityX + GameMath.calculateAngleMoveX(angle) * 2);
		bullets[currentBullet].setVelocityY(velocityY + GameMath.calculateAngleMoveY(angle) * 2);
	}
}