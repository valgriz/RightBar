package com.valgriz.rightbar.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.valgriz.rightbar.Main;

/**
 * Created by Steven on 7/10/2015.
 */
public class Splash implements Screen {

	private SpriteBatch batch;
	private Sprite splash;
	private Texture splashTexture;
	private Map mapBadLogic;
	private Map mapLogoTop;
	private Map mapLogoBot;
	private Main main;
	private double dx, dy;

	public Splash(Main main){
		this.main = main;
	}

	public void show() {
		batch = new SpriteBatch();
		splashTexture = new Texture("bounce1.png");
		mapBadLogic = new Map(100,100,100,100, Main.renderData, Map.NO_STRETCH);

		dx = 5;
		dy = 5;
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 1, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		update();
		batch.begin();

		batch.draw(splashTexture, mapBadLogic.getOutputX(), mapBadLogic.getOutputY(), mapBadLogic.getOutputWidth(), mapBadLogic.getOutputHeight());


		batch.end();
	}

	public void update(){
		mapBadLogic.updateX(mapBadLogic.getInputX() + (int)dx);
		mapBadLogic.updateY(mapBadLogic.getInputY() + (int)dy);

		if(mapBadLogic.getInputX() + mapBadLogic.getInputWidth() > Main.WIDTH){
			dx = -dx;
			main.setScreen(new MainMenu(main));
		} else if(mapBadLogic.getInputX() <= 0){
			dx = -dx;
		}

		if(mapBadLogic.getInputY() + mapBadLogic.getInputHeight() > Main.HEIGHT){
			dy = -dy;
		} else if(mapBadLogic.getInputY() <= 0){
			dy = -dy;
		}

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}
}
