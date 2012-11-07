package com.br.game.chapter03;

public enum ConstantGame {

	HEIGHT(640),
	WIDTH(480);
	
	private int value;
	
	private ConstantGame(int value){
		this.value = value;
	}
	
	public int getValue(){
		return value;
	}
}
