package com.br.game.chapter03;

public class GameMath {

	public static double calculateAngleMoveX(double moveAngle) {
		return (double) (Math.cos(moveAngle * Math.PI / 180));
	}

	public static double calculateAngleMoveY(double moveAngle) {
		return (double) (Math.sin(moveAngle * Math.PI / 180));
	}
}