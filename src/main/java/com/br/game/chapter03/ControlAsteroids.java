package com.br.game.chapter03;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class ControlAsteroids implements Controlable {

	private static int ASTEROIDS = 20;
	Asteroid[] asteroids = new Asteroid[ASTEROIDS];
	private Random random = new Random();
	
	public Asteroid[] getAsteroids() {
		return asteroids;
	}

	public void setAsteroids(Asteroid[] asteroids) {
		this.asteroids = asteroids;
	}

	@Override
	public void init() {
		for(int cont=0; cont < ASTEROIDS; cont++){
			Asteroid asteroid = new Asteroid();

			double rotationVelocity = (random.nextInt(3) + 1);
			double positionX = (double)(random.nextInt(600) + 20);
			double positionY = (double) (random.nextInt(440) + 20);
			double moveAngle = (random.nextInt(360));
			double velocityX = GameMath.calculateAngleMoveX(moveAngle - 90);
			double velocityY = GameMath.calculateAngleMoveY(moveAngle - 90);

			asteroid.setRotationVelocity(rotationVelocity);
			asteroid.setPositionX(positionX);
			asteroid.setPositionY(positionY);
			asteroid.setMoveAngle(moveAngle);
			asteroid.setVelocityX(velocityX);
			asteroid.setVelocityY(velocityY);
			asteroids[cont] = asteroid ;
		}
	}

	@Override
	public void draw(Graphics2D graphics2d, AffineTransform affineTransform) {
		for(Asteroid asteroid: asteroids){
			if(asteroid.isAlive()){
				graphics2d.setTransform(affineTransform);
				graphics2d.translate(asteroid.getPositionX(), asteroid.getPositionY());
				graphics2d.rotate(Math.toRadians(asteroid.getMoveAngle()));
				graphics2d.setColor(Color.LIGHT_GRAY);
				graphics2d.fill(asteroid.getShape());
			}
		}
	}

	@Override
	public void update(int height, int width){
		for (Asteroid asteroid : asteroids) {
			if(asteroid.isAlive()){
				double valueX = asteroid.getVelocityX();
				asteroid.incrementPositionX(valueX);
				if(asteroid.getPositionX() < -20){
					asteroid.setPositionX(width + 20);
				}else if(asteroid.getPositionX() > (width + 20)){
					asteroid.setPositionX(-20);
				}
				
				double valueY = asteroid.getVelocityY();
				asteroid.incrementPositionY(valueY);
				if(asteroid.getPositionY() < -20){
					asteroid.setPositionY(height + 20);
				}else if(asteroid.getPositionY() > (height + 20)){
					asteroid.setPositionY(-20);
				}
				
				double rotationVelocity = asteroid.getRotationVelocity();
				asteroid.incrementFaceAngle(rotationVelocity);
				
				double moveAngle;
				if(asteroid.getMoveAngle() < 0){
					moveAngle = 360 - asteroid.getRotationVelocity();
					asteroid.setMoveAngle(moveAngle);
				}else if(asteroid.getMoveAngle() > 360){
					moveAngle = asteroid.getRotationVelocity();
					asteroid.setMoveAngle(moveAngle);
				}
			}
		}
	}
}