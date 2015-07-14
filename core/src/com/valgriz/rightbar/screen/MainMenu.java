package com.valgriz.rightbar.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.valgriz.rightbar.Main;


/**
 * Created by Steven on 7/9/2015.
 */
public class MainMenu implements Screen {

	private SpriteBatch batch;

	private Texture backdrop;
	private Texture logoTop;
	private Texture logoBot;
	private Texture buttons;
	private TextureRegion[] buttonRegions = new TextureRegion[3];

	private BitmapFont bitmapFont;

	private Map mapBackdrop;
	private Map mapBadLogic;
	private Map mapLogoTop;
	private Map mapLogoBot;
	private Map mapButtonPlay;
	private Map mapButtonScores;
	private Map mapButtonHelp;

	private Main main;

	int lastTouchX;
	int lastTouchY;

	String note;

	public MainMenu(Main main){
		this.main = main;

		batch = new SpriteBatch();
		backdrop = new Texture("menu/backdrop.png");
		logoTop = new Texture("menu/logo_top.png");
		logoBot = new Texture("menu/logo_bot.png");
		buttons = new Texture("menu/menu_buttons.png");

		buttonRegions[0] = new TextureRegion(buttons, 0, 0, 648, 151);
		buttonRegions[1] = new TextureRegion(buttons, 0, 151, 648, 151);
		buttonRegions[2] = new TextureRegion(buttons, 0, 302, 648, 151);

		mapBackdrop = new Map(0,0,900, 1500, Main.renderData, Map.STRETCH_Y);
		mapLogoTop = new Map(0, 800,900,787, Main.renderData, Map.NO_STRETCH);
		mapLogoBot = new Map(0, 0,900,612, Main.renderData, Map.NO_STRETCH);

		mapButtonPlay = new Map(126, 600, 648, 151, Main.renderData, Map.NO_STRETCH);
		mapButtonScores = new Map(126, 350 , 648, 151, Main.renderData, Map.NO_STRETCH);
		mapButtonHelp = new Map(126, 100, 648, 151, Main.renderData, Map.NO_STRETCH);

		bitmapFont = new BitmapFont();
	}

	public void show() {


	}

	public void update(){
		if(Gdx.input.justTouched()){
			lastTouchX = Gdx.input.getX();
			lastTouchY = Gdx.input.getY();
			if(mapButtonPlay.contains(lastTouchX, lastTouchY)){
				note = "Play Pressed";
				main.setScreen(new Game(main));
			} else if (mapButtonScores.contains(lastTouchX, lastTouchY)){
				note = "Scores Pressed";
			} else if (mapButtonHelp.contains(lastTouchX, lastTouchY)){
				note = "Help Pressed";
			} else {
				note = null;
			}
		}
	}

	public void render(float delta) {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		update();

		batch.begin();

		batch.draw(backdrop, mapBackdrop.getOutputX(), mapBackdrop.getOutputY(), mapBackdrop.getOutputWidth(), mapBackdrop.getOutputHeight());
		batch.draw(logoTop, mapLogoTop.getOutputX(), mapLogoTop.getOutputY(), mapLogoTop.getOutputWidth(), mapLogoTop.getOutputHeight());
		//batch.draw(logoBot, mapLogoBot.getOutputX(), mapLogoBot.getOutputY(), mapLogoBot.getOutputWidth(), mapLogoBot.getOutputHeight());

		batch.draw(buttonRegions[0], mapButtonPlay.getOutputX(), mapButtonPlay.getOutputY(), mapButtonPlay.getOutputWidth(), mapButtonPlay.getOutputHeight());
		batch.draw(buttonRegions[1], mapButtonScores.getOutputX(), mapButtonScores.getOutputY(), mapButtonScores.getOutputWidth(), mapButtonScores.getOutputHeight());
		batch.draw(buttonRegions[2], mapButtonHelp.getOutputX(), mapButtonHelp.getOutputY(), mapButtonHelp.getOutputWidth(), mapButtonHelp.getOutputHeight());

		bitmapFont.setColor(Color.RED);
		bitmapFont.draw(batch, "gameWidth:" + Main.renderData.gameWidth+ ", gameHeight:" + Main.renderData.gameHeight +
				"\nscreenWidth:" + Gdx.graphics.getWidth()+", screenHeight:" + Gdx.graphics.getHeight() +
				"\nheightScaleConstant:" + mapBackdrop.getHeightScaleConstant() +
				"\nwidthScaleConstant:" + mapBackdrop.getWidthScaleConstant() +
				"\nTURT_COORDS: X:" + mapLogoTop.getInputX() + ":" + mapLogoTop.getOutputX() + " Y:" + mapLogoTop.getInputY() + ":" + mapLogoTop.getOutputY() +
				"\nscreenAspectConstant:" + mapLogoTop.getScreenAspectConstant() + "\ngameAspectConstant:" +mapLogoTop.getGameAspectConstant() +",gsar:" + mapLogoTop.getGsar() +
				"\nTOUCH_X:" + lastTouchX + ", TOUCH_Y:" + lastTouchY +
				"\nnote:" + note, 50, 200);



		batch.end();

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
