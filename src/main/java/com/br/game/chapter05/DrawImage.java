package com.br.game.chapter05;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import com.br.game.util.GameAppletUtil;

public class DrawImage extends Applet {

	private static final long serialVersionUID = -4219929228896481506L;
	private static final String CASTLE_PNG = "castle.png";

	private Image image;

	@Override
	public void init(){
		URL url = getURL(CASTLE_PNG);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		image = toolkit.getImage(url);
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
		 url = getURLByClass(fileName);
		return url;
	}

	private URL getURLByClass(String fileName) {
		GameAppletUtil gameAppletUtil = GameAppletUtil.getInstance();
		return gameAppletUtil.getURL(this.getClass(), fileName);
	}

}