package com.mygame;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Starter extends ApplicationAdapter {

	KeyboardAdapter inputProccesor;
	SpriteBatch batch;
	Panzer me;
	
	@Override
	public void create () {
		inputProccesor = new KeyboardAdapter();
		Gdx.input.setInputProcessor(inputProccesor);
		batch = new SpriteBatch();
		me = new Panzer(100, 100);
	}

	@Override
	public void render () {
		me.move(inputProccesor.getDirection());
		me.rotateMouse(inputProccesor.getMousePosition());
		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		me.render(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		me.dispose();
	}
}
