package com.br.game.chapter03;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

public interface Controlable {

	void init();
	void update(int height, int width);
	void draw(Graphics2D graphics2d, AffineTransform affineTransform);
}