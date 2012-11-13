package com.br.game.chapter03;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
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
	private ControlShip controlShip = new ControlShip();
	private ControlBullets controlBullets = new ControlBullets();
	private ControlAsteroids controlAsteroids = new ControlAsteroids();
	private ManagerCollision managerCollision = new ManagerCollision();

	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyPressed(KeyEvent keyEvent) {
		int keyCode = keyEvent.getKeyCode();
		switch(keyCode){
		case KeyEvent.VK_LEFT:
			controlShip.moveToLeft();
			break;
		case KeyEvent.VK_RIGHT:
			controlShip.moveToRight();
			break;
		case KeyEvent.VK_UP:
			controlShip.moveToUp();
			break;
		case KeyEvent.VK_CONTROL:
		case KeyEvent.VK_ENTER:
		case KeyEvent.VK_SPACE:
			Ship playerShip = controlShip.getShip();
			controlBullets.shoot(playerShip);
			break;
		}
	}


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
			repaint();
		}
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

	@Override
	public void init(){
		int width = ConstantGame.WIDTH.getValue();
		int height = ConstantGame.HEIGHT.getValue();
		bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		graphics2d = bufferedImage.createGraphics();

		controlAsteroids.init();
		controlBullets.init();
		controlShip.init();
		addKeyListener(this);
	}

	@Override
	public void update(Graphics graphics){
		graphics2d.setTransform(affineTransform);

		graphics2d.setPaint(Color.BLACK);
		int coordinateX = 0;
		int coordinateY = 0;
		graphics2d.fillRect(coordinateX, coordinateY, getSize().width, getSize().height);
		graphics2d.setColor(Color.WHITE);

		String xyPostion = controlShip.getXYPositionToString();
		String moveAngle = controlShip.getMoveAngleToString();
		String faceAngle = controlShip.getFaceAngleToString();
		drawOnTheScreen(xyPostion, 5, 10);
		drawOnTheScreen(moveAngle, 5, 25);
		drawOnTheScreen(faceAngle, 5, 40);

		controlShip.draw(graphics2d, affineTransform);
		controlBullets.draw(graphics2d, affineTransform);
		controlAsteroids.draw(graphics2d, affineTransform);
		paint(graphics);
	}

	@Override
	public void paint(Graphics graphics){
		graphics.drawImage(bufferedImage, 0, 0, this);
	}

	private void drawOnTheScreen(String message, int positionX, int positionY) {
		graphics2d.drawString(message, positionX, positionY);

	}

	private void gameUpdate() {
		int height = getSize().height;
		int width = getSize().width;
		controlShip.update(height, width);
		controlBullets.update(height, width);
		controlAsteroids.update(height, width);

		Ship ship = controlShip.getShip();
		Bullet[] bullets = controlBullets.getBullets();
		Asteroid[] asteroids = controlAsteroids.getAsteroids();
		managerCollision.checkCollisions(ship, bullets, asteroids);
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