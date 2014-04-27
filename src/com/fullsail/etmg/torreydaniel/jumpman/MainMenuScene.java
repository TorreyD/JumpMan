package com.fullsail.etmg.torreydaniel.jumpman;

import org.andengine.entity.scene.menu.MenuScene;
import org.andengine.entity.scene.menu.MenuScene.IOnMenuItemClickListener;
import org.andengine.entity.scene.menu.item.IMenuItem;
import org.andengine.entity.scene.menu.item.SpriteMenuItem;
import org.andengine.entity.scene.menu.item.decorator.ScaleMenuItemDecorator;
import org.andengine.entity.sprite.Sprite;
import org.andengine.opengl.util.GLState;
import org.andengine.engine.camera.Camera;

import com.fullsail.etmg.torreydaniel.jumpman.SceneManager.SceneType;

public class MainMenuScene extends BaseScene implements IOnMenuItemClickListener
{
	private MenuScene menuChildScene;
	private final int MENU_PLAY = 0;
	
	GPSTracker gps;
	
	private void createMenuChildScene()
	{
		menuChildScene = new MenuScene(camera);
		menuChildScene.setPosition(0f, 0f);
		
		final IMenuItem playMenuItem = new ScaleMenuItemDecorator(
				new SpriteMenuItem(MENU_PLAY, resourceManager.play_region, vbom), 1.2f, 1);
		
		menuChildScene.addMenuItem(playMenuItem);
		
		menuChildScene.buildAnimations();
		menuChildScene.setBackgroundEnabled(false);
		
		playMenuItem.setPosition(playMenuItem.getX(), playMenuItem.getY() - 30);
	
		menuChildScene.setOnMenuItemClickListener(this);
		
		setChildScene(menuChildScene);
	}

	@Override
	public void createScene() 
	{
		createBackGround();
		createMenuChildScene();
	}

	@Override
	public void onBackKeyPressed() 
	{
		System.exit(0);
	}

	@Override
	public SceneType getSceneType() 
	{
		return SceneType.SCENE_MENU;
	}

	@Override
	public void disposeScene() 
	{
		
	}
	
	private void createBackGround()
	{
		attachChild(new Sprite(400, 240, resourceManager.menu_background_region, vbom)
		{
			protected void preDraw(GLState pGLState, Camera pCamera)
			{
				super.preDraw(pGLState, pCamera);
				pGLState.enableDither();
			}
		});
	}

	@Override
	public boolean onMenuItemClicked(MenuScene pMenuScene, IMenuItem pMenuItem,
			float pMenuItemLocalX, float pMenuItemLocalY) 
	{
		switch (pMenuItem.getID())
		{
			case MENU_PLAY:
				//Load Game Scene
	            SceneManager.getInstance().loadGameScene(engine);
				return true;
			default:
				return false;
		}
	}
}
