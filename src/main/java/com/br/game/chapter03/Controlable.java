package com.br.game.chapter03;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public interface Controlable {

	void setup();
	void draw(Graphics2D graphics2d, AffineTransform affineTransform);
	void update();
}
