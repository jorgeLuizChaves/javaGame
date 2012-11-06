package com.br.game.chapter03;

import java.applet.Applet;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

public class GameAsteroids extends Applet implements Runnable, KeyListener{

	private static final long serialVersionUID = -4042446149548339638L;
	private static final int TWENTY_MILLISECONDS = 20;
	private Random random = new Random();
	private AffineTransform affineTransform = new AffineTransform();
	private Thread gameloop;
	private BufferedImage bufferedImage;
	private Graphics2D graphics2d;
	private boolean showBounds;

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}
	
	@Override
	public void keyPressed(KeyEvent e) {}


	@Override
	public void run() {
		Thread currentThread = Thread.currentThread();
		while(currentThread == gameloop){
			try{
				gameUpdate();
				Thread.sleep(TWENTY_MILLISECONDS);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		repaint();
	}
	
	@Override
	public void start(){
		gameloop = new Thread(this);
		gameloop.start();
	}
	
	@Override
	public void stop(){
		gameloop = null;
	}

	private void gameUpdate() {
		
	}

	public Thread getGameloop() {
		return gameloop;
	}

	public void setGameloop(Thread gameloop) {
		this.gameloop = gameloop;
	}

	public BufferedImage getBufferedImage() {
		return bufferedImage;
	}

	public void setBufferedImage(BufferedImage bufferedImage) {
		this.bufferedImage = bufferedImage;
	}

	public Graphics2D getGraphics2d() {
		return graphics2d;
	}

	public void setGraphics2d(Graphics2D graphics2d) {
		this.graphics2d = graphics2d;
	}

	public boolean isShowBounds() {
		return showBounds;
	}

	public void setShowBounds(boolean showBounds) {
		this.showBounds = showBounds;
	}

	public AffineTransform getAffineTransform() {
		return affineTransform;
	}

	public void setAffineTransform(AffineTransform affineTransform) {
		this.affineTransform = affineTransform;
	}

	public Random getRandom() {
		return random;
	}

	public void setRandom(Random random) {
		this.random = random;
	}
	
}