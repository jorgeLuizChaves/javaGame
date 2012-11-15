package com.br.game.chapter03;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class ControlShip implements Controlable {

	private Ship ship;
	
	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	@Override
	public void init() {
		ship = new Ship();
		ship.setPositionX(320);
		ship.setPositionY(240);
	}

	@Override
	public void draw(Graphics2D graphics2d, AffineTransform affineTransform) {
		graphics2d.setTransform(affineTransform);
		graphics2d.translate(ship.getPositionX(), ship.getPositionY());
		graphics2d.rotate(Math.toRadians(ship.getFaceAngle()));
		graphics2d.setColor(Color.BLUE);
		graphics2d.fill(ship.getShape());
	}

	@Override
	public void update(int height, int width) {
		double valueX = ship.getVelocityX();
		ship.incrementPositionX(valueX );
		if(ship.getPositionX() < -10){
			double positionX = width + 10;
			ship.setPositionX(positionX);
		}else if(ship.getPositionX() > width + 10){
			ship.setPositionX(-10);
		}
		
		double valueY = ship.getVelocityY();
		ship.incrementPositionY(valueY);
		if(ship.getPositionY() < - 10){
			ship.setPositionY(height + 10);
		}else if(ship.getPositionY() > (height + 10)){
			ship.setPositionY(-10);
		}
	}
	
	public String getXYPositionToString(){
		return "Ship: " + Math.round(ship.getPositionX()) + ", " + Math.round(ship.getPositionY());
	}
	
	public String getMoveAngleToString(){
		return "Move Angle: " + Math.round(ship.getMoveAngle() + 90);
	}
	
	public String getFaceAngleToString(){
		return "Face Angle: " + Math.round(ship.getFaceAngle());
	}
	
	public void moveToLeft(){
		ship.incrementFaceAngle(-5);
		if(ship.getFaceAngle() < 0 )
			ship.setFaceAngle(360 - 5);
	}
	
	public void moveToRight(){
		ship.incrementFaceAngle(5);
		if(ship.getFaceAngle() > 360)
			ship.setFaceAngle(5);
	}
	
	public void moveToUp(){
		ship.setMoveAngle(ship.getFaceAngle() - 90);
		double velocityX = GameMath.calculateAngleMoveX(ship.getMoveAngle());
		double velocityY = GameMath.calculateAngleMoveY(ship.getMoveAngle());
		velocityX *= 0.1;
		velocityY *= 0.1;
		ship.incrementVelocityX(velocityX);
		ship.incrementVelocityY(velocityY);
	}
}