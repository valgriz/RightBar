package com.valgriz.rightbar;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.valgriz.rightbar.screen.MainMenu;
import com.valgriz.rightbar.screen.RenderData;

public class Main extends Game {

	SpriteBatch batch;
	Texture img;
	BitmapFont font;

	public static int WIDTH = 900, HEIGHT = 1500;

	public static RenderData renderData;

	public void create () {
		renderData  = new RenderData(Main.WIDTH, Main.HEIGHT, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		setScreen(new MainMenu(this));

//		batch = new SpriteBatch();
//		img = new Texture("badlogic.jpg");
//		font = new BitmapFont();
//		stage = new Stage(new StretchViewport(WIDTH, HEIGHT));
	}

	@Override
	public void render () {
		//check if screen changed

		getScreen().render(Gdx.graphics.getDeltaTime());
//		Gdx.gl.glClearColor(1, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//		batch.begin();
//		Map map = new Map(700, 1400, 100, 100, WIDTH, HEIGHT, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
//		batch.draw(img, map.getX(), map.getY(), map.getWidth(), map.getHeight());
//		font.draw(batch, "X: "  + map.getX() + " Y: "  + map.getY() + " WIDTH: "  + map.getWidth() + " HEIGHT: "  + map.getHeight() + "\n" + "SUPPLIED: " + Gdx.graphics.getWidth() + "x" + Gdx.graphics.getHeight() + "\n"
//				+ "wsc:" +  map.getWidthScaleConstant() + ", gsar:"+  map.getGsar(), 100, 100);
//		batch.end();

	}
}
