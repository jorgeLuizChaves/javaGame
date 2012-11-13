package com.br.game.chapter03;

public enum ConstantGame {

	HEIGHT(480),
	WIDTH(640);
	
	private int value;
	
	private ConstantGame(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
