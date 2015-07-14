package com.valgriz.rightbar.screen;

/**
 * Created by Steven on 7/8/2015.
 */
public class Map {
	private int inputX, inputY, inputWidth, inputHeight;
	private int outputX, outputY, outputWidth, outputHeight;
	private double widthScaleConstant, heightScaleConstant, gsar;
	public static final int NO_STRETCH = 0;
	public static final int STRETCH_X = 1;
	public static final int STRETCH_Y = 2;
	public static final int STRETCH_BOTH = 3;
	private int displayOptions;
	private double gameAspectConstant;
	private double screenAspectConstant;

	public Map(int inputX, int inputY, int inputWidth, int inputHeight, int gameWidth, int gameHeight, int screenWidth, int screenHeight, int displayOptions){
		this.displayOptions = displayOptions;
		updateWidthScaleConstant(gameWidth, screenWidth);
		updateHeightScaleConstant(gameHeight, screenHeight);
		updateGsar(gameWidth, gameHeight, screenWidth, screenHeight);
		updateX(inputX);
		updateY(inputY);
		updateWidth(inputWidth);
		updateHeight(inputHeight);
	}

	public Map(int inputX, int inputY, int inputWidth, int inputHeight, RenderData renderData, int displayOptions){
		this.displayOptions = displayOptions;
		updateWidthScaleConstant(renderData.getGameWidth(), renderData.getScreenWidth());
		updateHeightScaleConstant(renderData.getGameHeight(), renderData.getScreenHeight());
		updateGsar(renderData.getGameWidth(), renderData.getGameHeight(), renderData.getScreenWidth(), renderData.getScreenHeight());
		updateX(inputX);
		updateY(inputY);
		updateWidth(inputWidth);
		updateHeight(inputHeight);


	}

	public void updateWidthScaleConstant(int gameWidth, int screenWidth){
		widthScaleConstant = Double.valueOf(screenWidth)/Double.valueOf(gameWidth);
	}

	public void updateHeightScaleConstant(int gameHeight, int screenHeight){
		heightScaleConstant = Double.valueOf(screenHeight)/Double.valueOf(gameHeight);
	}

	public void updateGsar( int gameWidth, int gameHeight, int screenWidth, int screenHeight){
		gameAspectConstant = Double.valueOf(gameHeight)/Double.valueOf(gameWidth);
		screenAspectConstant = Double.valueOf(screenHeight)/Double.valueOf(screenWidth);

		//game to screen aspect ratio
		// .666 < gsar < 1.334
		gsar = screenAspectConstant/gameAspectConstant;
	}

	public double getGameAspectConstant() {
		return gameAspectConstant;
	}

	public double getScreenAspectConstant() {
		return screenAspectConstant;
	}

	public void updateX(int x){
		this.inputX = x;
		outputX = (int) (inputX * widthScaleConstant);
	}

	public void updateY(int y){
		this.inputY = y;
		outputY = (int) (inputY * heightScaleConstant * gsar);
	}

	public void updateWidth(int width){
		this.inputWidth = width;
		outputWidth = (int) (inputWidth * widthScaleConstant);
	}

	public void updateHeight(int height){
		this.inputHeight = height;
		if(displayOptions==0 || displayOptions==1){
			outputHeight = (int) (inputHeight * widthScaleConstant);
		} else if (displayOptions==2 || displayOptions==3) {
			outputHeight = (int) (inputHeight * heightScaleConstant);
		}
	}

	public double getHeightScaleConstant() {
		return heightScaleConstant;
	}

	public double getWidthScaleConstant(){
		return widthScaleConstant;
	}

	public double getGsar(){
		return gsar;
	}

	public int getInputX() {
		return inputX;
	}

	public int getInputY() {
		return inputY;
	}

	public int getInputWidth() {
		return inputWidth;
	}

	public int getInputHeight() {
		return inputHeight;
	}

	public int getOutputX() {
		return outputX;
	}

	public int getOutputY() {
		return outputY;
	}

	public int getOutputWidth() {
		return outputWidth;
	}

	public int getOutputHeight() {
		return outputHeight;
	}
}
