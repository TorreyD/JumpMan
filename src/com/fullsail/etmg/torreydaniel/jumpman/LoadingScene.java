package com.fullsail.etmg.torreydaniel.jumpman;

import org.andengine.entity.scene.background.Background;
import org.andengine.entity.text.Text;

import com.fullsail.etmg.torreydaniel.jumpman.SceneManager.SceneType;

public class LoadingScene extends BaseScene
{

	@Override
	public void createScene() 
	{
		//setBackground(new Background(Color.WHITE));
		setBackground(new Background(getColor().WHITE));
		attachChild(new Text(400, 240, resourceManager.font, "Loading...", vbom));
	}

	@Override
	public void onBackKeyPressed() 
	{
		return;
	}

	@Override
	public SceneType getSceneType() 
	{
		return SceneType.SCENE_LOADING;
	}

	@Override
	public void disposeScene() 
	{
		
	}
}
