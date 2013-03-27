package com.br.game.util;

import java.applet.Applet;
import java.net.URL;

public class GameAppletUtil{

	private static GameAppletUtil gameAppletUtil;
	
	private GameAppletUtil(){
		super();
	}
	
	public static GameAppletUtil getInstance(){
		if(gameAppletUtil != null){
			return gameAppletUtil;
		}
		gameAppletUtil = new GameAppletUtil();
		return gameAppletUtil;
	}
	
	@Deprecated
	public URL getURL(String resource){
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		return classLoader.getResource(resource);
	}
	
	public URL getURL(Class<? extends Applet> klass, String fileName){
		return klass.getResource(fileName);
	}
	
}