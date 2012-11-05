package com.br.game.chapter03;

import java.awt.Rectangle;
import java.awt.Shape;

public abstract class BaseVectorShape {
	
	private Shape shape;
	private boolean alive;
	private double positionX;
	private double positionY;
	private double velocityX;
	private double velocityY;
	private double moveAngle;
	private double faceAngle;
	
	public Shape getShape() {
		return shape;
	}
	
	public void setShape(Shape shape) {
		this.shape = shape;
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public void setAlive(boolean alive) {
		this.alive = alive;
	}
	
	public double getPositionX() {
		return positionX;
	}
	
	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}
	
	public double getPositionY() {
		return positionY;
	}
	
	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}
	
	public double getVelocityX() {
		return velocityX;
	}
	
	public void setVelocityX(double velocityX) {
		this.velocityX = velocityX;
	}
	
	public double getVelocityY(){
		return velocityY;
	}
	
	public void setVelocityY(double velocityY){
		this.velocityY = velocityY;
	}
	
	public double getMoveAngle() {
		return moveAngle;
	}
	
	public void setMoveAngle(double moveAngle) {
		this.moveAngle = moveAngle;
	}
	
	public double getFaceAngle() {
		return faceAngle;
	}
	
	public void setFaceAngle(double faceAngle) {
		this.faceAngle = faceAngle;
	}
	
	public void incrementPositionX(double value){
		this.positionX += value;
	}
	
	public void incrementPositionY(double value){
		this.positionY += value;
	}
	
	public void incrementVelocityX(double value){
		this.velocityX += value;
	}
	
	public void incrementVelocityY(double value){
		this.velocityY += value;
	}
	
	public void incrementFaceAngle(double value){
		this.faceAngle += value;
	}
	
	public void incrementMoveAngle(double value){
		this.moveAngle += value;
	}
	
	public abstract Rectangle getBounds();

}
