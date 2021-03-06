package net.jgnetworks.earthdefender.level;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

import net.jgnetworks.earthdefender.EarthDefender;

public class MainMenuScreen extends Level {

	final EarthDefender game;
	private SpriteBatch batch;
	
	public Rectangle startBtn;
	public Rectangle endAnimBtn;
	private Rectangle title;
	private Rectangle earth;
	
	private Texture startImage;
	private Texture titleImage;
	private Texture earthImage;
	private Texture endAnimBtnImage;
	private Texture background;
	
	private float bgY;
	private long bgScroll;
	
	public MainMenuScreen(final EarthDefender passedGame) {
		game = passedGame;
		game.input.setMenuScreen(this);
		game.currentLevel = this;
		
		batch = new SpriteBatch();
		loadTextures();
		
		title = new Rectangle();
		title.width = 300;
		title.height = 100;
		title.x = 480/2 - title.width/2;
		title.y = 580;
		
		startBtn = new Rectangle();
		startBtn.width = 170;
		startBtn.height = 44;
		startBtn.x = 480/2 - startBtn.width/2;
		startBtn.y = 530;
		
		endAnimBtn = new Rectangle();
		endAnimBtn.width = 170;
		endAnimBtn.height = 44;
		endAnimBtn.x = 480/2 - endAnimBtn.width/2;
		endAnimBtn.y = 470;
		
		earth = new Rectangle();
		earth.width = 299;
		earth.height = 279;
		earth.x = 480/2 - earth.width/2;
		earth.y = earth.height/2;
		
		bgY = 720;
		bgScroll = game.currentTime;
	}
	
	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		setBg();
		
		game.camera.update();
		batch.setProjectionMatrix(game.camera.combined);
		batch.begin();
		batch.draw(background, 0, bgY-720);
		batch.draw(background, 0, bgY);
		batch.draw(titleImage, title.x, title.y);
		batch.draw(startImage, startBtn.x, startBtn.y);
		batch.draw(endAnimBtnImage, endAnimBtn.x, endAnimBtn.y);
		batch.draw(earthImage, earth.x, earth.y);
		batch.end();
	}
	
	private void loadTextures() {
		startImage = new Texture(Gdx.files.internal("startbutton.png"));
		titleImage = new Texture(Gdx.files.internal("title.png"));
		earthImage = new Texture(Gdx.files.internal("earth/earth.png"));
		endAnimBtnImage = new Texture(Gdx.files.internal("endbutton.png")); 
		background = new Texture(Gdx.files.internal("background.png"));
	}
	
	private void setBg() {
		if(game.currentTime - bgScroll > 10000000) {
			bgY -= 1;
			bgScroll = game.currentTime;
		}
		if(bgY == 0){
			bgY = 720;
		}
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		batch.dispose();
	}

}
