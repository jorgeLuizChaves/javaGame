package com.br.game.chapter03;

public class ManagerCollision {
	public void checkCollisions(Ship ship, Bullet[] bullets, Asteroid[] asteroids){
		for(Asteroid asteroid: asteroids){
			if(asteroid.isAlive()){
				for(Bullet bullet: bullets){
					if(bullet.isAlive()){
						if(asteroid.getBounds().contains(bullet.getPositionX(), bullet.getPositionY())){
							bullet.setAlive(false);
							asteroid.setAlive(false);
							continue;
						}
					}
				}
				
				if(asteroid.getBounds().intersects(ship.getBounds())){
					asteroid.setAlive(false);
					ship.setPositionX(320);
					ship.setPositionY(240);
					ship.setFaceAngle(0);
					ship.setVelocityX(0);
					ship.setVelocityY(0);
					continue;
				}
			}
		}
	}
}