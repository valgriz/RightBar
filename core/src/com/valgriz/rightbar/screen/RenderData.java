package com.valgriz.rightbar.screen;

/**
 * Created by Steven on 7/10/2015.
 */
public class RenderData {
	int gameWidth, gameHeight, screenWidth, screenHeight;

	public RenderData(int gameWidth, int gameHeight, int screenWidth, int screenHeight){
		this.gameWidth = gameWidth;
		this.gameHeight = gameHeight;
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}

	public int getGameWidth() {
		return gameWidth;
	}

	public int getGameHeight() {
		return gameHeight;
	}

	public int getScreenWidth() {
		return screenWidth;
	}

	public int getScreenHeight() {
		return screenHeight;
	}
}
