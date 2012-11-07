package com.br.game.chapter03;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

public class ControlAsteroids implements Controlable {

	private static int ASTEROIDS = 20;
	Asteroid[] asteroids = new Asteroid[ASTEROIDS];
	private Random random = new Random();

	@Override
	public void setup() {
		for(int cont=0; cont < ASTEROIDS; cont++){
			Asteroid asteroid = new Asteroid();

			double rotationVelocity = (random.nextInt(3) + 1);
			double positionX = (double)(random.nextInt(600) + 20);
			double positionY = (double) (random.nextInt(440) + 20);
			double moveAngle = (random.nextInt(360));
			double velocityX = calculateAngleMoveX(moveAngle);
			double velocityY = calculateAngleMoveY(moveAngle);

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
				graphics2d.setColor(Color.WHITE);
				graphics2d.fill(asteroid.getShape());
			}
		}
	}

	@Override
	public void update() {

	}

	private double calculateAngleMoveX(double moveAngle) {
		return (double) (Math.cos((moveAngle - 90) * Math.PI / 180));
	}

	private double calculateAngleMoveY(double moveAngle) {
		moveAngle -= 90;
		return (double) (Math.sin((moveAngle - 90) * Math.PI / 180));
	}

}