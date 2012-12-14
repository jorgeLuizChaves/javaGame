package com.br.game.chapter05;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.net.URL;

public class DrawImage extends Applet {

	private static final String CASTLE_PNG = "castle.png";
	private static final String COM_BR_GAME_CHAPTER05 = "com/br/game/chapter05/";

	private static final long serialVersionUID = -1751612774608925567L;

	private Image image;

	@Override
	public void init(){
		URL url = getURL(CASTLE_PNG);
		image = getImage(url);
	}

	@Override
	public void paint(Graphics graphics){
		Graphics2D graphics2d = (Graphics2D) graphics;
		graphics2d.setColor(Color.BLACK);
		int coordinateX = 0, coordinateY = 0;
		int width = getSize().width;
		int height = getSize().height;

		graphics2d.fillRect(coordinateX, coordinateY, width, height);
		graphics2d.drawImage(image, coordinateX, coordinateY, this);
	}

	private URL getURL(String fileName){
		URL url = null;
		// png file must be in the .class folder
		// url = this.getClass().getResource(fileName);
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		url = classLoader.getResource(COM_BR_GAME_CHAPTER05 + fileName);
		return url;
	}
}