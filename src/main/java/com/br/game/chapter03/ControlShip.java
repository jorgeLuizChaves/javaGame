package com.br.game.chapter03;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public class ControlShip implements Controlable {

	private Ship ship;
	
	@Override
	public void setup() {
		ship = new Ship();
		ship.setPositionX(320);
		ship.setPositionY(240);
	}

	@Override
	public void draw(Graphics2D graphics2d, AffineTransform affineTransform) {
		graphics2d.setTransform(affineTransform);
		graphics2d.translate(ship.getPositionX(), ship.getPositionY());
		graphics2d.rotate(Math.toRadians(ship.getFaceAngle()));
		graphics2d.fill(ship.getShape());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}
}